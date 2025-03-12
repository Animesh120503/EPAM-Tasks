package DecoratorPattern;

public abstract class SalaryDecorator implements Employee{
    Employee decoratedEmployee;

    public SalaryDecorator(Employee decoratedEmployee){
        this.decoratedEmployee = decoratedEmployee;
    }

    @Override
    public String getDescription(){
        return decoratedEmployee.getDescription();
    }

    @Override
    public double getSalary(){
        return decoratedEmployee.getSalary();
    }
}
