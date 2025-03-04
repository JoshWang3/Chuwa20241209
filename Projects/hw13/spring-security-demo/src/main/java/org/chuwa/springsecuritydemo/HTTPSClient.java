package org.chuwa.springsecuritydemo;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.IOException;

public class HTTPSClient {
    public static void main(String[] args) {
        try {
            // Path to the JKS file
            String keyStorePath = "src/main/resources/myapp.jks";
            String keyStorePassword = "changeit";

            // Load the self-signed certificate into SSLContext
            SSLContext sslContext = SSLContextBuilder.create()
                    .loadTrustMaterial(new File(keyStorePath), keyStorePassword.toCharArray())
                    .build();

            // Create an HTTP client with the custom SSLContext
            CloseableHttpClient httpClient = HttpClients.custom()
                    .setSSLContext(sslContext)
                    .build();

            // Define the HTTPS endpoint
            String httpsUrl = "https://localhost:8443/api/test";

            // Create and execute the HTTP GET request
            HttpGet request = new HttpGet(httpsUrl);
            HttpResponse response = httpClient.execute(request);

            // Print the response status
            System.out.println("Response Code: " + response.getStatusLine().getStatusCode());
            System.out.println("Response Message: " + response.getStatusLine().getReasonPhrase());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
