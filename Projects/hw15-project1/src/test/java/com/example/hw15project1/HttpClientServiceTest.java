package com.example.hw15project1;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.api.mockito.PowerMockito;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({HttpClientService.class, URL.class})
public class HttpClientServiceTest {
    @Mock
    private HttpURLConnection mockConnection;

    @Before
    public void setup() throws Exception {
        // Mock URL behavior
        URL mockUrl = PowerMockito.mock(URL.class);
        PowerMockito.whenNew(URL.class).withArguments("http://example.com").thenReturn(mockUrl);
        // Mock HttpURLConnection behavior
        PowerMockito.when(mockUrl.openConnection()).thenReturn(mockConnection);
    }

    @Test
    public void testGetHttpResponse() throws Exception {
        // Mock API response JSON
        String mockJsonResponse = "{\"message\": \"Success\"}";
        InputStream mockInputStream = new ByteArrayInputStream(mockJsonResponse.getBytes());

        // Stub connection methods
        when(mockConnection.getInputStream()).thenReturn(mockInputStream);
        when(mockConnection.getResponseCode()).thenReturn(200);

        // Execute the method
        JsonNode response = HttpClientService.getHttpResponse(
                "http://mock-api.com", "/data", Collections.emptyMap(), 5000, 5000);

        // Verify output
        assertEquals("Success", response.get("message").asText());

        // Verify connection methods were called
        verify(mockConnection).setRequestMethod("GET");
        verify(mockConnection).disconnect();

    }
}
