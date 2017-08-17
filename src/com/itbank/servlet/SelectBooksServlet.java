package com.itbank.servlet;

import com.itbank.bean.Books;
import com.itbank.dao.BooksDao;
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
 * Created by tong- on 2017/5/25.
 */
@WebServlet(name = "SelectBooksServlet",urlPatterns = "/SelectBooksServlet")
public class SelectBooksServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");

        BooksDao dao = new BooksDao();
        List<Books> list = dao.selectBooks();

        JSONArray jsonArray = JSONArray.fromObject(list);
        out.print(jsonArray);

        out.flush();
        out.close();
    }
}
