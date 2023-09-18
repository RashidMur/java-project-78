package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class TestMapSchema {
    private MapSchema schema;
    private Validator validator;
    @BeforeEach
    public void inputTestSchema() {
        validator = new Validator();
        schema = validator.map();
    }
    @Test
    public void testRequired() {
        assertTrue(schema.isValid(null));
        schema.required();
        assertFalse(schema.isValid(null));
    }

    @Test
    public void testSizeof() {
        Map<String, String> data = new HashMap<>();
        assertTrue(schema.isValid(data));
        data.put("key1", "value1");

        schema.sizeof(2);

        assertFalse(schema.isValid(data));
        data.put("key2", "value2");
        assertTrue(schema.isValid(data));
    }

    @Test
    public void testShape() {
        Map<String, BaseSchema> schemas = new HashMap<>();

        schemas.put("name", validator.string().required());
        schemas.put("age", validator.number().positive());

        schema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", 12);
        assertTrue(schema.isValid(human1));

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "");
        human2.put("age", 12);
        assertFalse(schema.isValid(human2));

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "Maya");
        human3.put("age", null);
        assertTrue(schema.isValid(human3));

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Misha");
        human4.put("age", -10);
        assertFalse(schema.isValid(human4));
    }
}
