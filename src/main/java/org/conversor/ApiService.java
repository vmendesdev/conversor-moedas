package org.conversor;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiService {

    private final Dotenv dotenv = Dotenv.load();
    private final String apiKey = dotenv.get("API_KEY"); // Lê a chave da API

    public double obterTaxaDeConversao(String moedaOrigem, String moedaDestino) throws IOException, InterruptedException {
        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + moedaOrigem + "/" + moedaDestino;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new IOException("Erro na API: Status " + response.statusCode());
        }

        JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
        if (!jsonObject.has("conversion_rate")) {
            throw new IOException("Moeda inválida ou não encontrada.");
        }

        return jsonObject.get("conversion_rate").getAsDouble();
    }
}

