package lab9.dataprocessing;

import lab9.main.Utils;
import lab9.storage.DataRepository;
import lab9.storage.SensorData;

import java.util.List;

public class StepCountStrategyFactory {
    public static StepCountStrategy createStepCountStrategy(String strategyType,
                                                            DataRepository dataRepository) {
        if (strategyType.equals(Utils.BASIC_STRATEGY)) {
            return new BasicStepCountStrategy(dataRepository);
        } else {
            if (strategyType.equals(Utils.FILTERED_STRATEGY)) {
                return new FilteredStepCountStrategy(dataRepository);
            }
        }
        throw new IllegalArgumentException("StepCountStrategy type is not recognized");
    }
}
