package com.nhnacademy.student.Controller;

import com.nhnacademy.student.Student;
import com.nhnacademy.student.StudentRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentUpdateFormController implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        StudentRepository studentRepository = (StudentRepository) request.getServletContext().getAttribute("studentRepository");
        Student student = studentRepository.getStudentById((String) request.getParameter("id"));
        request.setAttribute("student",student);
        return "/student/register.jsp";
    }
}
