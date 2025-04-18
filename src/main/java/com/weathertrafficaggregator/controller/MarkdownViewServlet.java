package com.weathertrafficaggregator.controller;

import com.weathertrafficaggregator.util.MarkdownUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@WebServlet(
        urlPatterns = {"/render-md", "/documentation"}
)
public class MarkdownViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        String file = req.getParameter("file");

        Path filePath;

        if ("/documentation".equals(path)) {

            filePath = Paths.get(req.getServletContext().getRealPath("/apiDocumentation.md"));
        } else if (file != null && !file.contains("..")) {
            filePath = Paths.get(req.getServletContext().getRealPath("/" + file));
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid or missing file path");
            return;
        }

        if (!Files.exists(filePath)) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Markdown file not found: " + filePath);
            return;
        }

        String markdown = Files.readString(filePath);
        String html = MarkdownUtil.renderMarkdownToHtml(markdown);

        String title = ("/documentation".equals(path)) ? "API Documentation" : filePath.getFileName().toString();
        req.setAttribute("markdownHtml", html);
        req.setAttribute("pageTitle", title);

        req.getRequestDispatcher("/markdown-view.jsp").forward(req, resp);
    }
}
