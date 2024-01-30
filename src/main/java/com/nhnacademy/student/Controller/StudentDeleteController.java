package com.nhnacademy.student.Controller;

import com.nhnacademy.student.StudentRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentDeleteController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        StudentRepository studentRepository = (StudentRepository) req.getServletContext().getAttribute("studentRepository");
        String id = req.getParameter("id");
        //log.error("id:{}",id);
        studentRepository.deleteById(id);
        //view를 return 합니다.
        return "redirect:/student/list.do";
    }

}