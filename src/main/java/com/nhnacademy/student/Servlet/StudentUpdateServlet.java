package com.nhnacademy.student.Servlet;

import com.nhnacademy.student.Gender;
import com.nhnacademy.student.Student;
import com.nhnacademy.student.StudentRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "studentUpdateServlet", urlPatterns = "/student/update")
public class StudentUpdateServlet extends HttpServlet {
    private StudentRepository studentRepository;
    @Override
    public void init(ServletConfig config) throws ServletException {
        //todo init studentRepository
        studentRepository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //todo 학생조회
        Student student = studentRepository.
                getStudentById(req.getParameter("id"));
        req.setAttribute("student",student);

        //todo forward : /student/register.jsp
//        RequestDispatcher rd = req.getRequestDispatcher("/student/register.jsp");
//        rd.forward(req,resp);
        req.setAttribute("view", "/student/register.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //todo null check
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String age = req.getParameter("age");

        if(id == null)throw new NullPointerException();
        if(name == null)throw new NullPointerException();
        if(gender == null)throw new NullPointerException();
        if(age == null)throw new NullPointerException();

        Student student = studentRepository.getStudentById(id);

        student.setId(id);
        student.setName(name);
        student.setGender((gender.equals(Gender.M.getLabel())?Gender.M:Gender.F));
        student.setAge(Integer.parseInt(age));

        //todo student 저장
        studentRepository.update(student);

        //todo /student/view?id=student1 <-- redirect
//        resp.sendRedirect("/student/view?id="+id);
        req.setAttribute("view", "redirect:/student/view?id="+id);
    }
}
