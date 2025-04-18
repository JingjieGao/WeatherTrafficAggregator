<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 4/18/25
  Time: 1:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/github-markdown-css/5.2.0/github-markdown-light.min.css">
    <title>Team Charter</title>
    <style>
        body {
            font-family: system-ui, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5f5f5;
        }
        .markdown-body {
            max-width: 900px;
            margin: 2rem auto;
            padding: 2rem;
            background: white;
            border: 1px solid #ddd;
            border-radius: 8px;
        }
        a {
            color: #0366d6;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body class="container">
<div>
<%
    out.write((String) request.getAttribute("teamCharterMD"));
%>
</div>

</body>
</html>
