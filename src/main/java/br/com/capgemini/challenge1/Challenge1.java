package br.com.capgemini.challenge1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Leandro Castro
 * @version 1.0.0
 */
public class Challenge1 {

    /**
     * Solicita um valor inteiro para definir tamanho da "escada", passa como argumento para o m�todo createLadder e exibe o resultado.
     * @throws RuntimeException Se um valor n�o inteiro for inserido
     * @see Scanner
     */
    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nInforme a quantidade de caracteres: ");
        int value = 0;
        try {
            value = scanner.nextInt();
        } catch (InputMismatchException e) {
           throw new RuntimeException("ERRO: Apenas n�meros INTEIROS s�o v�lidos para essa opera��o.");
        }
        System.out.println("\n" + createLadder(value));
    }

    /**
     * Cria a estrutura da escada, a partir do tamanho informado
     * @param ladderSize    N�mero de caracteres e tamanho da "escada" a ser criada.
     * @return String com a escada constru�da.
     */
    protected String createLadder(int ladderSize) {
        String characters = "";
        if (ladderSize <= 0) {
            throw new RuntimeException("Apenas valores acima de ZERO s�o permitidos");
        }
        for (int i = 1; i <= ladderSize; i++) {
            int numOfSpaces = (ladderSize - i);
            //Preenche com espa�os ou asteriscos, dependendo da condi��o
            for (int j = 1; j <= ladderSize; j++) {
                if (j <= numOfSpaces) {
                    characters += " ";
                } else {
                    characters += "*";
                }
            }
            //Pula a linha se ainda n�o chegou ao final da "escada"
            characters += (i < ladderSize) ? "\n" : "";
        }
        return characters;
    }
}
