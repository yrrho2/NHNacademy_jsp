<%@ page import="com.nhnacademy.student.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>학생-등록</title>
    <link rel="stylesheet" href="/style.css" />
    <meta charset="UTF-8" />
</head>

<body>
<!-- todo action 주소 설정
    //등록
        action = /student/register
    //수정
        action = /student/update
-->
<%
    String action = "/student/register";
    Student student = (Student) request.getAttribute("student");

    request.setAttribute("student", student);
    request.setAttribute("action", action);
%>

<form method="post" action="${action}">
    <table>
        <tbody>
        <tr>
            <th>ID</th>
            <td><input type="text" name="id" value="${student.getId()}" required /></td>
        </tr>
        <tr>
            <th>이름</th>
            <td><input type="text" name="name" value="${student.getName()}" required /></td>
        </tr>
        <tr>
            <th>성별</th>
            <td>
                <input type="radio" name="gender" value="male"/>남자
                <input type="radio" name="gender" value="female"/>여자
            </td>
        </tr>
        <tr>
            <th>나이</th>
            <td><input type="text" name="age" value="${student.getAge()}" required /></td>
        </tr>
        </tbody>
    </table>
    <p>
        <button type="submit">
            <c:choose>
                <c:when test="${empty student}">
                    등록
                </c:when>
                <c:otherwise>
                    수정
                </c:otherwise>
            </c:choose>
        </button>
    </p>
</form>
</body>
</html>