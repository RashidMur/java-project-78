package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class TestNumberSchema {
    private NumberSchema numberSchema;

    @BeforeEach
    public void inputTestSchema() {
        Validator validator = new Validator();
        numberSchema = validator.number();
    }
    @Test
    public void testRequired() {
        assertTrue(numberSchema.isValid(0));
        assertTrue(numberSchema.isValid(15));

        assertFalse(numberSchema.required().isValid(null));

        assertFalse(numberSchema.isValid("inputNumber"));
        assertFalse(numberSchema.isValid(null));
        assertFalse(numberSchema.isValid(25.55));
    }

    @Test
    public void testPositive() {
        assertTrue(numberSchema.positive().isValid(1));
        assertTrue(numberSchema.positive().isValid(null));
        assertFalse(numberSchema.positive().isValid(-1));
    }

    @Test
    public void testRange() {
        assertTrue(numberSchema.range(50, 60).isValid(55));
        assertTrue(numberSchema.range(50, 60).isValid(50));
        assertTrue(numberSchema.range(50, 60).isValid(60));

        assertFalse(numberSchema.isValid(30));
        assertFalse(numberSchema.isValid(100));
    }
}
