

import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.WebSocket;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class NewHttpClientTest {

    public static void main(String args[]) throws IOException, InterruptedException, ExecutionException, URISyntaxException {
        getRequestHTTPV2();
        aSyncExample();
        sendRequestStreamAndHandleResponseStream();
        connectToWebSocket();
    }

    private static void getRequestHTTPV2() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create("https://www.google.com")).version(HttpClient.Version.HTTP_2).GET().build();
        HttpResponse<String> httpResponse = client.send(
                request,
                HttpResponse.BodyHandlers.ofString());
        System.out.println(" Status code = " + httpResponse.statusCode() + "response headers " + httpResponse.headers() + " response version " + httpResponse.version());
        String body = httpResponse.body().toString();
        System.out.println(body);
    }

    private static void aSyncExample() throws InterruptedException, ExecutionException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://httpbin.org/anything"))
                .timeout(Duration.ofMinutes(1))
                .GET()
                .build();

        CompletableFuture<HttpResponse<String>> strResponse = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
        Thread.sleep(2000);
        if (strResponse.isDone()) {
            System.out.println(strResponse.get().statusCode() + "the response " + strResponse.get().body());
        } else {
            System.out.println("Request take more than 2 seconeds...");
            strResponse.cancel(true);
            if (strResponse.isCancelled()) {
                System.out.println("request cancelled !!!");
            }
        }
    }

    private static void sendRequestStreamAndHandleResponseStream() throws URISyntaxException, InterruptedException {
        List<URI> targets = Arrays.asList(
                new URI("https://httpbin.org/ip"),
                new URI("https://httpbin.org/get"));
        HttpClient client = HttpClient.newHttpClient();
        List<CompletableFuture<String>> futures = targets.stream()
                .map(target -> client
                        .sendAsync(
                                HttpRequest.newBuilder(target).GET().build(),
                                HttpResponse.BodyHandlers.ofString())
                        .thenApply(response -> response.body()))
                .collect(Collectors.toList());
        Thread.sleep(2000);


        futures.stream().forEach(f -> {
            if (f.isDone()) {
                try {
                    System.out.println("I am done " + f.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static void authenticateExample() {
        try {
            HttpClient client = HttpClient.newBuilder()
                    .authenticator(new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication("username", "password".toCharArray());
                        }
                    })
                    .build();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://javadeveloperzone.com/java-basic/java-9-features/java-9-module-example/"))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode());
            System.out.println(response.body());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }


    private static void connectToWebSocket() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);

        WebSocket ws = HttpClient
                .newHttpClient()
                .newWebSocketBuilder()
                .buildAsync(URI.create("wss://demo.piesocket.com/v3/channel_1?api_key=oCdCMcMPQpbvNjUIzqtvF1d2X2okWpDQj4AwARJuAgtjhzKxVEjQU6IdCjwm&notify_self"), new WebSocketClient(latch))
                .join();
        ws.sendText("Hello!", true);
        latch.await();
    }

    private static class WebSocketClient implements WebSocket.Listener {
        private final CountDownLatch latch;

        public WebSocketClient(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void onOpen(WebSocket webSocket) {
            System.out.println("onOpen using subprotocol " + webSocket.getSubprotocol());
            WebSocket.Listener.super.onOpen(webSocket);
        }

        @Override
        public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
            System.out.println("onText received " + data);
            latch.countDown();
            return WebSocket.Listener.super.onText(webSocket, data, last);
        }

        @Override
        public void onError(WebSocket webSocket, Throwable error) {
            System.out.println("Bad day! " + webSocket.toString());
            WebSocket.Listener.super.onError(webSocket, error);
        }
    }


}
