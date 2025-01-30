package com.learn.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;

import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.api.mockito.PowerMockito;


@RunWith(PowerMockRunner.class)
@PrepareForTest(HttpClientHelper.class)  // Prepare the class with static methods
public class HttpClientHelperTest {

    @Before
    public void setUp() {
    }

    @Test
    public void testFetchGitHubRepos_MockedResponse() throws IOException {
        String mockResponse = "[{\"id\": 12345, \"name\": \"test-repo\", \"owner\": {\"login\": \"testuser\"}}]";
        // Mock
        PowerMockito.mockStatic(HttpClientHelper.class);

        // Stub the static method call
        PowerMockito.when(HttpClientHelper.fetchGitHubRepos("testuser"))
                .thenReturn(mockResponse);
        String response = HttpClientHelper.fetchGitHubRepos("testuser");
        assertEquals(mockResponse, response);

        // Verify
        PowerMockito.verifyStatic(HttpClientHelper.class, times(1));
        HttpClientHelper.fetchGitHubRepos("testuser");
    }
}

