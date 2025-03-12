import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class EmployeeMain {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Animesh", Employee.Role.ENGINEER, "Testing", 5000);
        Employee emp2 = new Employee("Ankit", Employee.Role.MANAGER, "Project Manager", 2000);
        Employee emp3 = new Employee("Sarah", Employee.Role.MANAGER, "Lead Manager", 6200);
        Employee emp4 = new Employee("Pope", Employee.Role.ENGINEER, "Testing", 1200);
        Employee emp5 = new Employee("Mark", Employee.Role.MANAGER, "Project Manager", 5500);
        Employee emp6 = new Employee("Gary", Employee.Role.ENGINEER, "Testing", 900);
        Employee emp7 = new Employee("Ana", Employee.Role.ENGINEER, "Testing", 1200);

        List<Employee> employeeList = new ArrayList<>(List.of(emp1,emp2,emp3,emp4,emp5,emp6,emp7));

        if (employeeList.isEmpty()) {
            System.out.println("Employee List is empty. No employee to process");
            return;
        }

        employeeList.forEach(employee -> {
            if (employee == null)
                System.out.println("Employee is Null.");
            else
                System.out.println(employee.toString());
        });

        employeeList.stream()
                .filter(employee -> employee != null
                        && employee.getRole() == Employee.Role.MANAGER
                        && employee.getSalary()>5000)
                .filter(employee -> employee.getRole() != null)
                .forEach(employee -> System.out.println(employee.toString()));

        double salarySum = employeeList.stream()
                .map(Employee::getSalary)
                .reduce(0.0, (salary1, salary2) -> salary1+salary2);
        System.out.println("Sum of Salaries: "+salarySum);

        Map<String, List<Employee>> employeeByDepartment = employeeList.stream()
                .filter(employee -> employee.getDepartment() != null)
                .collect(groupingBy(Employee::getDepartment));
        System.out.println(employeeByDepartment);

        List<Double> salaryDescending = employeeList.stream()
                .map(Employee::getSalary)
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println(salaryDescending);

        Optional<Double> firstSalaryAbove5000 = employeeList.stream()
                .map(Employee::getSalary)
                .filter(salary -> salary>5000)
                .findFirst();
        if(firstSalaryAbove5000.isPresent())
            System.out.println(firstSalaryAbove5000.get());

        long countSalaryAbove5000 = employeeList.stream()
                .map(Employee::getSalary)
                .filter(salary -> salary>5000)
                .count();
        System.out.println("Salaries above 5000: "+countSalaryAbove5000);

        List<Double> distinctSalaries = employeeList.stream()
                .map(Employee::getSalary)
                .distinct()
                .toList();
        System.out.println("List of distinct Salaries: "+distinctSalaries);

        Set<String> employeeNameSet = employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());
        System.out.println(employeeNameSet);

        Map<String, Employee> employeeNameMap = employeeList.stream()
                .collect(Collectors.toMap(Employee::getName, employee -> employee));
        System.out.println(employeeNameMap);

        List<String> employeeNameList = employeeList.stream()
                .map(Employee::getName)
                .toList();
        System.out.println(employeeNameList);
    }
}
