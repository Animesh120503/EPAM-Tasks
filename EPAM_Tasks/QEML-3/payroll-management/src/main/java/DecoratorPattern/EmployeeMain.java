package DecoratorPattern;

public class EmployeeMain {
    public static void main(String[] args) {
        Employee employee = new ConcreteEmployee();
        System.out.println(employee.getDescription()+"\n"+employee.getSalary()+"\n");

        employee = new AnnualBonus(employee);
        System.out.println(employee.getDescription()+"\n"+employee.getSalary()+"\n");

        employee = new OvertimeBonus(40, employee);
        System.out.println(employee.getDescription()+"\n"+employee.getSalary()+"\n");

        employee = new FestivalBonus(employee);
        System.out.println(employee.getDescription()+"\n"+employee.getSalary()+"\n");
    }
}
