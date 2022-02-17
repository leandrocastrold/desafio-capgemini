package br.com.capgemini.challenge3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Leandro Castro
 * @version 1.0.0
 */
public class Challenge3 {

    /**
     * Solicita a palavra que ser� analisada, chama o m�todo compareAnagram e exibe o resultado da opera��o.
     * @see Scanner
     */
    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma palavra para verifica��o de anagramas: ");
        String resp = scanner.nextLine();
        System.out.println(compareAnagram(resp));
    }

    /**
     * @param str String que ser� analisada em busca de poss�veis anagramas.
     * @return N�mero inteiro de anagramas encontrados na string inserida.
     * @throws RuntimeException Se apenas espa�os ou nenhum valor for inserido.
     */
    protected int compareAnagram(String str) {
        if (str.isBlank()) {
            throw new RuntimeException("No m�nimo 1 letra deve ser inserida");
        }
        char[] chars = str.toCharArray();
        int size = 0;
        int res = 0;
        String str1 = "";
        String str2 = "";

        //Aumenta o tamanho das strings para recome�ar compara��o
        for (int h = 0; h < chars.length; h++) {
            size++;

            //Define a STR1
            for (int i = 0; i < chars.length; i++) {
                if ((i + size) <= chars.length) {
                    str1 = createString(chars, size, i);
                }

                //Define a STR2
                for (int j = i + 1; j < chars.length; j++) {
                    str2 = createString(chars, size, j);
                    if (compareStrings(str1, str2)) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    /**
     * Cria e retorna uma string a partir dos carateres passados, definindo o tamanho e index inicial.
     * @param chars Caracteres que ser�o usados na cria��o da string.
     * @param size  Tamanho final da string que ser� retornada.
     * @param startIndex Indica qual index do array de caracteres ser� o come�o da string
     * @return String a partir dos par�metros passados.
     */
    private String createString(char[] chars, int size, int startIndex) {
        String result = "";
        for (int i = startIndex; i < size + startIndex; i++) {
            if (size + startIndex <= chars.length) {
                result += chars[i];
            }
        }
        return result;
    }

    /**
     * Compara 2 strings e retorna se s�o iguais ou n�o.
     * @param str1  Primeira string de compara��o
     * @param str2  Segunda string de compara��o
     * @return Booleano com o resultado da opera��o
     */
    private Boolean compareStrings(String str1, String str2) {
        str1 = sortString(str1);
        str2 = sortString(str2);
        if (str1.compareTo(str2) == 0) {
            return true;
        }
        return false;
    }

    /**
     * Recebe uma string e a retorna com as letras organizadas em ordem alfab�tica.
     * @param str   String que ser� organizada
     * @return String organizada em ordem alfab�tica
     */
    private String sortString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }



}