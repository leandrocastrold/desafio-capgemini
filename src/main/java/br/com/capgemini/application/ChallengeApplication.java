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
     * Classe principal do programa. Encerra ao receber o valor 0 do m�todo showMenu()
     * @param args      Argumentos do programa
     */
    public static void main(String[] args) {
        while (showMenu() != 0) ;
    }

    /**
     * Exibe o Menu de opera��es e solicita um valor inteiro para sele��o da opera��o.
     * @return Valor da �ltima opera��o solicitada.
     * @throws RuntimeException Se um valor n�o-inteiro for inserido.
     * @throws RuntimeException Se uma valor inv�lido de opera��o for inserido.
     */
    private static int showMenu() {
        Scanner scanner = new Scanner(System.in);
        int option = -1;
        System.out.println("\n" +
                "1: [DESAFIO 1]\n" +
                "2: [DESAFIO 2]\n" +
                "3: [DESAFIO 3]\n" +
                "0: [SAIR]\n");
        System.out.print("Escolha uma op��o: ");
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
                    throw new RuntimeException("Op��o inv�lida");
            }
        } catch (InputMismatchException e) {
           throw new RuntimeException("ERRO: Insira apenas n�meros INTEIROS\n");
        }
        System.out.println("\n[TECLE ENTER PARA CONTINUAR...]");
        scanner.nextLine();
        return option;
    }
}
