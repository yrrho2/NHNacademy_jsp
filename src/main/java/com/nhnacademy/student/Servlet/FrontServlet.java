package com.nhnacademy.student.Servlet;


import com.nhnacademy.student.Controller.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static javax.servlet.RequestDispatcher.*;

@WebServlet(name = "frontServlet", urlPatterns = "*.do")
public class FrontServlet extends HttpServlet {
    private static final String REDIRECT_PREFIX="redirect";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 공통 처리 - 응답 content-type, character encoding 지정.
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        try {
            //todo 실제 로직을 처리할 Command(Controller) 결정, String view = command.execute() ...

            Command command = resolveCommand(req.getServletPath(), req.getMethod());

            //실제 요청을 처리한 servlet이 'view'라는 request 속성값으로 view를 전달해 줌.
            String view = command.execute(req,resp);

            if (view.startsWith(REDIRECT_PREFIX)) {
//                log.error("redirect-url : {}", view.substring(REDIRECT_PREFIX.length() + 1));
                //todo `redirect:`로 시작하면 redirect 처리.
                resp.sendRedirect(view.substring(REDIRECT_PREFIX.length()+1));

            } else {
                //todo redirect 아니면 JSP에게 view 처리를 위임하여 그 결과를 include 처리.
                RequestDispatcher rd =req.getRequestDispatcher(view.substring(REDIRECT_PREFIX.length()+1));
                rd.include(req,resp);

            }
        }catch (Exception ex){
            //공통 error 처리
            req.setAttribute("status_code", req.getAttribute(ERROR_STATUS_CODE));
            req.setAttribute("exception_type", req.getAttribute(ERROR_EXCEPTION_TYPE));
            req.setAttribute("message", req.getAttribute(ERROR_MESSAGE));
            req.setAttribute("exception", req.getAttribute(ERROR_EXCEPTION));
            req.setAttribute("request_uri", req.getAttribute(ERROR_REQUEST_URI));
            //log.error("status_code:{}", req.getAttribute(ERROR_STATUS_CODE));
            RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
            rd.forward(req,resp);
        }

    }

//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        //todo 공통 처리 - 응답 content-type, character encoding 지정.
//        resp.setContentType("text/html;charset=utf-8");
//        resp.setCharacterEncoding("UTF-8");
//
//        try{
//            //실제 요청 처리할 servlet을 결정
//            String servletPath = resolveServlet(req.getServletPath());
//            RequestDispatcher rd = req.getRequestDispatcher(servletPath);
//            rd.include(req, resp);
//
//            //실제 요청을 처리한 servlet이 'view'라는 request 속성값으로 view를 전달해 줌.
//            String view = (String) req.getAttribute("view");
//            if (view.startsWith(REDIRECT_PREFIX)) {
//                //log.error("redirect-url : {}", view.substring(REDIRECT_PREFIX.length()+1));
//                // todo  `redirect:`로 시작하면 redirect 처리.
//                resp.sendRedirect(view.substring(REDIRECT_PREFIX.length()+1));
//            } else {
//                // todo redirect 아니면 JSP에게 view 처리를 위임하여 그 결과를 include시킴.
//                rd =req.getRequestDispatcher(view.substring(REDIRECT_PREFIX.length()+1));
//                rd.include(req,resp);
//            }
//        }catch(Exception ex){
//            //todo 공통 error 처리 - ErrorServlet 참고해서 처리
//            req.setAttribute("status_code", req.getAttribute(ERROR_STATUS_CODE));
//            req.setAttribute("exception_type", req.getAttribute(ERROR_EXCEPTION_TYPE));
//            req.setAttribute("message", req.getAttribute(ERROR_MESSAGE));
//            req.setAttribute("exception", req.getAttribute(ERROR_EXCEPTION));
//            req.setAttribute("request_uri", req.getAttribute(ERROR_REQUEST_URI));
//
//            //todo  forward - /error.jsp
//            RequestDispatcher rd = req.getRequestDispatcher("/student/error.jsp");
//            rd.forward(req,resp);
//        }
//    }

    private String resolveServlet(String servletPath){
        String processingServlet = null;
        if("/student/list.do".equals(servletPath)){
            processingServlet = "/student/list";
        }else if("/student/delete.do".equals(servletPath)){
            processingServlet = "/student/delete";
        }else if("/student/register.do".equals(servletPath)){
            processingServlet = "/student/register";
        }else if("/student/view.do".equals(servletPath)){
            processingServlet = "/student/view";
        }else if("/student/update.do".equals(servletPath)){
            processingServlet = "/student/update";
        }

        //todo 실행할 servlet 결정하기

        return processingServlet;
    }
    private Command resolveCommand(String servletPath, String method){
        Command command = null;
        if("/student/list.do".equals(servletPath) && "GET".equalsIgnoreCase(method) ){
            command = new StudentListController();
        }else if("/student/view.do".equals(servletPath) && "GET".equalsIgnoreCase(method) ){
            command = new StudentViewController();
        }else if("/student/delete.do".equals(servletPath) && "POST".equalsIgnoreCase(method) ){
            command = new StudentDeleteController();
        }else if("/student/update.do".equals(servletPath) && "GET".equalsIgnoreCase(method) ){
            command = new StudentUpdateFormController();
        }else if("/student/update.do".equals(servletPath) && "POST".equalsIgnoreCase(method) ){
            command = new StudentUpdateController();
        }else if("/student/register.do".equals(servletPath) && "GET".equalsIgnoreCase(method) ){
            command = new StudentRegisterFormController();
        }else if("/student/register.do".equals(servletPath) && "POST".equalsIgnoreCase(method) ){
            command = new StudentRegisterController();
        }else if("/error.do".equals(servletPath)){
            command = new ErrorController();
        }
        return command;
    }
}