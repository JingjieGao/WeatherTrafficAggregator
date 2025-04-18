<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 4/18/25
  Time: 2:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${pageTitle}</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/github-markdown-css/5.2.0/github-markdown-light.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
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
        .markdown-body table {
            border-collapse: collapse;
            width: 100%;
            margin-bottom: 1.5rem;
        }

        .markdown-body th,
        .markdown-body td {
            border: 1px solid #ddd;
            padding: 0.5rem;
            text-align: left;
            background: #fff;
        }

        .markdown-body th {
            background-color: #f6f8fa;
            font-weight: bold;
        }

    </style>
</head>
<body class="container">
<article class="markdown-body">
    <% out.write((String) request.getAttribute("markdownHtml")); %>
</article>
</body>
</html>

