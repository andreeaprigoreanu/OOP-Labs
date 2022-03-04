package lab4.people;

import lab4.database.Database;

import java.util.*;

public class Student {
    private String firstName;
    private String lastName;
    private Map<String, Integer> subjects;

    public Student(String firstName, String lastName, Map<String, Integer> subjects) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subjects = subjects;
    }

    // TODO: copy constructor
    public Student(Student student) {
        firstName = student.getFirstName();
        lastName = student.getLastName();
        subjects = new HashMap<>();
        for (Map.Entry<String, Integer> entry : student.getSubjects().entrySet()) {
            subjects.put(entry.getKey(), entry.getValue());
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Map<String, Integer> getSubjects() {
        return subjects;
    }

    public void setSubjects(HashMap<String, Integer> subjects) {
        this.subjects = subjects;
    }

    public double averageGrade() {
        // TODO
        double sumGrades = 0;

        for(Map.Entry<String, Integer> entry : subjects.entrySet()) {
            sumGrades += (double)entry.getValue();
        }

        return sumGrades / subjects.size();
    }

    public List<Teacher> getAllTeachers() {
        // TODO
        List<Teacher> allTeachers = Database.getDatabase().findAllTeachers();
        List<Teacher> allTeachersCopy = new ArrayList<>();

        for (Teacher teacher : allTeachers) {
            allTeachersCopy.add(new Teacher(teacher));
        }
        return Collections.unmodifiableList(allTeachersCopy);
    }

    public int getGradeForSubject(String subject) {
        // TODO
        return subjects.get(subject);
    }

    @Override
    public String toString() {
        return "Student: " + firstName + " " + lastName + "\n"
                + "Subjects: " + subjects + "\n";
    }

    public List<Teacher> getTeachersBySubject(String subject) {
        // TODO
        List<Teacher> teachersBySubject = Database.getDatabase().findTeachersBySubject(subject);
        List<Teacher> teachersBySubjectCopy = new ArrayList<>();

        for (Teacher teacher : teachersBySubject) {
            teachersBySubjectCopy.add(new Teacher(teacher));
        }

        return Collections.unmodifiableList(teachersBySubjectCopy);
    }

    public List<Student> getAllStudents() {
        // TODO
        List<Student> allStudents = Database.getDatabase().findAllStudents();
        List<Student> allStudentsCopy = new ArrayList<>();

        for (Student student : allStudents) {
            allStudentsCopy.add(new Student(student));
        }

        return Collections.unmodifiableList(allStudentsCopy);
    }

    public List<Student> getStudentsBySubject(String subject) {
        // TODO
        List<Student> studentsBySubject = Database.getDatabase().getStudentsBySubject(subject);
        List<Student> studentsBySubjectCopy = new ArrayList<>();

        for (Student student : studentsBySubject) {
            studentsBySubjectCopy.add(new Student(student));
        }

        return Collections.unmodifiableList(studentsBySubjectCopy);
    }

    public List<Student> getStudentsByAverageGrade() {
        // TODO
        List<Student> studentsByAverageGrade = Database.getDatabase().getStudentsByAverageGrade();
        List<Student> studentsByAverageGradeCopy = new ArrayList<>();

        for (Student student : studentsByAverageGrade) {
            studentsByAverageGradeCopy.add(new Student(student));
        }

        return Collections.unmodifiableList(studentsByAverageGradeCopy);
    }

    public List<Student> getStudentsByGradeForSubject(String subject) {
        // TODO
        List<Student> studentsByGradeForSubject = Database.getDatabase().getStudentsByGradeForSubject(subject);
        List<Student> studentsByGradeForSubjectCopy = new ArrayList<>();

        for (Student student : studentsByGradeForSubject) {
            studentsByGradeForSubjectCopy.add(new Student(student));
        }

        return Collections.unmodifiableList(studentsByGradeForSubjectCopy);
    }
}
