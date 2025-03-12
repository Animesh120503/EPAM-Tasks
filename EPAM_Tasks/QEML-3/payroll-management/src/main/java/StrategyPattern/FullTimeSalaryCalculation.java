package StrategyPattern;

public class FullTimeSalaryCalculation implements SalaryCalculation{
    private int noOfDaysWorked;
    private int perDayPay;

    public FullTimeSalaryCalculation(int noOfDaysWorked, int perDayPay){
        if(noOfDaysWorked<0 || perDayPay<0) throw new IllegalArgumentException("Provided input is negative.");

        this.noOfDaysWorked = noOfDaysWorked;
        this.perDayPay = perDayPay;
    }

    @Override
    public double calculateSalaryProcess(){
        return noOfDaysWorked * perDayPay;
    }
}
