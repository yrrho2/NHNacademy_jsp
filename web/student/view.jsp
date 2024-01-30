<%@ page import="com.nhnacademy.student.MapStudentRepository" %>
<%@ page import="com.nhnacademy.student.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="cfmt" uri="http://nhnacademy.com/cfmt" %>
<%
    String update_link = "/student/update.do";
    request.setAttribute("update_link", update_link);
%>
<html>
<head>
    <title>학생-조회</title>
    <link rel="stylesheet" href="/style.css" />
</head>
<body>
<p>hello viewer!!</p>
<table style="border:solid black">
    <tbody >
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
    <tr>
        <th>등록일</th>
        <td>
            ${cfmt:formatDate(student.getCreatedAt(), 'yyyy-MM-dd HH:mm:ss')}
        </td>
    </tr>
    </tbody>
</table>
<ul>
    <li><a href="/student/list.do">리스트</a></li>
    <li>
        <!-- todo ${update_link} 설정 c:url -->
        <c:url var="updateData" value="${update_link}">
            <c:param name="id" value= "${student.getId()}"/>
        </c:url>
        <a href="${updateData}">수정</a>
    </li>
    <li>
<%--        todo 삭제버튼 구현, method=post--%>
        <form method="post" action="/student/delete.do">
            <input type="hidden" name="id" value="${student.getId()}">
            <a type="submit "></a>
            <input type="submit" value="삭제">
        </form>
     </li>

 </ul>

</body>
</html>