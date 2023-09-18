package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema {
    public MapSchema() {
        predicates.add(v -> v instanceof Map<?, ?> || v == null);
    }
    public MapSchema required() {
        addValidation().add(v -> v instanceof Map<?, ?>);
        return this;
    }

    public MapSchema sizeof(int size) {
        addValidation().add(v -> v == null || ((Map<?, ?>) v).size() == size);
        return this;
    }
    public MapSchema shape(Map<String, BaseSchema> schema) {
        addValidation().add(v -> v == null || checkMap((Map<?, ?>) v, schema));
        return this;
    }

    private boolean checkMap(Map<?, ?> v, Map<?, BaseSchema> schema) {
        for (var x : schema.entrySet()) {
            var k = x.getKey();
            var value = x.getValue();
            if (!value.isValid(v.get(k))) {
                return false;
            }
        }
        return true;
    }
}
