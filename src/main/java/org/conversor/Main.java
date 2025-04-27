package org.conversor;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conversor conversor = new Conversor();

        System.out.println("=== Bem-vindo ao Conversor de Moedas ===");

        while (true) {
            System.out.print("\nDigite a moeda de origem (ex.: USD, EUR, BRL) ou 'sair' para encerrar: ");
            String moedaOrigem = scanner.nextLine().trim().toUpperCase();

            if (moedaOrigem.equalsIgnoreCase("sair")) {
                System.out.println("Programa encerrado. Até logo!");
                break;
            }

            System.out.print("Digite a moeda de destino (ex.: BRL, USD, EUR): ");
            String moedaDestino = scanner.nextLine().trim().toUpperCase();

            System.out.print("Digite o valor a ser convertido: ");
            double valor = scanner.nextDouble();
            scanner.nextLine(); // Limpa o buffer do Scanner

            conversor.realizarConversao(moedaOrigem, moedaDestino, valor);

            System.out.print("\nDeseja realizar outra conversão? (s/n): ");
            String continuar = scanner.nextLine().trim();

            if (continuar.equalsIgnoreCase("n")) {
                System.out.println("Programa encerrado. Até logo!");
                break;
            }
        }

        scanner.close();
    }
}