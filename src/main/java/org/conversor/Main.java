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
            System.out.println("\nDigite a moeda de origem (ex: USD, EUR, BRL) ou 'sair' para encerrar:");
            String moedaOrigem = scanner.nextLine().toUpperCase();

            if (moedaOrigem.equals("SAIR")) {
                System.out.println("Programa encerrado. Até mais!");
                break;
            }

            System.out.println("Digite a moeda de destino (ex: BRL, USD, EUR):");
            String moedaDestino = scanner.nextLine().toUpperCase();

            System.out.println("Digite o valor a ser convertido:");
            double valor = scanner.nextDouble();
            scanner.nextLine(); // Consumir a quebra de linha

            conversor.realizarConversao(moedaOrigem, moedaDestino, valor);
        }

        scanner.close();
    }
}