package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema {

    protected List<Predicate<Object>> predicates = new ArrayList<>();

    /**
     *
     * @return return a ArrayList of checks
     */
    protected List<Predicate<Object>> addValidation() {

        return predicates;
    }

    /**
     *
     * @param obj we get a list of tests
     * @return check if all tests are true
     */
    public boolean isValid(Object obj) {

        return predicates.stream().allMatch(v -> v.test(obj));
    }
}
