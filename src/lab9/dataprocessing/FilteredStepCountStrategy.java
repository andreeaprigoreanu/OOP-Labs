package lab9.dataprocessing;

import lab9.main.Utils;
import lab9.storage.DataRepository;
import lab9.storage.SensorData;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FilteredStepCountStrategy implements StepCountStrategy {
    private final DataRepository dataRepository;
    private static final int MAX_DIFF_STEPS_CONSECUTIVE_RECORDS = 1000;
    private static final long TIME_FOR_MAX_DIFF = TimeUnit.SECONDS.toMillis(1);

    public FilteredStepCountStrategy(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public int getTotalSteps() {
        List<SensorData> dataRecords = dataRepository.getDataRecords();
        int sumSteps = 0;
        for (SensorData sensorData : dataRecords) {
            if (sensorData.getStepsCount() > 0 && !(sensorData.getStepsCount() > MAX_DIFF_STEPS_CONSECUTIVE_RECORDS
                    && sensorData.getTimestamp() < TIME_FOR_MAX_DIFF)) {
                sumSteps += sensorData.getStepsCount();
            }
        }
        return sumSteps;
    }

    @Override
    public String getStrategyDescription() {
        return "FilteredStepCountStrategy sums up all the step data but filtering outliers";
    }
}
