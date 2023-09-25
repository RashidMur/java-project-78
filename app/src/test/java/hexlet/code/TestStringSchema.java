package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class TestStringSchema {
    private String testStringLong = "one two three four";
    private String testStringMedium = "one two four";
    private String testStringShort = "one four";
    private StringSchema schema;
    @BeforeEach
    public void inputTestSchema() {
        Validator validator = new Validator();
        schema = validator.string();
    }
    @Test
    public void testRequired() {
        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(""));
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
        schema.contains("one");
        assertTrue(schema.isValid(testStringLong));
        assertTrue(schema.isValid(testStringMedium));
        assertTrue(schema.isValid(testStringShort));
        schema.contains("two");
        assertTrue(schema.isValid(testStringLong));
        assertTrue(schema.isValid(testStringMedium));
        assertFalse(schema.isValid(testStringShort));
        schema.contains("four");
        assertTrue(schema.isValid(testStringLong));
        assertTrue(schema.isValid(testStringMedium));
        assertFalse(schema.isValid(testStringShort));
    }
}
