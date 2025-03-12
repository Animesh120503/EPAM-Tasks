package org.example;

public class Contractor implements Payable{
    private String name;
    double workingContract;

    public Contractor(String name, double workingContract){
        if(name == null || name.isEmpty()) throw new IllegalArgumentException("Name cannot be null or empty");
        if(workingContract <= 0.0) throw new IllegalArgumentException("Contract cannot be zero or below zero.");

        this.name = name;
        this.workingContract = workingContract;
    }
    @Override
    public double calculatePay() {
        return workingContract*2000;
    }

    public void displayDetails(){
        System.out.println("Name: "+name+"\nWorking Contract: "+workingContract+
                "\nTotal payable amount: "+calculatePay());
    }
}
