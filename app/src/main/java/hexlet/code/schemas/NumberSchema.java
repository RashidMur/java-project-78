package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {
    public NumberSchema() {
        predicates.add(v -> v instanceof Integer || v == null);
    }
    public NumberSchema required() {
        addValidation().add(v -> v instanceof Integer);
        return this;
    }

    public NumberSchema positive() {
        addValidation().add(v -> v == null || v instanceof Integer && (Integer) v > 0);
        return this;
    }

    public NumberSchema range(int from, int to) {
        addValidation().add(v -> v == null || (Integer) v >= from && (Integer) v <= to);
        return this;
    }
}
