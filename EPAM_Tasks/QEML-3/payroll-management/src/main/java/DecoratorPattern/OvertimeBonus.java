package DecoratorPattern;

public class OvertimeBonus extends SalaryDecorator{
    int hoursWorked;
    public OvertimeBonus(int hoursWorked, Employee decoratedEmployee){
        super(decoratedEmployee);

        if(hoursWorked<0) throw new IllegalArgumentException("Provided input is negative.");
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String getDescription(){
        return decoratedEmployee.getDescription()+", added overtime bonus";
    }

    @Override
    public double getSalary(){
        return decoratedEmployee.getSalary()+(hoursWorked*50);
    }
}
