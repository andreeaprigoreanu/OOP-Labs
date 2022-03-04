package lab4.database;

import lab4.people.Student;
import lab4.people.Teacher;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Database {
    private final List<Student> students = new ArrayList<>();
    private final List<Teacher> teachers = new ArrayList<>();
    private static Database instance = null;
    private static int numberOfInstances = 0;

    // TODO: make it Singleton
    private Database() {
        numberOfInstances++;
    }

    public static Database getDatabase() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public static int getNumberOfInstances() {
        // TODO
        return numberOfInstances;
    }

    public void addTeachers(List<Teacher> teachers) {
        this.teachers.addAll(teachers);
    }

    public void addStudents(List<Student> students) {
        this.students.addAll(students);
    }

    public List<Teacher> findTeachersBySubject(String subject) {
        // TODO
        List<Teacher> teachersBySubejct = new ArrayList<>();

        for (Teacher teacher : teachers) {
            if (teacher.getSubjects().contains(subject)) {
                teachersBySubejct.add(teacher);
            }
        }
        return teachersBySubejct;
    }

    public List<Student> findAllStudents() {
        // TODO
        List<Student> allStudents = new ArrayList<>(students);
        return allStudents;
    }

    public List<Teacher> findAllTeachers() {
        // TODO
        List<Teacher> allTeachers = new ArrayList<>(teachers);
        return allTeachers;
    }

    public List<Student> getStudentsBySubject(String subject) {
        // TODO
        List<Student> studentsBySubject = new ArrayList<>();

        for (Student student : students) {
            if (student.getSubjects().containsKey(subject)) {
                studentsBySubject.add(student);
            }
        }
        return studentsBySubject;
    }

    public List<Student> getStudentsByAverageGrade() {
        // TODO
        List<Student> studentsByAverageGrade = new ArrayList<>();

        for (Student student : students) {
            studentsByAverageGrade.add(student);
        }

        studentsByAverageGrade.sort(new Comparator<Student>() {
            @Override
                    public int compare(Student s1, Student s2) {
                        return (int) (s1.averageGrade() - s2.averageGrade());
            }
        });

        return studentsByAverageGrade;
    }

    public List<Student> getStudentsByGradeForSubject(String subject) {
        // TODO
        List<Student> studentsByGradeForSubject = new ArrayList<>();

        for (Student student : students) {
            if (student.getSubjects().containsKey(subject)) {
                studentsByGradeForSubject.add(student);
            }
        }

        studentsByGradeForSubject.sort(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return (int) (s1.getGradeForSubject(subject) - s2.getGradeForSubject(subject));
            }
        });

        return studentsByGradeForSubject;
    }
}
