package com.nhnacademy.student.Controller;

import com.nhnacademy.student.Student;
import com.nhnacademy.student.StudentRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentViewController implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        StudentRepository studentRepository = (StudentRepository) request.getServletContext().getAttribute("studentRepository");
        String id = request.getParameter("id");
        Student student = studentRepository.getStudentById(id);
        request.setAttribute("student", student);
        return "/student/view.do";
    }
}
