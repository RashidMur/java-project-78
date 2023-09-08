package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class TestStringSchema {
    private String testString = "Testing the lines";
    @Test
    public void testStringSchema() {
        Validator v = new Validator();
        StringSchema schema = v.string();

        assertTrue(schema.isValid(""));

        schema.required();

        assertFalse(schema.isValid(""));
        assertFalse(schema.isValid(2));
        assertFalse(schema.minLength(5).isValid(schema));

        assertTrue(schema.contains("Testing").isValid(testString));
        assertTrue(schema.contains("the").isValid(testString));
        assertFalse(schema.contains("lines1").isValid(testString));
        assertFalse(schema.isValid(testString));
    }
}
