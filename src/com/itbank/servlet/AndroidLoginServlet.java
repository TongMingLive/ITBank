package com.itbank.servlet;
import com.itbank.bean.Users;
import com.itbank.dao.UsersDao;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Created by tong on 17-3-24.
 */
@WebServlet(name = "AndroidLoginServlet",urlPatterns = "/AndroidLoginServlet")
public class AndroidLoginServlet extends HttpServlet {
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

        JSONObject jsonObject = JSONObject.fromObject(user);
        out.print(jsonObject.toString());

        out.flush();
        out.close();
    }
}
