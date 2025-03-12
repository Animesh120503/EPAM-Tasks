package DecoratorPattern;

public class AnnualBonus extends SalaryDecorator{
    public AnnualBonus(Employee decoratedEmployee){
        super(decoratedEmployee);
    }
    @Override
    public String getDescription(){
        return decoratedEmployee.getDescription()+", added annual bonus";
    }

    @Override
    public double getSalary(){
        return decoratedEmployee.getSalary()+400.0;
    }
}
