package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StudentTest {

    @Test
    public void whenSortStudentByScopeThenTakeThemToMaxScope() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Marat", 30));
        students.add(new Student("Oleg", 29));
        students.add(null);
        students.add(new Student("Azat", 32));
        students.add(null);
        students.add(new Student("Kosty", 31));
        students.add(new Student("Stas", 35));
        /*List<Student> students = List.of(
        new Student("Marat", 30),
        new Student("Oleg", 29),
        null,
        new Student("Azat", 32),
        null,
        new Student("Kosty", 31),
        new Student("Stas", 35)
        );*/
        List<Student> result = Student.levelOf(students, 31);
        assertThat(result.get(0).getName(), is("Stas"));
    }

}