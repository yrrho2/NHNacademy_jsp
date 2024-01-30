package com.nhnacademy.student.Controller;

import com.nhnacademy.student.Gender;
import com.nhnacademy.student.Student;
import com.nhnacademy.student.StudentRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentRegisterController implements Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        StudentRepository studentRepository = (StudentRepository) request.getServletContext().getAttribute("studentRepository");

        Student student= new Student();
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String age = request.getParameter("age");

        if(id == null)throw new NullPointerException();
        if(name == null)throw new NullPointerException();
        if(gender == null)throw new NullPointerException();
        if(age == null)throw new NullPointerException();

        student.setId(id);
        student.setName(name);
        student.setGender((gender.equals(Gender.M.getLabel())?Gender.M:Gender.F));
        student.setAge(Integer.parseInt(age));
        studentRepository.save(student);


        return ("redirect:/student/view.do?id="+id);
    }
}
