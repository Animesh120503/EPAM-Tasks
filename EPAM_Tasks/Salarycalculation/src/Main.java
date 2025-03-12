import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Something", 12));
        employees.add(null);

        Predicate<Employee> checkIfNull = Objects::isNull;
        employees.stream().filter(checkIfNull).forEach(throw new NullPointerException("Employee has null value"));
    }
}
