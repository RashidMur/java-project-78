package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class BaseSchema {

    /**
     * Adds a check for the required presence of a value.
     * @return An instance of this object with the added test.
     */
    public BaseSchema required()  {

        this.addValidation(Objects::nonNull);
        return this;
    }

    private final List<Predicate<Object>> listOfVolitions = new ArrayList<>();

    /**
     * Adds a check to the list of tests.
     * @param predicates The check to add to the list.
     */
    void addValidation(Predicate<Object> predicates) {

        listOfVolitions.add(predicates);
    }

    /**
     * Checks whether the given value is valid according to the set of tests.
     * @param obj we get a list of tests
     * @return check if all tests are true
     */
    public boolean isValid(Object obj) {

        return listOfVolitions.stream().allMatch(v -> v.test(obj));
    }
}
