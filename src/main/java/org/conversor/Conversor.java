package org.conversor;

public class Conversor {
    private final ApiService apiService = new ApiService();

    public void realizarConversao(String moedaOrigem, String moedaDestino, double valor) {
        try {
            double taxa = apiService.obterTaxaDeConversao(moedaOrigem, moedaDestino);
            double resultado = valor * taxa;
            System.out.printf("Valor convertido: %.2f %s\n", resultado, moedaDestino);
        } catch (Exception e) {
            System.out.println("Erro ao realizar a conversão: " + e.getMessage());
        }
    }
}
