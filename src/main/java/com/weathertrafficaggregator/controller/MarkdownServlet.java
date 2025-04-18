package com.weathertrafficaggregator.controller;

import com.weathertrafficaggregator.util.MarkdownUtil;

import javax.servlet.RequestDispatcher;
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
        urlPatterns = {"/team-charter"}
)
public class MarkdownServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        Path filePath = Paths.get(req.getServletContext().getRealPath("/TeamCharter.md"));
        String markdown = Files.readString(filePath);


        String html = MarkdownUtil.renderMarkdownToHtml(markdown);


        req.setAttribute("teamCharterMD", html);
        req.getRequestDispatcher("team-charter.jsp").forward(req, resp);


    }
}
