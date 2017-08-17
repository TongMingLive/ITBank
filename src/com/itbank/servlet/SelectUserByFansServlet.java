package com.itbank.servlet;

import com.itbank.dao.FansDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by tong- on 2017/5/25.
 */
@WebServlet(name = "SelectUserByFansServlet",urlPatterns = "/SelectUserByFansServlet")
public class SelectUserByFansServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");

        int userId = Integer.parseInt(request.getParameter("userId"));

        FansDao dao = new FansDao();
        Map<String,Object> map = dao.selectUserByFans(userId);
        JSONObject jsonObject = JSONObject.fromObject(map);
        out.print(jsonObject);

        out.flush();
        out.close();
    }
}
