package iou.ink.IOUMC.tools;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class TestRequest {

    private static final HttpClient httpClient = HttpClient.newHttpClient();

    /**
     * 发送GET请求（不带请求头）
     */
    public static String get(String url) throws Exception {
        return get(url, null);
    }

    /**
     * 发送GET请求（带请求头）
     */
    public static String get(String url, Map<String, String> headers) throws Exception {
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET();

        // 添加请求头
        if (headers != null) {
            headers.forEach(requestBuilder::header);
        }

        HttpResponse<String> response = httpClient.send(requestBuilder.build(), HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("HTTP GET请求失败，状态码: " + response.statusCode());
        }

        return response.body();
    }

    /**
     * 发送POST请求（不带请求头）
     */
    public static String post(String url, String body) throws Exception {
        return post(url, body, null);
    }

    /**
     * 发送POST请求（带请求头）
     */
    public static String post(String url, String body, Map<String, String> headers) throws Exception {
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .POST(HttpRequest.BodyPublishers.ofString(body));

        // 默认设置JSON请求头
        requestBuilder.header("Content-Type", "application/json; utf-8");

        // 添加自定义请求头
        if (headers != null) {
            headers.forEach(requestBuilder::header);
        }

        HttpResponse<String> response = httpClient.send(requestBuilder.build(), HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("HTTP POST请求失败，状态码: " + response.statusCode());
        }

        return response.body();
    }
}