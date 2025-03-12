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

    public Employee(String employeeId, String name, String department){
        if(employeeId == null || employeeId.isEmpty()) throw new IllegalArgumentException("Employee ID cannot be zero.");
        if(name == null || name.isEmpty()) throw new IllegalArgumentException("Name cannot be null or empty.");
        if(department == null || department.isEmpty()) throw new IllegalArgumentException("Department name cannot be null or empty.");

        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
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

    public abstract String getEmploymentType();

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
                ", department='" + department+"}";
    }

    @Override
    public int hashCode(){
        return Objects.hash(getEmployeeId());
    }

    @Override
    public int compareTo(Employee emp){
        return this.name.compareTo(emp.name);
    }

}
