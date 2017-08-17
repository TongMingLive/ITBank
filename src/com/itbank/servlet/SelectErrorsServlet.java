package com.itbank.servlet;

import com.itbank.bean.Book;
import com.itbank.dao.BookDao;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by tong on 17-6-7.
 */
@WebServlet(name = "SelectErrorsServlet",urlPatterns = "/SelectErrorsServlet")
public class SelectErrorsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");

        int userId = Integer.parseInt(request.getParameter("userId"));
        String books = request.getParameter("booksId");

        BookDao dao = new BookDao();
        List<Book> list;

        if (books != null){
            list = dao.selectErrors(userId);
        }else {
            int booksId = Integer.parseInt(books);
            list = dao.selectErrors(userId,booksId);
        }

        JSONArray jsonArray = JSONArray.fromObject(list);
        out.print(jsonArray);
        out.flush();
        out.close();
    }
}
