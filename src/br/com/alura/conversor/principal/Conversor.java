package br.com.alura.conversor.principal;

import br.com.alura.conversor.exceptions.ValorInvalidoException;
import br.com.alura.conversor.modelos.Taxa;
import com.google.gson.Gson;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {
    public Taxa calculaTaxa(String codigoBase, String codigoDestino) {
        String chave = "c49b84a0b8a9595956bf9e2b";
        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/"+ chave + "/pair/" + codigoBase + "/" + codigoDestino);

        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(endereco)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), Taxa.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Não consegui obter a taxa a partir deste código.");
        }
    }

    public Double calcularConversao(String codigoBase, String codigoDestino, Double valor) {
        if (valor < 0) {
            throw new ValorInvalidoException();
        }

        if (valor == 0) {
            return 0.0;
        }

        Taxa taxa = this.calculaTaxa(codigoBase, codigoDestino);

        BigDecimal bd = BigDecimal.valueOf(taxa.taxa());
        bd = bd.setScale(4, RoundingMode.HALF_UP);

        return valor * bd.doubleValue();
    }
}
