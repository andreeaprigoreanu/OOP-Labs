package lab9.dataprocessing;

import lab9.storage.DataRepository;
import lab9.storage.SensorData;

import java.util.List;

public class BasicStepCountStrategy implements StepCountStrategy {
    private final DataRepository dataRepository;

    public BasicStepCountStrategy(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public int getTotalSteps() {
        List<SensorData> dataRecords = dataRepository.getDataRecords();
        int sumSteps = 0;
        for (SensorData sensorData : dataRecords) {
            sumSteps += sensorData.getStepsCount();
        }

        return sumSteps;
    }

    @Override
    public String getStrategyDescription() {
        return "BasicStepCountStrategy sums up all the step data received so far";
    }
}
