package hexlet.code.schemas;



public final class StringSchema extends BaseSchema {
    public StringSchema() {
        this.addValidation(v -> v instanceof String || v == null);
    }

    @Override
    public StringSchema required() {
        this.addValidation(v -> v != null && !v.toString().isEmpty());
        return this;
    }

    public StringSchema minLength(int lenght) {
        this.addValidation(v -> v == null || v.toString().length() >= lenght);
        return this;
    }

    public StringSchema contains(String str) {
        this.addValidation(v -> v == null || v.toString().contains(str));
        return this;
    }
}
