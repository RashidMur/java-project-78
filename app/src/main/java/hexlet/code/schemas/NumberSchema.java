package hexlet.code.schemas;


public final class NumberSchema extends BaseSchema {
    public NumberSchema() {
        this.addValidation(v -> v instanceof Integer || v == null);
    }
    @Override
    public NumberSchema required() {
        super.required();
        return this;
    }

    public NumberSchema positive() {
        this.addValidation(v -> (v == null) || ((Integer) v > 0));
        return this;
    }

    public NumberSchema range(int from, int to) {
        this.addValidation(v -> v == null || (Integer) v >= from && (Integer) v <= to);
        return this;
    }
}
