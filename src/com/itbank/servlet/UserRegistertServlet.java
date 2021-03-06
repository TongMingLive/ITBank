package com.itbank.servlet;

import com.itbank.dao.RegistertDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by tong- on 2017/5/25.
 */
@WebServlet(name = "UserRegistertServlet",urlPatterns = "/UserRegistertServlet")
public class UserRegistertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");

        int userId = Integer.parseInt(request.getParameter("userId"));

        RegistertDao dao = new RegistertDao();
        String o = dao.userRegistert(userId);

        out.print(o);

        out.flush();
        out.close();
    }
}
