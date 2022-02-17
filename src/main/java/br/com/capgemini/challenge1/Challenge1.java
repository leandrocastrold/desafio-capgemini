package br.com.capgemini.challenge1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Leandro Castro
 * @version 1.0.0
 */
public class Challenge1 {

    /**
     * Solicita um valor inteiro para definir tamanho da "escada", passa como argumento para o método createLadder e exibe o resultado.
     * @throws RuntimeException Se um valor não inteiro for inserido
     * @see Scanner
     */
    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nInforme a quantidade de caracteres: ");
        int value = 0;
        try {
            value = scanner.nextInt();
        } catch (InputMismatchException e) {
           throw new RuntimeException("ERRO: Apenas números INTEIROS são válidos para essa operação.");
        }
        System.out.println("\n" + createLadder(value));
    }

    /**
     * Cria a estrutura da escada, a partir do tamanho informado
     * @param ladderSize    Número de caracteres e tamanho da "escada" a ser criada.
     * @return String com a escada construída.
     */
    protected String createLadder(int ladderSize) {
        String characters = "";
        if (ladderSize <= 0) {
            throw new RuntimeException("Apenas valores acima de ZERO são permitidos");
        }
        for (int i = 1; i <= ladderSize; i++) {
            int numOfSpaces = (ladderSize - i);
            //Preenche com espaços ou asteriscos, dependendo da condição
            for (int j = 1; j <= ladderSize; j++) {
                if (j <= numOfSpaces) {
                    characters += " ";
                } else {
                    characters += "*";
                }
            }
            //Pula a linha se ainda não chegou ao final da "escada"
            characters += (i < ladderSize) ? "\n" : "";
        }
        return characters;
    }
}
