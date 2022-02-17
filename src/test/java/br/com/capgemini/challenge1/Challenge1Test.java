package br.com.capgemini.challenge1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Challenge1Test {

    private Challenge1 challenge1;

    @BeforeEach
    void init() {
        challenge1 = new Challenge1();
    }


    @Test
    void shouldReturnALadderWithOneStepWhenTheNumberOneIsGiven() {
        String result = challenge1.createLadder(1);
        assertEquals("*", result);
    }

    @Test
    void shouldReturnALadderWithFourStepsWhenTheNumberFourIsGiven() {
        String result = challenge1.createLadder(4);
        assertEquals("" +
                "   *\n" +
                "  **\n" +
                " ***\n" +
                "****", result);
    }

    @Test
    void shouldReturnALadderWithSixStepsWhenTheNumberSixIsGiven() {
        String result = challenge1.createLadder(6);
        assertEquals("" +
                "     *\n" +
                "    **\n" +
                "   ***\n" +
                "  ****\n" +
                " *****\n" +
                "******", result);
    }

    @Test
    void shouldThrowAnExceptionIfANumberLessThanZeroIsGiven() {
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> {
            challenge1.createLadder(0);
        });
        assertEquals("Apenas valores acima de ZERO são permitidos", runtimeException.getMessage());
    }
}