// You should always define a fully qualified package name - it's convention
// Also remove unnecessary imports
package com.melina.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {

    public static void main(String args[]) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        // Always provide the required REST method for readability - here GET.
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://jsonplaceholder.typicode.com/albums"))
                .build();

        // sendAsync() is making your request/thread non blocking. This very nice, because its performant but
        // Async/NIO topics are quite advanced and it requires thinking in a non sequentially way.
        // You should be familiar with multithreading, IO concepts before using it.
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(JsonParser::parse)
                .join();

        // Blocking alternative
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String result = JsonParser.parse(response.body());
        System.out.println(result);
    }

}

