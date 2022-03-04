package lab5.task1;

public class CounterOutTask implements Task {
    public static int counter;

    @Override
    public void execute() {
        counter++;
        System.out.println("Counter: " + counter);
    }
}
