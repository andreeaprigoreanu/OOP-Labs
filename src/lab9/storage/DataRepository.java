package lab9.storage;


import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Persists sensor data. Observable, its observers are notified when data is added it to.
 */
public class DataRepository extends Observable { // TODO make this an Observable
    private List<SensorData> dataRecords;
    private List<Observer> observers;

    public DataRepository() {
        dataRecords = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public void addData(SensorData dataRecord){
        // TODO
        // store data (e.g. in a List)
        // notify observers
        dataRecords.add(dataRecord);
        this.notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this, null);
        }
    }

    @Override
    public synchronized void addObserver(Observer o) {
        observers.add(o);
    }

    // TODO implement a method to get the stored data (needed by the strategies)
    public List<SensorData> getDataRecords() {
        return dataRecords;
    }
}


