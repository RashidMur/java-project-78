package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class TestStringSchema {
    final String testStringLong = "Testing the long lines ";
    final String testStringShort = "Test";
    private StringSchema schema;
    @BeforeEach
    public void inputTestSchema() {
        Validator validator = new Validator();
        schema = validator.string();
    }
    @Test
    public void testRequired() {
        schema.required();
        assertTrue(schema.isValid(testStringLong));
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(2));
        assertFalse(schema.isValid(""));
    }
    @Test
    public void testMinLength() {
        schema.minLength(10);
        assertTrue(schema.isValid(testStringLong));
        assertFalse(schema.isValid(testStringShort));
    }

    @Test
    public void testContains() {
        schema.contains("long");
        assertTrue(schema.isValid(testStringLong));
        assertFalse(schema.isValid(testStringShort));
    }
}
