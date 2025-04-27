package org.conversor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Conversor {
    private final ApiService apiService = new ApiService();
    private final List<String> historico = new ArrayList<>();
    private final String CAMINHO_ARQUIVO = "historico_conversoes.txt";

    public void realizarConversao(String moedaOrigem, String moedaDestino, double valor) {
        try {
            double taxa = apiService.obterTaxaDeConversao(moedaOrigem, moedaDestino);
            double resultado = valor * taxa;
            System.out.printf("Valor convertido: %.2f %s\n", resultado, moedaDestino);

            // Criar registro de log com data e hora
            LocalDateTime agora = LocalDateTime.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String registro = String.format("[%s] %.2f %s -> %.2f %s",
                    agora.format(formato), valor, moedaOrigem, resultado, moedaDestino);

            historico.add(registro);

            salvarHistoricoNoArquivo(registro);

        } catch (Exception e) {
            System.out.println("Erro ao realizar a conversão: " + e.getMessage());
        }
    }

    private void salvarHistoricoNoArquivo(String registro) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CAMINHO_ARQUIVO, true))) {
            writer.write(registro);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao salvar histórico no arquivo: " + e.getMessage());
        }
    }

    public void mostrarHistorico() {
        System.out.println("\n=== Histórico de Conversões ===");
        if (historico.isEmpty()) {
            System.out.println("Nenhuma conversão realizada ainda.");
        } else {
            for (String registro : historico) {
                System.out.println(registro);
            }
        }
    }
}
