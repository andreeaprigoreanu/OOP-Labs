package lab1.task2;

import java.util.ArrayList;

public class Course {
    private String title;
    private String description;
    private Student[] students;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    ArrayList<Student> filerYear(Integer year) {
        ArrayList<Student> listStudents = new ArrayList<Student>();

        for (int i = 0; i < students.length; ++i) {
            if (students[i].getYear().equals(year)) {
                listStudents.add(students[i]);
            }
        }

        return listStudents;
    }
}
