package com.itbank.servlet;
import com.itbank.bean.Users;
import com.itbank.dao.UsersDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by tong on 17-3-24.
 */
@WebServlet(name = "JspLoginServlet",urlPatterns = "/JspLoginServlet")
public class JspLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");

        String userName=request.getParameter("userName");
        String userPassword=request.getParameter("userPassword");

        UsersDao dao = new UsersDao();
        Users user = dao.loginUser(userName,userPassword);

        HttpSession session =request.getSession();
        session.setAttribute("userMessger", user);

        if (user.getUserid()>0){
            if (user.getUsertype() == 0){
                out.print("<script>alert('用户不是管理员');location.href='admin_login.jsp';</script>");
            }else {
                response.sendRedirect("admin.jsp");
            }
        }else {
            out.print("<script>alert('用户名或密码错误');location.href='admin_login.jsp';</script>");
        }
    }
}
