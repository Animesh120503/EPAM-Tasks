package DecoratorPattern;

public class FestivalBonus extends SalaryDecorator{
    public FestivalBonus(Employee decoratedEmployee){
        super(decoratedEmployee);
    }

    @Override
    public String getDescription(){
        return decoratedEmployee.getDescription()+", added festival bonus";
    }

    @Override
    public double getSalary(){
        return decoratedEmployee.getSalary()+150;
    }
}
