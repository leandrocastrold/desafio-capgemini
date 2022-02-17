package br.com.capgemini.challenge2;

import java.util.Scanner;

/**
 * @author Leandro Castro
 * @version 1.0.0
 */
public class Challenge2 {

    /**
     * Número mínimo de caracteres que uma senha deve ter para ser considerada forte.
     */
    private final int PASSWORD_MIN_LENGTH = 6;

    /**
     * Solicita uma senha, chama o método checkPassword e exibe o resultado.
     * @see Scanner
     */
    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe uma senha: " );
        String password = scanner.nextLine();
        System.out.println(checkPassword(password));
    }

    /**
     * Verifica a senha passada e retorna o número de caracteres que faltam para ela ser considerada uma senha forte.
     * @param password  Senha que será analisada.
     * @return  Valor inteiro informando o número de caracteres pendentes.
     * @throws RuntimeException Se a senha informada estiver em branco ou com apenas espaços.
     */
    protected int checkPassword(String password){
        if (password.isBlank()) {
            throw new RuntimeException("A senha informada não pode estar em branco");
        }
        password = password.trim();
        int passwordLength = password.length();
        int difference = PASSWORD_MIN_LENGTH - passwordLength;
        if (difference > 0) {
            return difference;
        }
        return 0;
    }

}
