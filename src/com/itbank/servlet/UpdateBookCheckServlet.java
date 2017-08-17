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
@WebServlet(name = "UpdateBookCheckServlet",urlPatterns = "/UpdateBookCheckServlet")
public class UpdateBookCheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");

        int bookId = Integer.parseInt(request.getParameter("bookId"));
        int check = Integer.parseInt(request.getParameter("check"));

        BookDao dao = new BookDao();
        int r = dao.updateBookCheck(bookId,check);
        if (r>0){
            out.print("true");
        }else {
            out.print("false");
        }
        out.flush();
        out.close();
    }
}
