package ObserverPattern;

public class HR implements SalaryObserver{
    @Override
    public void update(double salary){
        System.out.println("HR notified about salary change: "+salary);
    }
}
