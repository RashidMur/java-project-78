package hexlet.code.schemas;

import java.util.Map;

public final class StringSchema extends BaseSchema {
    public StringSchema() {
        predicates.add(v -> v instanceof String || v == null);
    }

    public StringSchema required() {
        addValidation().add(v -> v instanceof String && !((String) v).isEmpty());
        return this;
    }

    public StringSchema minLength(int lenght) {
        addValidation().add(v -> v == null || v.toString().length() >= lenght);
        return this;
    }

    public StringSchema contains(String str) {
        addValidation().add(v -> v == null || v.toString().contains(str));
        return this;
    }
}
