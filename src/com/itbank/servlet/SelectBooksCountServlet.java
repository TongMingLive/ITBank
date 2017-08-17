package com.itbank.servlet;

import com.itbank.dao.BookDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by tong on 17-6-7.
 */
@WebServlet(name = "SelectBooksCountServlet",urlPatterns = "/SelectBooksCountServlet")
public class SelectBooksCountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");

        int booksId = Integer.parseInt(request.getParameter("booksId"));

        BookDao dao = new BookDao();
        int count = dao.selectBooksCount(booksId);

        out.print(count);

        out.flush();
        out.close();
    }
}
