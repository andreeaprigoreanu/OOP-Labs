package lab5.task2;

import lab5.task1.Task;

import java.util.ArrayList;

public class Queue implements Container {
    private ArrayList<Task> tasks;

    public Queue() {
        tasks = new ArrayList<Task>();
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    @Override
    public Task pop() {
        if (this.isEmpty()) {
            return null;
        }

        Task task = tasks.get(0);
        tasks.remove(0);
        return task;
    }

    @Override
    public void push(Task task) {
        tasks.add(task);
    }

    @Override
    public int size() {
        return tasks.size();
    }

    @Override
    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    @Override
    public void transferFrom(Container container) {
        while (container.isEmpty() != true) {
            this.push(container.pop());
        }
    }
}
