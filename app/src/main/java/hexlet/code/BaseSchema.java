package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema {

    private List<Predicate<Object>> predicates = new ArrayList<>();

    public List<Predicate<Object>> getPredicates() {
        return predicates;
    }
    public boolean isValid(Object obj) {
        return predicates.stream().allMatch(v -> v.test(obj));
    }
}
