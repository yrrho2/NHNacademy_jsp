package com.nhnacademy.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapStudentRepository implements StudentRepository{
    private final Map<String, Student> studentsMap = new ConcurrentHashMap<>();
    @Override
    public void save(Student student) {
        studentsMap.put(student.getId(),student);
    }

    @Override
    public void update(Student student) {
        studentsMap.replace(student.getId(),student);

    }

    @Override
    public void deleteById(String id) {
        studentsMap.remove(id);
    }

    @Override
    public Student getStudentById(String id) {
        return studentsMap.get(id);
    }

    @Override
    public List<Student> getStudents() {
        ArrayList<Student> list = new ArrayList<>();
        for (String str : studentsMap.keySet()) {
            list.add(studentsMap.get(str));
        }
        return list;
    }

    @Override
    public boolean existById(String id) {
        return studentsMap.containsKey(id);
    }
}
