package com.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.HttpClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.powermock.modules.junit.jupiter.PowerMockExtension;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@org.junit.jupiter.api.extension.ExtendWith(PowerMockExtension.class)
class HttpClientServiceTest {

    private HttpURLConnection mockConnection;

    @BeforeEach
    void setUp() {
        mockConnection = mock(HttpURLConnection.class);
    }

    @Test
    void testGetHttpResponse() throws Exception {
        String baseUrl = "https://api.github.com";
        String path = "/users/thaminmg/repos?page=1";
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");

        int connectTimeout = 5000;
        int readTimeout = 5000;
        String mockResponseData = "[{\"id\": 12345, \"name\": \"mock-repo\"}]";

        try (MockedStatic<URL> mockedUrl = Mockito.mockStatic(URL.class)) {
            URL url = mock(URL.class);
            mockedUrl.when(() -> new URL(baseUrl + path)).thenReturn(url);
            when(url.openConnection()).thenReturn(mockConnection);
            when(mockConnection.getResponseCode()).thenReturn(HttpURLConnection.HTTP_OK);
            when(mockConnection.getInputStream()).thenReturn(
                    new java.io.ByteArrayInputStream(mockResponseData.getBytes())
            );

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode result = HttpClientService.getHttpResponse(baseUrl, path, headers, connectTimeout, readTimeout);

            assertNotNull(result);
        }

        verify(mockConnection).disconnect();
    }
}
