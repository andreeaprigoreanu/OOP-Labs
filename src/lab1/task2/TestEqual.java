package lab1.task2;

public class TestEqual {
    public static void main(String[] args) {
        Student student1 = new Student("Ana", 2019);
        Student student2 = new Student("Ana", 2019);

        if (student1.equals(student2)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
