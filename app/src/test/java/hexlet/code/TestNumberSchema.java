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
        numberSchema.required();
        assertTrue(numberSchema.isValid(15));
        assertFalse(numberSchema.isValid(null));
        assertFalse(numberSchema.isValid("String"));
        assertFalse(numberSchema.isValid(1.1));
    }

    @Test
    public void testPositive() {
        numberSchema.positive();
        assertTrue(numberSchema.isValid(1));
        assertTrue(numberSchema.isValid(null));
        assertFalse(numberSchema.isValid(-1));

    }

    @Test
    public void testRange() {
        numberSchema.range(50, 60);
        assertTrue(numberSchema.isValid(55));
        assertTrue(numberSchema.isValid(50));
        assertTrue(numberSchema.isValid(60));
        assertFalse(numberSchema.isValid(30));
        assertFalse(numberSchema.isValid(100));
    }
}
