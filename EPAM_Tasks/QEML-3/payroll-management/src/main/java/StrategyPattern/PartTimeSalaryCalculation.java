package StrategyPattern;

import FactoryPattern.PartTimeEmployee;

public class PartTimeSalaryCalculation implements SalaryCalculation{
    private int hoursWorked;
    private final int hourlyRate = 40;

    public PartTimeSalaryCalculation(int hoursWorked){
        if(hoursWorked<0) throw new IllegalArgumentException("Provided input is negative.");

        this.hoursWorked = hoursWorked;
    }
    @Override
    public double calculateSalaryProcess(){
        return hourlyRate * hoursWorked;
    }
}
