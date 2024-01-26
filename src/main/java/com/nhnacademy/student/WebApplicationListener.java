package com.nhnacademy.student;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class WebApplicationListener  implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        StudentRepository studentRepository = new MapStudentRepository();

        for(int i=1; i<=10; i++){
            // ... student 1 ~ 10 생성하기
            // 나이 : random 처리 : 20~30
            Student student = new Student();
            student.setId(Integer.toString(i));
            student.setName("아카데미"+ i);
            student.setGender(Gender.F);

            student.setAge((int)(Math.random()*10000)%10+20);

            studentRepository.save(student);
        }

        context.setAttribute("studentRepository", studentRepository);

        // ... application scope에서 studentRepository 객체에 접근할 수 있도록 구현하기

    }
}