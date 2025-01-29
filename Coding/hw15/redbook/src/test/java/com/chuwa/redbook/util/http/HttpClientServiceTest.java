package com.chuwa.redbook.util.http;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class HttpClientServiceTest {


    private String baseUrl;
    private String path;
    private Map<String, String> headers;
    private int connectTimeout;
    private int readTimeout;

    @BeforeEach
    void setUp() {
        // Set up mock objects and test data
        baseUrl = "http://localhost:8080";
        path = "/api/v1/comments";
        headers = new HashMap<>();
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        connectTimeout = 5000;
        readTimeout = 5000;

    }

    @Test
    void testGetHttpResponse() throws Exception {
        HttpClientService httpClientService = new HttpClientService();
        ObjectMapper objectMapper = new ObjectMapper();

        String jsonResponse = "{\"key\":\"value\"}";
        try (MockedConstruction<URL> mockedURL = mockConstruction(URL.class, (mockURL, context) -> {
            // 创建模拟的 HttpURLConnection
            HttpURLConnection mockConnection = mock(HttpURLConnection.class);

            // 模拟连接的行为
            when(mockConnection.getResponseCode()).thenReturn(HttpURLConnection.HTTP_OK);

            InputStream inputStream = new ByteArrayInputStream(jsonResponse.getBytes());
            when(mockConnection.getInputStream()).thenReturn(inputStream);
            when(mockURL.openConnection()).thenReturn(mockConnection);
        })) {
            JsonNode result = httpClientService.getHttpResponse(baseUrl, path, headers, connectTimeout, readTimeout);
            // 验证响应
            assertNotNull(result);
            assertEquals(objectMapper.readTree(jsonResponse), result);
        }
    }
}
