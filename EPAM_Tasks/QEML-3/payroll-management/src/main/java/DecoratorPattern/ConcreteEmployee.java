package DecoratorPattern;

public class ConcreteEmployee implements Employee{
    @Override
    public String getDescription(){
        return "Received base salary.";
    }

    @Override
    public double getSalary(){
        return 5000;
    }
}
