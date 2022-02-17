package br.com.capgemini.application;

import br.com.capgemini.challenge1.Challenge1;
import br.com.capgemini.challenge2.Challenge2;
import br.com.capgemini.challenge3.Challenge3;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Leandro Castro
 * @version 1.0.0
 */
public class ChallengeApplication {


    /**
     * Classe principal do programa. Encerra ao receber o valor 0 do método showMenu()
     * @param args      Argumentos do programa
     */
    public static void main(String[] args) {
        while (showMenu() != 0) ;
    }

    /**
     * Exibe o Menu de operações e solicita um valor inteiro para seleção da operação.
     * @return Valor da última operação solicitada.
     * @throws RuntimeException Se um valor não-inteiro for inserido.
     * @throws RuntimeException Se uma valor inválido de operação for inserido.
     */
    private static int showMenu() {
        Scanner scanner = new Scanner(System.in);
        int option = -1;
        System.out.println("\n" +
                "1: [DESAFIO 1]\n" +
                "2: [DESAFIO 2]\n" +
                "3: [DESAFIO 3]\n" +
                "0: [SAIR]\n");
        System.out.print("Escolha uma opção: ");
        try {
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    Challenge1 challenge1 = new Challenge1();
                    challenge1.start();
                    break;

                case 2:
                    Challenge2 challenge2 = new Challenge2();
                    challenge2.start();
                    break;

                case 3:
                    Challenge3 challenge3 = new Challenge3();
                    challenge3.start();
                    break;

                case 0:
                    return 0;

                default:
                    throw new RuntimeException("Opção inválida");
            }
        } catch (InputMismatchException e) {
           throw new RuntimeException("ERRO: Insira apenas números INTEIROS\n");
        }
        System.out.println("\n[TECLE ENTER PARA CONTINUAR...]");
        scanner.nextLine();
        return option;
    }
}
