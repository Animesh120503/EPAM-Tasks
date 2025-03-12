package BuilderPattern;

public class EmployeeMain {
    public static void main(String[] args) {
        Employee newEmployee = new Employee.Builder()
                .setEmployeeName("Animesh")
                .setEmployeeId("2312TFR")
                .setDepartment("Testing")
                .build();
        System.out.println(newEmployee.toString());
    }
}
