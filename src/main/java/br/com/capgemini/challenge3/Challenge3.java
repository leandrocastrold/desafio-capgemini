package br.com.capgemini.challenge3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Leandro Castro
 * @version 1.0.0
 */
public class Challenge3 {

    /**
     * Solicita a palavra que será analisada, chama o método compareAnagram e exibe o resultado da operação.
     * @see Scanner
     */
    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma palavra para verificação de anagramas: ");
        String resp = scanner.nextLine();
        System.out.println(compareAnagram(resp));
    }

    /**
     * @param str String que será analisada em busca de possíveis anagramas.
     * @return Número inteiro de anagramas encontrados na string inserida.
     * @throws RuntimeException Se apenas espaços ou nenhum valor for inserido.
     */
    protected int compareAnagram(String str) {
        if (str.isBlank()) {
            throw new RuntimeException("No mínimo 1 letra deve ser inserida");
        }
        char[] chars = str.toCharArray();
        int size = 0;
        int res = 0;
        String str1 = "";
        String str2 = "";

        //Aumenta o tamanho das strings para recomeçar comparação
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
     * @param chars Caracteres que serão usados na criação da string.
     * @param size  Tamanho final da string que será retornada.
     * @param startIndex Indica qual index do array de caracteres será o começo da string
     * @return String a partir dos parâmetros passados.
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
     * Compara 2 strings e retorna se são iguais ou não.
     * @param str1  Primeira string de comparação
     * @param str2  Segunda string de comparação
     * @return Booleano com o resultado da operação
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
     * Recebe uma string e a retorna com as letras organizadas em ordem alfabética.
     * @param str   String que será organizada
     * @return String organizada em ordem alfabética
     */
    private String sortString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }



}