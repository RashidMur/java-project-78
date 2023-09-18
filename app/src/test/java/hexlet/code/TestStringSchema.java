package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class TestStringSchema {
    private String testString = "Testing the lines";
    private StringSchema schema;
    @BeforeEach
    public void inputTestSchema() {
        Validator validator = new Validator();
        schema = validator.string();
    }
    @Test
    public void testRequired() {
        assertTrue(schema.isValid(""));

        schema.required();

        assertFalse(schema.isValid(""));
        assertFalse(schema.isValid(2));

    }
    @Test
    public void testMinLength() {
        assertTrue(schema.minLength(2).isValid(testString));
        assertFalse(schema.minLength(40).isValid(testString));
    }

    @Test
    public void testContains() {
        assertTrue(schema.contains("Testing").isValid(testString));
        assertTrue(schema.contains("the").isValid(testString));
        assertFalse(schema.contains("lines1").isValid(testString));
        assertFalse(schema.isValid(testString));
    }
}
