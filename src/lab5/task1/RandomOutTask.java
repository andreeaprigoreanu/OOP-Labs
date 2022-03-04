package lab5.task1;

public class RandomOutTask implements Task {
    double rand;

    public RandomOutTask() {
        rand = Math.random();
    }

    @Override
    public void execute() {
        System.out.println("Random number: " + rand);
    }
}
