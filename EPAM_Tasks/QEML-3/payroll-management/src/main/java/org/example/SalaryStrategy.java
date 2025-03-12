package org.example;

public interface SalaryStrategy {
    public double calculateSalary(double baseSalary, double bonusPercentage);
}

class FixedSalaryStrategy implements SalaryStrategy{
    @Override
    public double calculateSalary(double baseSalary, double bonusPercentage){
        return baseSalary + (baseSalary * bonusPercentage/100);
    }
}

class HourlySalaryStrategy implements SalaryStrategy{
    private double hourlyRate;
    private int hoursWorked;

    public HourlySalaryStrategy(double hourlyRate, int hoursWorked){
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary(double baseSalary, double bonusPercentage){
        return (hourlyRate * hoursWorked) + (baseSalary * bonusPercentage/100);
    }
}