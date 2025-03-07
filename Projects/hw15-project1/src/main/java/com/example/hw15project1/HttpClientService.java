package com.example.hw15project1;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class HttpClientService {

    public static JsonNode getHttpResponse(String baseUrl, String path, Map<String, String> headers, int connectTimeout, int readTimeout) throws Exception {
        HttpURLConnection connection = null;
        try {
            URL requestUrl = new URL(baseUrl + path);
            connection = (HttpURLConnection) requestUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(connectTimeout);
            connection.setReadTimeout(readTimeout);

            for (Map.Entry<String, String> entry : headers.entrySet()) {
                connection.setRequestProperty(entry.getKey(), entry.getValue());
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readTree(response.toString());
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
