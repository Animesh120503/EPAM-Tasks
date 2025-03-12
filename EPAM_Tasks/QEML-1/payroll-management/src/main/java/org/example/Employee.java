package org.example;

import java.util.Comparator;
import java.util.Objects;

class PayrollComputationException extends Exception{
    public PayrollComputationException(String message){
        super(message);
    }
}
public abstract class Employee implements Comparable<Employee> {
    private String employeeId;
    private String name;
    private String department;
    private double baseSalary;

    public Employee(String employeeId, String name, String department, double baseSalary){
        if(employeeId == null || employeeId.isEmpty()) throw new IllegalArgumentException("Employee ID cannot be zero.");
        if(name == null || name.isEmpty()) throw new IllegalArgumentException("Name cannot be null or empty.");
        if(department == null || department.isEmpty()) throw new IllegalArgumentException("Department name cannot be null or empty.");
        if(baseSalary<0) throw new IllegalArgumentException("Base salary cannot be negative.");
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.baseSalary = baseSalary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId){
        if(employeeId == null) throw new NullPointerException("Employee ID is null");
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null) throw new NullPointerException("Name is null");
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        if(department == null) throw new NullPointerException("Department is null");
        this.department = department;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if(baseSalary<0) throw new IllegalArgumentException("Salary cannot be less than zero.");
        this.baseSalary = baseSalary;
    }

    public abstract String getEmploymentType();

    abstract public double salaryCalculation(double baseSalary) throws PayrollComputationException;

    public String displaySalaryDetails() {
        StringBuilder maskedEmployeeId = new StringBuilder();
        maskedEmployeeId.append(employeeId, 0, 2);
        for(int i=2;i<employeeId.length();i++){
            maskedEmployeeId.append("*");
        }
        return "Employee ID: "+maskedEmployeeId+"\nEmployment Type: "+getEmploymentType()+"\nName: "+name+"\nDepartment: "
                +department+"\nBase Salary: "+baseSalary;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Employee emp = (Employee) obj;
        return Objects.equals(getEmployeeId(), emp.getEmployeeId());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", baseSalary=" + baseSalary +
                '}';
    }

    @Override
    public int hashCode(){
        return Objects.hash(getEmployeeId());
    }

    @Override
    public int compareTo(Employee emp){
        return this.name.compareTo(emp.name);
    }

    public static Comparator<Employee> getComparatorBySalary(){
        return new Comparator<Employee>(){
            @Override
            public int compare(Employee e1, Employee e2){
                if(e1.baseSalary>e2.baseSalary) return 1;
                else if(e1.baseSalary<e2.baseSalary) return -1;
                return 0;
            }
        };
    }

    public double calculateSalaryWithBonus(SalaryCalculator salaryCalculator, BonusCalculator bonusCalculator){
        return bonusCalculator.calculateBonus(baseSalary)+salaryCalculator.calculate(baseSalary);
    }

}
