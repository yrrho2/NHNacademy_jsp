<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%
    String status = (String) request.getAttribute("status_code");
%>
<html>
<head>
    <title>Error Page</title>
    <link rel="stylesheet" href="style.css" />
</head>
<body>

<table>
    <tbody>
    <tr>
        <th>status_code</th>
        <td><!-- todo status_code 출력 -->
            <c:out value="${status_code}"/>
        </td>
    </tr>
    <tr>
        <th>exception_type</th>
        <td><!-- todo exception_type 출력 --></td>
    </tr>
    <tr>
        <th>message</th>
        <td><!-- todo message 출력 --></td>
    </tr>
    <tr>
        <th>exception</th>
        <td><!-- todo exception 출력 --></td>
    </tr>
    <tr>
        <th>request_uri</th>
        <td><!-- todo request_uri 출력 --></td>
    </tr>
    </tbody>

</table>
</body>
</html>