package lab8;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

public class StudentTest {
    private Student student1;
    private Student student2;

    @BeforeEach
    public void setUp() {
        this.student1 = new Student("Popescu", "Maria", 9946374, 9.75);
        this.student2 = new Student("Chiriac", "Irina", 6894035, 9.56);
    }

    @AfterEach
    public void clean() {
        this.student1 = null;
        this.student2 = null;
    }

    @Test
    @DisplayName("toString")
    public void testToString() {
        Assertions.assertEquals("Student{name='Popescu', surname='Maria', id=9946374, averageGrade=9.75}", this.student1.toString());
        Assertions.assertEquals("Student{name='Chiriac', surname='Irina', id=6894035, averageGrade=9.56}", this.student2.toString());
    }

    @Test
    @DisplayName("equals")
    public void testEquals() {
        Assertions.assertFalse(student1.equals(student2));
        Assertions.assertTrue(student1.equals(student1));
    }
}
