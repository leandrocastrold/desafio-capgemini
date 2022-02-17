package br.com.capgemini.challenge2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Challenge2Test {

    private Challenge2 challenge2;
    private final int MIN_PASSWORD_LENGTH = 6;

    @BeforeEach
    void setup(){
        challenge2 = new Challenge2();
    }

    @Test
    void shouldReturnTheNumberOfCharactersMissing() {
        int result = challenge2.checkPassword("Ya3");
        assertEquals(3, result);
    }

    @Test
    void shouldReturnTrueWhenTheNumberOfCharsMissingIsLessThanOrEqualToZero(){
        int result = challenge2.checkPassword("Ya3&ab");
        assertTrue(result <= 0);
    }

    @Test
    void shouldThrowRuntimeExceptionIfPasswordIsEmpty() {

        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> {
            int result = challenge2.checkPassword("         ");
        });
        assertEquals("A senha informada não pode estar em branco", runtimeException.getMessage());
    }

}