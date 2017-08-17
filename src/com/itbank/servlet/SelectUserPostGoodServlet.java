package com.itbank.servlet;

import com.itbank.dao.PostDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by tong on 17-6-1.
 */
@WebServlet(name = "SelectUserPostGoodServlet",urlPatterns = "/SelectUserPostGoodServlet")
public class SelectUserPostGoodServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");

        int postId = Integer.parseInt(request.getParameter("postId"));
        int userId = Integer.parseInt(request.getParameter("userId"));

        PostDao dao = new PostDao();
        boolean b = dao.selectUserPostGood(postId,userId);
        out.print(b+"");

        out.flush();
        out.close();
    }
}
