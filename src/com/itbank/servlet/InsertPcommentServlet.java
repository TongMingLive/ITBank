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
@WebServlet(name = "InsertPcommentServlet",urlPatterns = "/InsertPcommentServlet")
public class InsertPcommentServlet extends HttpServlet {
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
        String commentPage = request.getParameter("commentPage");

        PostDao dao = new PostDao();
        int r = dao.insertPcomment(postId,userId,commentPage);
        if (r>0){
            out.print("true");
        }else {
            out.print("false");
        }
        out.flush();
        out.close();
    }
}
