package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.api.mockito.PowerMockito;


import java.io.BufferedReader;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;


import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({HttpClientService.class, ObjectMapper.class})
public class HttpClientServiceTest {

    @Mock
    private HttpURLConnection mockConnection;

    @Mock
    private InputStream mockInputStream;

    @Mock
    private BufferedReader mockBufferedReader;

    private ObjectMapper mockObjectMapper;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        // Mock URL object to return the mocked connection
        URL mockUrl = PowerMockito.mock(URL.class);
        PowerMockito.whenNew(URL.class).withAnyArguments().thenReturn(mockUrl);
        when(mockUrl.openConnection()).thenReturn(mockConnection);

        // Stub connection methods
        when(mockConnection.getInputStream()).thenReturn(mockInputStream);
        when(mockBufferedReader.readLine())
                .thenReturn("mock response")  // First call
                .thenReturn(null);

        PowerMockito.whenNew(BufferedReader.class)
                .withAnyArguments()
                .thenReturn(mockBufferedReader);

        // Mock ObjectMapper behavior
        mockObjectMapper = PowerMockito.mock(ObjectMapper.class);
        PowerMockito.whenNew(ObjectMapper.class).withNoArguments().thenReturn(mockObjectMapper);
        JsonNode mockJsonNode = PowerMockito.mock(JsonNode.class);
        when(mockObjectMapper.readTree(anyString())).thenReturn(mockJsonNode);
    }

    @Test
    public void testGetHttpResponse_Success() throws Exception {
        // Call the method under test
        JsonNode response = HttpClientService.getHttpResponse(
                "https://api.github.com", "/users/eshen/repos?page=1", Collections.emptyMap(), 5000, 5000);

        // Verify behaviors
        verify(mockConnection).setRequestMethod("GET");
        verify(mockConnection).setConnectTimeout(5000);
        verify(mockConnection).setReadTimeout(5000);
        verify(mockBufferedReader, times(2)).readLine();

        // Ensure response is not null (mocked)
        assertNotNull(response);

    }
}
