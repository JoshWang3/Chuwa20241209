package com.learn.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;


public class HttpClientHelperTest {

    @Test
    public void testFetchGitHubRepos_MockedResponse() throws IOException {
        try (MockedStatic<HttpClientHelper> mockedStatic = mockStatic(HttpClientHelper.class)) {

            String mockResponse = "[{\"id\": 12345, \"name\": \"test-repo\"}]";

            mockedStatic.when(() -> HttpClientHelper.fetchGitHubRepos("testuser"))
                    .thenReturn(mockResponse);

            String response = HttpClientHelper.fetchGitHubRepos("testuser");

            assertEquals(mockResponse, response);
            mockedStatic.verify(() -> HttpClientHelper.fetchGitHubRepos("testuser"), Mockito.times(1));
        }
    }
}
