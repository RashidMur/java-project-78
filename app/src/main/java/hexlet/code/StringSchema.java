package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public  class StringSchema {


    private List<Predicate<Object>> predicates = new ArrayList<>();

    public List<Predicate<Object>> getPredicates() {
        return predicates;
    }

    public boolean isValid(Object obj) {
        return predicates.stream().allMatch(v -> v.test(obj));
    }
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
