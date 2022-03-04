package lab1.task2;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Course POO = new Course();

        POO.setTitle("Programare orientata pe obiecte");
        POO.setDescription("Curs de 5PC");

        Student[] students = new Student[4];
        students[0] = new Student("Adina Marin", 2021);
        students[1] = new Student("Eva Popescu", 2019);
        students[2] = new Student("Marius Mihalache", 2020);
        students[3] = new Student("Mara Pop", 2021);
        POO.setStudents(students);

        ArrayList<Student> listStudents = POO.filerYear(2021);

        System.out.println("Studentii din anul 2021: " + listStudents);
    }
}
