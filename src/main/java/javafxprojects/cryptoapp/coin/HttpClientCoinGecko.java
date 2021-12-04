package javafxprojects.cryptoapp.coin;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Locale;

public class HttpClientCoinGecko {
    private static final HttpClient client = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();
    public static void updatePrice(Coin coin)throws Exception{
        if(coin == null)
            throw new IllegalArgumentException();

        String coinName = coin.getName().trim().toLowerCase();
        String url = String.format("https://api.coingecko.com/api/v3/simple/price?ids=%s&vs_currencies=usd",coinName);
        Gson gson = new Gson();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .build();
        try {
            HttpResponse<String> jsonResponse = client.send(request,HttpResponse.BodyHandlers.ofString());
            System.out.println(jsonResponse.body());
            JsonObject jsonObject = gson.fromJson(jsonResponse.body(),JsonObject.class);
            Double coinPrice = jsonObject.get(coinName).getAsJsonObject().get("usd").getAsDouble();
            coin.setCurPrice(coinPrice);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
