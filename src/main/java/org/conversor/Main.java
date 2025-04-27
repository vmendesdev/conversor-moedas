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
            System.out.println("\nOpções:");
            System.out.println("1. Nova Conversão");
            System.out.println("2. Ver Histórico");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha

            if (escolha == 3) {
                System.out.println("Programa encerrado. Até mais!");
                break;
            }

            if (escolha == 2) {
                conversor.mostrarHistorico();
                continue;
            }

            System.out.println("\nExemplos de moedas: USD, EUR, GBP, JPY, BRL, ARS, CAD, AUD, CHF, CNY");
            System.out.print("Digite a moeda de origem: ");
            String moedaOrigem = scanner.nextLine().toUpperCase();

            System.out.print("Digite a moeda de destino: ");
            String moedaDestino = scanner.nextLine().toUpperCase();

            System.out.print("Digite o valor a ser convertido: ");
            double valor = scanner.nextDouble();
            scanner.nextLine(); // Consumir quebra de linha

            conversor.realizarConversao(moedaOrigem, moedaDestino, valor);
        }

        scanner.close();
    }
}