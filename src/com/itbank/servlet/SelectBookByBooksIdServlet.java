package com.itbank.servlet;

import com.itbank.bean.Book;
import com.itbank.dao.BookDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tong on 17-6-7.
 */
@WebServlet(name = "SelectBookByBooksIdServlet",urlPatterns = "/SelectBookByBooksIdServlet")
public class SelectBookByBooksIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");

        int booksId = Integer.parseInt(request.getParameter("booksId"));
        String start = request.getParameter("start");
        String end = request.getParameter("end");

        BookDao dao = new BookDao();
        List<Book> list;

        if (start != null && end != null){
            int s = Integer.parseInt(start);
            int e = Integer.parseInt(end);
            list = dao.selectBookByBooksId(booksId,s,e);
        }else {
            list = dao.selectBookByBooksId(booksId);
        }

        JSONArray jsonArray = JSONArray.fromObject(list);
        out.print(jsonArray);
        out.flush();
        out.close();
    }
}
