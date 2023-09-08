package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {



    public StringSchema required() {
        getPredicates().add(v -> v instanceof String && !((String) v).isEmpty());
        return this;
    }

    public StringSchema minLength(int lenght) {
        getPredicates().add(v -> v.toString().length() >= lenght);
        return this;
    }

    public StringSchema contains(String str) {
        getPredicates().add(v -> v.toString().contains(str));
        return this;
    }
}
