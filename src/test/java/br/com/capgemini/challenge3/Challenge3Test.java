package br.com.capgemini.challenge3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Challenge3Test {

    private Challenge3 challenge3;

    @BeforeEach
    void init(){
     challenge3 = new Challenge3();
    }

    @Test
    void shouldThrowRuntimeExceptionIfNothingIsGiven(){
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> {
            challenge3.compareAnagram("");
        });
        assertEquals("No mínimo 1 letra deve ser inserida", runtimeException.getMessage());
    }
    @Test
    void shouldReturnTheNumberOne() {
        int result = challenge3.compareAnagram("ll");
        assertEquals(1, result);
    }

    @Test
    void shouldReturnTheNumberTwo() {
        int result = challenge3.compareAnagram("ovo");
        assertEquals(2, result);
    }

    @Test
    void shouldReturnTheNumberThree() {
        int result = challenge3.compareAnagram("ifailuhkqq");
        assertEquals(3, result);
    }
}