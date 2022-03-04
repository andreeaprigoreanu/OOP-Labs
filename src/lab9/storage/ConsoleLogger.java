package lab9.storage;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ConsoleLogger implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        List<SensorData> dataRecords = ((DataRepository)o).getDataRecords();
        System.out.println("Changes: " + dataRecords.get(dataRecords.size() - 1).toString());
    }
}
