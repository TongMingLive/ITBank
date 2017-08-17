package com.itbank.servlet;

import com.itbank.bean.Registert;
import com.itbank.dao.RegistertDao;
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
@WebServlet(name = "SelectUserRegistertServlet",urlPatterns = "/SelectUserRegistertServlet")
public class SelectUserRegistertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");

        int userId = Integer.parseInt(request.getParameter("userId"));
        String time = request.getParameter("time");

        RegistertDao dao = new RegistertDao();
        List<Registert> list = dao.selectUserRegistert(time,userId);

        JSONArray jsonArray = JSONArray.fromObject(list);
        out.print(jsonArray.toString());

        out.flush();
        out.close();
    }
}
