package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema {
    public MapSchema required() {
        getPredicates().add(v -> v instanceof Map<?, ?>);
        return this;
    }

    public MapSchema sizeof(int size) {
        getPredicates().add(v -> ((Map<?, ?>) v).size() == size);
        return this;
    }
    public MapSchema shape(Map<String, BaseSchema> schema) {
        getPredicates().add(v -> checkMap((Map<?, ?>) v, schema));
        return this;
    }

    boolean checkMap(Map<?, ?> v, Map<?, BaseSchema> schema) {
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
