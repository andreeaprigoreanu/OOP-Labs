package lab8;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        // task 2
        System.out.println("Task 2");
        List<Student> students = new ArrayList<>();
        Student  student1 = new Student("Popescu", "Maria", 9946374, 9.75);
        students.add(student1);
        Student student2 = new Student("Popescu", "Andrei", 5894035, 9.75);
        students.add(student2);
        Student student3 = new Student("Mihalache", "Maria", 8546034, 9.66);
        students.add(student3);
        Student student4 = new Student("Craciun", "Florentina", 7678493, 9.81);
        students.add(student4);
        Student student5 = new Student("Chiriac", "Irina", 6894035, 9.56);
        students.add(student5);

        Collections.sort(students);
        System.out.println(students);

        // task 3
        System.out.println();
        System.out.println("Task 3");
        students.sort((firstStudent, secondStudent) -> Double.compare(firstStudent.getAverageGrade(), secondStudent.getAverageGrade()));
        System.out.println(students);

        // task 4
        System.out.println();
        System.out.println("Task 5");
        PriorityQueue<Student> studentsQueue= new PriorityQueue<>(new Comparator<Student>() {
            @Override
            public int compare(Student student1, Student student2) {
                return Long.compare(student1.getId(), student2.getId());
            }
        });
        studentsQueue.addAll(students);
        System.out.println(studentsQueue);

        // task 6
        System.out.println();
        System.out.println("Task 6");
        HashMap<Student, LinkedList<String>> studentsMap= new HashMap<>();
        studentsMap.put(student1, new LinkedList<>(List.of("POO", "AA", "EEA")));
        studentsMap.put(student2, new LinkedList<>(List.of("Mate1", "Mate2", "MN")));
        studentsMap.put(student3, new LinkedList<>(List.of("PC", "SD", "USO")));
        studentsMap.put(student4, new LinkedList<>(List.of("IOCLA", "POO", "AA")));
        studentsMap.put(student5, new LinkedList<>(List.of("ELTH", "MN", "Mate3")));
        for(Map.Entry<Student, LinkedList<String>> entry : studentsMap.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println("Lista de materii: " + entry.getValue());
        }

        // task 7
        System.out.println();
        System.out.println("Task 7");
        EvenLinkedHashSet evenLinkedHashSet = new EvenLinkedHashSet();
        evenLinkedHashSet.add(22);
        evenLinkedHashSet.add(55);
        evenLinkedHashSet.add(66);
        evenLinkedHashSet.add(88);
        evenLinkedHashSet.add(99);
        evenLinkedHashSet.add(44);

        System.out.println("evenLinkedHashSet:");
        // elementele se vor afisa in ordinea inserarii
        Iterator<Integer> it1 = evenLinkedHashSet.iterator();
        while (it1.hasNext()) {
            System.out.println(it1.next());
        }

        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(30);
        hashSet.add(40);
        hashSet.add(50);
        hashSet.add(80);
        hashSet.add(20);

        System.out.println("hashSet:");
        // elementele se vor afisa in ordine aleatoare
        Iterator<Integer> it2 = hashSet.iterator();
        while (it2.hasNext()) {
            System.out.println(it2.next());
        }

        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(12);
        treeSet.add(26);
        treeSet.add(17);
        treeSet.add(78);
        treeSet.add(21);

        System.out.println("treeSet:");
        // elementele se vor afisa in ordine crescatoare
        Iterator<Integer> it3 = treeSet.iterator();
        while (it3.hasNext()) {
            System.out.println(it3.next());
        }
    }
}
