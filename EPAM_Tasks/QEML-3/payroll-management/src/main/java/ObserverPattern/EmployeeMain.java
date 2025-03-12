package ObserverPattern;

public class EmployeeMain {
    public static void main(String[] args) {
        ConcreteEmployee concreteEmployee = new ConcreteEmployee();

        concreteEmployee.addObserver(new HR());
        concreteEmployee.addObserver(new Manager());

        concreteEmployee.setSalary(2000);
    }
}
