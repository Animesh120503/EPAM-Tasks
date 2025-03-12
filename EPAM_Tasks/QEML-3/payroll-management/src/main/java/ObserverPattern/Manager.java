package ObserverPattern;

public class Manager implements SalaryObserver{
    @Override
    public void update(double salary){
        System.out.println("Manager notified about salary change: "+salary);
    }
}
