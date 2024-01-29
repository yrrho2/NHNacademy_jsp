<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%
    String status = (String) request.getAttribute("status_code");
    String type = (String) request.getAttribute("exception_type");
    String message = (String) request.getAttribute("message");
    String exception = (String) request.getAttribute("exception");
    String uri = (String) request.getAttribute("request_uri");
    request.setAttribute("status_code", status);
    request.setAttribute("exception_type", type);
    request.setAttribute("message", message);
    request.setAttribute("exception", exception);
    request.setAttribute("request_uri",uri);
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
        <td><!-- todo exception_type 출력 -->
            <c:out value="${exception_type}"/>
        </td>
    </tr>
    <tr>
        <th>message</th>
        <td><!-- todo message 출력 -->
            <c:out value="${message}"/>
        </td>
    </tr>
    <tr>
        <th>exception</th>
        <td><!-- todo exception 출력 -->
            <c:out value="${exception}"/>
        </td>
    </tr>
    <tr>
        <th>request_uri</th>
        <td><!-- todo request_uri 출력 -->
            <c:out value="${request_uri}"/>
        </td>
    </tr>
    </tbody>

</table>
</body>
</html>