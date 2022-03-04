package lab9.storage;

import lab9.dataprocessing.StepCountStrategy;

import java.util.Observable;
import java.util.Observer;

public class DataAggregator implements Observer {
    StepCountStrategy stepCountStrategy;

    public DataAggregator(StepCountStrategy stepCountStrategy) {
        this.stepCountStrategy = stepCountStrategy;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Total steps: " + stepCountStrategy.getTotalSteps());
    }

}
