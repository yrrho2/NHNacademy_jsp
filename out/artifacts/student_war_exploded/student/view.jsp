<%@ page import="com.nhnacademy.student.MapStudentRepository" %>
<%@ page import="com.nhnacademy.student.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ taglib prefix="cfmt" uri="http://nhnacademy.com/cfmt" %>--%>
<%
    Student student = (Student) request.getAttribute("student");

%>
<html>
<head>
    <title>학생-조회</title>
    <link rel="stylesheet" href="/style.css" />
</head>
<body>
<p>hello viewer!!</p>
<table>
    <tbody>
    <!-- todo view 구현 -->
    <tr>
        <th>아이디</th>
        <td>${student.getId()}</td>
    </tr>
    <tr>
        <th>이름</th>
        <td>${student.getName()}</td>
    </tr>
    <tr>
        <th>성별</th>
        <td>${student.getGender()}</td>
    </tr>
    <tr>
        <th>나이</th>
        <td>${student.getAge()}</td>
    </tr>
    </tbody>
</table>
<ul>
    <li><a href="/student/list">리스트</a></li>
    <li>
        <!-- todo ${update_link} 설정 c:url -->
<%--        <a href="${update_link}">수정</a>--%>
    </li>
    <li>
<%--        todo 삭제버튼 구현, method=post--%>
     </li>

 </ul>

</body>
</html>