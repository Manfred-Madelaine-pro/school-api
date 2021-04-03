package com.shool.school.student;

import org.springframework.stereotype.Component;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class StudentService {

    Map<Long, Student> students = Stream.of(
            new AbstractMap.SimpleEntry<>(1L, new Student(1L, "Paul", 21)),
            new AbstractMap.SimpleEntry<>(2L, new Student(2L, "Maria", 29)))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public List<Student> getStudents() {
        return new ArrayList<Student>(students.values());
    }

    public Student getStudent(Long id) {
        if (students.containsKey(id)) {
            return students.get(id);
        }

        return null;
    }
}
