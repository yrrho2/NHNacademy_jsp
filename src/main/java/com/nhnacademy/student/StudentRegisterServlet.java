package com.nhnacademy.student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "studentRegisterServlet", urlPatterns = "/student/register")
public class StudentRegisterServlet extends HttpServlet {

    private StudentRepository studentRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        //todo  init studentRepository
        studentRepository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //todo  /student/register.jsp forward 합니다.
//        RequestDispatcher rd = req.getRequestDispatcher("/student/register.jsp");
//        rd.forward(req,resp);
        req.setAttribute("view", "/student/register.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //todo null check
        Student student= new Student();
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String age = req.getParameter("age");

        if(id == null)throw new NullPointerException();
        if(name == null)throw new NullPointerException();
        if(gender == null)throw new NullPointerException();
        if(age == null)throw new NullPointerException();


        //todo save 구현
        student.setId(id);
        student.setName(name);
        student.setGender((gender.equals(Gender.M.getLabel())?Gender.M:Gender.F));
        student.setAge(Integer.parseInt(age));
        studentRepository.save(student);

        //todo redirect /student/view?id=student1
//        resp.sendRedirect("/student/view?id="+id);
        req.setAttribute("view", "redirect:/student/view.do?id="+id);
    }

}