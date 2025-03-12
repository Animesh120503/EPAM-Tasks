package org.example;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class EmployeeMain {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter number of employee details to add: ");
//        int numberOfEmployees = sc.nextInt();
//        sc.nextLine();
//
//        PartTimeEmployee[] employeeList = new PartTimeEmployee[numberOfEmployees];
//        for(int i=0;i<numberOfEmployees;i++){
//            System.out.println("For Employee "+i+1+", enter the details:");
//            System.out.println("Enter Employee ID: ");
//            String employeeId = sc.nextLine();
//            System.out.println("Enter Employee name: ");
//            String name = sc.nextLine();
//            System.out.println("Enter Department: ");
//            String department = sc.nextLine();
//            System.out.println("Enter the Base Salary: ");
//            double baseSalary = sc.nextDouble();
//            System.out.println("Enter Hours the employee worked: ");
//            int hoursWorked = sc.nextInt();
//            sc.nextLine();
//            employeeList[i] = new PartTimeEmployee(employeeId,name,department,baseSalary,hoursWorked);
//
//            employeeList[i].display();
//        }

//        ArrayList<PartTimeEmployee> partTimeEmployeeArrayList = new ArrayList<>();
//        ArrayList<FullTimeEmployee> fullTimeEmployeeArrayList = new ArrayList<>();
//
//        partTimeEmployeeArrayList.add(new PartTimeEmployee("12345","Animesh","testing"
//        ,23456.0,12));
//        partTimeEmployeeArrayList.add(new PartTimeEmployee("12345","Animesh","testing"
//                ,23456.0,12));
//        partTimeEmployeeArrayList.add(new PartTimeEmployee("76856","Huban","lmn"
//                ,25678,9));
//        partTimeEmployeeArrayList.add(new PartTimeEmployee("5678","Ankit","bvc"
//                ,8898,6));
//        partTimeEmployeeArrayList.add(new PartTimeEmployee("5245","Sawan","uio"
//                ,9000,12));
//        partTimeEmployeeArrayList.add(new PartTimeEmployee("7056","Pope","lmn"
//                ,34555,2));
//
//        fullTimeEmployeeArrayList.add(new FullTimeEmployee("12345","Animesh","testing"
//                ,20000.0,1200));
//        fullTimeEmployeeArrayList.add(new FullTimeEmployee("12345","Animesh","testing"
//                ,23456.0,1200));
//        fullTimeEmployeeArrayList.add(new FullTimeEmployee("76856","Huban","lmn"
//                ,25678,2999));

//
//        for(PartTimeEmployee emp : partTimeEmployeeArrayList) {
//            emp.display();
//            System.out.println();
//        }

//        Scanner sc = new Scanner(System.in);
//        String choice;
//        do {
//            System.out.println("Employee Type [Part time (Select 1) / Full Time (Select 2)]");
//            int employeeType = sc.nextInt();
//            sc.nextLine();
//            System.out.println("Enter Employee ID: ");
//            String employeeId = sc.nextLine();
//            System.out.println("Enter Employee name: ");
//            String name = sc.nextLine();
//            System.out.println("Enter Department: ");
//            String department = sc.nextLine();
//            System.out.println("Enter the Base Salary: ");
//            double baseSalary = sc.nextDouble();
//
//            if (employeeType == 1) {
//                System.out.println("Enter Hours the employee worked: ");
//                int hoursWorked = sc.nextInt();
//                partTimeEmployeeArrayList.add(new PartTimeEmployee(employeeId, name,
//                        department, baseSalary, hoursWorked));
//            } else if (employeeType == 2) {
//                System.out.println("Enter the annual bonus: ");
//                double annualBonus = sc.nextDouble();
//                fullTimeEmployeeArrayList.add(new FullTimeEmployee(employeeId, name,
//                        department, baseSalary, annualBonus));
//            }
//            sc.nextLine();
//            System.out.println("Add another employee? (y/n): ");
//            choice = sc.nextLine();
//        }while(!choice.equals("n"));
//
//        System.out.println("Employees list using Array List.");
//        System.out.println("Part time Employee List: ");
//        for(PartTimeEmployee partEmp : partTimeEmployeeArrayList){
//            partEmp.display();
//            System.out.println();
//        }
//        System.out.println("Full time Employee List: ");
//        for(FullTimeEmployee fullEmp : fullTimeEmployeeArrayList){
//            fullEmp.display();
//            System.out.println();
//        }
//
//        //HASHSET IMPLEMENTATION
//        HashSet<PartTimeEmployee> partTimeSet = new HashSet<>(partTimeEmployeeArrayList);
//        HashSet<FullTimeEmployee> fullTimeSet = new HashSet<>(fullTimeEmployeeArrayList);
//
//        System.out.println("Employees List using HashSet.");
//        System.out.println("Part time Employee List: ");
//        for (PartTimeEmployee emp : partTimeSet) {
//            emp.display();
//            System.out.println();
//        }
//
//        System.out.println("Full time Employee List: ");
//        for (FullTimeEmployee emp : fullTimeSet) {
//            emp.display();
//            System.out.println();
//        }
//
//        Collections.sort(partTimeEmployeeArrayList);
//        System.out.println(partTimeEmployeeArrayList);
//
//        Comparator<Employee> employeeComparator = Employee.getComparatorBySalary();
//        Collections.sort(partTimeEmployeeArrayList, employeeComparator); //Comparator implementation
//
//        Scanner sc = new Scanner(System.in);
//        HashMap<String, PartTimeEmployee> nameHashTable = new HashMap<>();
//        for(PartTimeEmployee emp : partTimeEmployeeArrayList){
//            nameHashTable.put(emp.getName(), emp);
//        }
//        HashMap<String, FullTimeEmployee> deptHashTable = new HashMap<>();
//        for(FullTimeEmployee emp : fullTimeEmployeeArrayList){
//            deptHashTable.put(emp.getDepartment(), emp);
//        }
//
//        String continueSearch = "";
//        do{
//            System.out.println("Search Parameter:\n1. Name\n2. Department\nYour Choice: ");
//            int choice = sc.nextInt();
//            sc.nextLine();
//            if(choice == 1){
//                System.out.println("Name to be searched: ");
//                String name = sc.nextLine();
//                PartTimeEmployee emp = nameHashTable.get(name);
//                if(emp == null) System.out.println("Employee not found.");
//                else emp.displaySalaryDetails();
//            }else if(choice == 2){
//                System.out.println("Department to be searched: ");
//                String dept = sc.nextLine();
//                FullTimeEmployee emp = deptHashTable.get(dept);
//                if(emp == null) System.out.println("Employee not found.");
//                else emp.displaySalaryDetails();
//            }
//            System.out.println("Another Search? (y/n): ");
//            continueSearch = sc.nextLine();
//        }while(continueSearch.equals("y"));
//
//        //QUEUE IMPLEMENTATION
//        System.out.println("\nImplementation of Priority Queue....");
//        PriorityQueue<Employee> priorityQueue = new PriorityQueue<>(new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                if(o1.getEmploymentType().equals("Full Time") &&
//                        o2.getEmploymentType().equals("Part Time"))
//                    return -1;
//                else if(o1.getEmploymentType().equals("Part Time") &&
//                        o2.getEmploymentType().equals("Full Time"))
//                    return 1;
//                return 0;
//            }
//        });
//
//        priorityQueue.addAll(fullTimeSet);
//        priorityQueue.addAll(partTimeSet);
//
//        for(Employee emp : priorityQueue){
//            emp.displaySalaryDetails();
//            System.out.println();
//        }
//
//        int i = 1;
//        while (!priorityQueue.isEmpty()) {
//            Employee emp = priorityQueue.poll();
//            System.out.println("Salary " + i + " given to :\n" + emp.displaySalaryDetails());
//            i++;
//        }

//        employeeArrayList.remove(1);
//        for(PartTimeEmployee emp : employeeArrayList)
//            emp.display();

//        PartTimeEmployee e1 = new PartTimeEmployee("1234", "Animesh", "Testing", 200, 3);
//        e1.display();
//
//        FullTimeEmployee e2 = new FullTimeEmployee("1357","Ankit","Testing", 200, 300);
//        e2.display();
//
//        EmployeeResponsibilities e = new EmployeeResponsibilities();
//        e.defineWorkHours(e1);
//        e.defineWorkHours(e2);
//
//        e.assignProject(e1);
//        e.assignProject(e2);

//        PartTimeEmployee partEmp = new PartTimeEmployee("12345", "Animesh","Testing", 20000, 12);
//        System.out.println(partEmp.display()); //Before tax deduction using annotation
//        System.out.println("Before tax deduction: "+partEmp.getBaseSalary());
//
//        Class<PartTimeEmployee> partTimeEmployeeClass = PartTimeEmployee.class;
//
//        if(partTimeEmployeeClass.isAnnotationPresent(payrollAdjustment.class)){
//            Annotation annotation = partTimeEmployeeClass.getAnnotation(payrollAdjustment.class);
//            payrollAdjustment payRollAdjustment = (payrollAdjustment) annotation;
//
//            System.out.println("Tax percentage: "+payRollAdjustment.taxDeduction());
//            partEmp.setBaseSalary(partEmp.getBaseSalary()- (partEmp.getBaseSalary()*payRollAdjustment.taxDeduction()/100));
//            System.out.println("Final Salary: "+partEmp.getBaseSalary());
//        }else{
//            System.out.println("No payroll annotation found.");
//        }

//        PartTimeEmployee partEmp = new PartTimeEmployee("12345", "Animesh", "Testing", 20000, 12);
//        FullTimeEmployee fullEmp = new FullTimeEmployee("67890", "Rohan", "Development", 40000, 5000);
//
//        System.out.println("Part-Time Employee Details (Before Tax Deduction):");
//        System.out.println(partEmp.display());
//
//        System.out.println("\nFull-Time Employee Details (Before Tax Deduction):");
//        System.out.println(fullEmp.display());
//
//        System.out.println("\nProcessing Payroll Adjustments...");
//        AnnotationProcessor.processPayrollAdjustment(partEmp);
//        AnnotationProcessor.processPayrollAdjustment(fullEmp);
//
//        System.out.println("\nPart-Time Employee Details (After Tax Deduction):");
//        System.out.println(partEmp.display());
//
//        System.out.println("\nFull-Time Employee Details (After Tax Deduction):");
//        System.out.println(fullEmp.display());

        ArrayList<PartTimeEmployee> partTimeEmployeeArrayList = new ArrayList<>();
        ArrayList<FullTimeEmployee> fullTimeEmployeeArrayList = new ArrayList<>();

        partTimeEmployeeArrayList.add(new PartTimeEmployee("12345","Animesh","testing"
        ,23456.0,12));
        partTimeEmployeeArrayList.add(new PartTimeEmployee("12345","Animesh","testing"
                ,23456.0,12));
        partTimeEmployeeArrayList.add(new PartTimeEmployee("76856","Huban","lmn"
                ,25678,9));
        partTimeEmployeeArrayList.add(new PartTimeEmployee("5678","Ankit","bvc"
                ,8898,6));
        partTimeEmployeeArrayList.add(new PartTimeEmployee("5245","Sawan","uio"
                ,9000,12));
        partTimeEmployeeArrayList.add(new PartTimeEmployee("7056","Pope","lmn"
                ,34555,2));

        fullTimeEmployeeArrayList.add(new FullTimeEmployee("12345","Animesh","testing"
                ,20000.0,1200));
        fullTimeEmployeeArrayList.add(new FullTimeEmployee("12345","Animesh","testing"
                ,23456.0,1200));
        fullTimeEmployeeArrayList.add(new FullTimeEmployee("76856","Huban","lmn"
                ,25678,2999));

//        BonusCalculator bonusCalculator = salary -> {
//            if(salary <= 0) throw new IllegalArgumentException("Salary cannot be zero or negative.");
//            return salary*0.1;
//        };
//        SalaryCalculator salaryCalculator = salary -> {
//            if(salary <= 0) throw new IllegalArgumentException("Salary cannot be zero or negative.");
//            return salary*100;
//        };



//        partTimeEmployeeArrayList.forEach(emp -> emp.setBaseSalary(bonusCalculator.calculateBonus(emp.getBaseSalary())));

//        partTimeEmployeeArrayList.forEach(emp -> emp.setBaseSalary(emp.calculateSalaryWithBonus(salaryCalculator, bonusCalculator)));
//        partTimeEmployeeArrayList.forEach(emp -> System.out.println(emp.display()));

        Predicate<PartTimeEmployee> higherSalaries = employee -> employee.getBaseSalary()>23000;
        partTimeEmployeeArrayList.stream().filter(higherSalaries).forEach(emp -> System.out.println(emp.display()));

        VariableSalaryCalculator variableSalaryCalculator = (baseSalary, percentage) -> {
            if(baseSalary<=0) throw new IllegalArgumentException("Salary cannot be zero or negative");
            if(percentage<=0) throw new IllegalArgumentException("Percentage cannot be zero or negative");
            return baseSalary+baseSalary*percentage;
        };

        partTimeEmployeeArrayList.forEach(employee -> employee.setBaseSalary(variableSalaryCalculator.calculate(employee.getBaseSalary(), 0.2)));
        fullTimeEmployeeArrayList.forEach(employee -> employee.setBaseSalary(variableSalaryCalculator.calculate(employee.getBaseSalary(), 0.3)));

        partTimeEmployeeArrayList.forEach(emp -> System.out.println(emp.display()));
        fullTimeEmployeeArrayList.forEach(emp -> System.out.println(emp.display()));

        SalaryCalculator salaryCalculator = salary -> {
            if(salary <= 0) throw new IllegalArgumentException("Salary cannot be zero or negative.");
            return salary*100;
        };
        partTimeEmployeeArrayList.forEach(employee -> employee.setBaseSalary(salaryCalculator.calculate(employee.getBaseSalary())));
        partTimeEmployeeArrayList.forEach(partTimeEmployee -> partTimeEmployee.display());

        PerformanceBonus performanceBonus = (baseSalary, rating) -> {
            if(baseSalary<=0) throw new IllegalArgumentException("Base salary cannot be zero or negative");
            if(rating<0) throw new IllegalArgumentException("Rating cannot be negative.");
            return rating>3.5 ? baseSalary+baseSalary*(rating*200) : baseSalary+baseSalary*(rating*50);
        };

        partTimeEmployeeArrayList.forEach(employee -> employee.setBaseSalary(performanceBonus.calculatePerformanceBonus(employee.getBaseSalary(), 4.2)));
        partTimeEmployeeArrayList.forEach(partTimeEmployee -> partTimeEmployee.display());

        List<Double> sortedSalaries = partTimeEmployeeArrayList.stream()
                .map(PartTimeEmployee::getBaseSalary)
                .sorted()
                .toList();
        sortedSalaries.forEach(System.out::println);

        List<Double> filterSalaries = partTimeEmployeeArrayList.stream()
                .map(PartTimeEmployee::getBaseSalary)
                .filter(salary -> salary>23000)
                .toList();
        filterSalaries.forEach(System.out::println);

        partTimeEmployeeArrayList.stream()
                .filter(employee -> employee != null) // Handle null employees
                .forEach(employee -> {
                    try {
                        System.out.println("Processing employee: " + employee.getName());
                        System.out.println(employee.display());
                    } catch (Exception e) {
                        System.out.println("Error processing employee: " + e.getMessage());
                    }
                });

        List<Double> mapSalaries = partTimeEmployeeArrayList.stream()
                .map(PartTimeEmployee::getBaseSalary)
                .map(salary -> salary*12)
                .toList();
        mapSalaries.forEach(System.out::println);
    }
}