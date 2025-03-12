package org.example;

public class PermanentEmployee extends EmployeeType implements Payable{
    private String employeeId;
    private String name;
    int numberOfDaysWorked;

    public PermanentEmployee(String employeeId, String name, int numberOfDaysWorked){
        if(employeeId == null || employeeId.isEmpty()) throw new IllegalArgumentException("Employee ID cannot be null or empty.");
        if(name == null || name.isEmpty()) throw new IllegalArgumentException("name cannot be null or empty.");
        if(numberOfDaysWorked <0 ) throw new IllegalArgumentException("Number of days worked cannot be negative.");

        this.employeeId = employeeId;
        this.name = name;
        this.numberOfDaysWorked = numberOfDaysWorked;
    }

    @Override
    public double calculatePay() {
        return calculateWorkHours()*2000;
    }

    @Override
    public double calculateWorkHours() {
        return 8*numberOfDaysWorked;
    }

    public void displayDetails(){
        System.out.println("Name: "+name+"\nEmployee ID: "+employeeId+"\nNumber of days worked: "+
                numberOfDaysWorked+"\nAmount payable: "+calculatePay());
    }
}
