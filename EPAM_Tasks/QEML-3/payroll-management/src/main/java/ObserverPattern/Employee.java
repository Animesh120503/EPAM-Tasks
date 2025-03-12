package ObserverPattern;

public interface Employee {
    void addObserver(SalaryObserver observer);
    void removeObserver(SalaryObserver observer);
    void notifyObservers();
}
