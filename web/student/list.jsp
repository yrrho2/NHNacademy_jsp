<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.nhnacademy.student.Student" %>
<%@ page import="com.nhnacademy.student.MapStudentRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    List<String> list = new ArrayList<>();
    list.add("hello");
    list.add("world");
    list.add("!!!");
    request.setAttribute("list", list);

    MapStudentRepository repository = (MapStudentRepository) application.getAttribute("studentRepository");
    List<Student> slist = repository.getStudents();
    request.setAttribute("student_list", slist);
%>


<html>
<head>
    <title>student - list</title>
    <link rel="stylesheet" href="/style.css" />
</head>

<body>
<h1>학생 리스트</h1>
<p><a href="/student/register.do" >학생(등록)</a></p>
<table>
    <thead>
    <tr>
        <th>아이디</th>
        <th>이름</th>
        <th>성별</th>
        <th>나이</th>
        <th>cmd</th>
    </tr>
    </thead>
    <tbody>
    <!--todo list 구현하기 c:foreach -->

<%--        <%request.getAttribute("studentList");%>--%>

<%--    <c:out value="${applicationScope.studentList}">--%>

        <c:forEach  items="${student_list}" var="student">
        <tr>
            <td>${student.getId()}</td>
            <td>${student.getName()}</td>
            <td>${student.getGender()}</td>
            <td>${student.getAge()}</td>
            <td>조회</td>
        </tr>

        </c:forEach>

<%--    <c:forEach items="${list}" var="item">--%>
<%--        <tr>--%>
<%--            <td>${item}</td>--%>
<%--            <td>${item}</td>--%>
<%--            <td>${item}</td>--%>
<%--            <td>${item}</td>--%>
<%--            <td>${item}</td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
    </tbody>
</table>
</body>
</html>