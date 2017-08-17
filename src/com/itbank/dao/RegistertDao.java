package com.itbank.dao;

import com.itbank.bean.Registert;
import com.itbank.db.DbHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by tong- on 2017/5/25.
 */
public class RegistertDao {

    //查询个人签到时间，根据日期范围查询(2017-01)
    public List<Registert> selectUserRegistert(String time,int userId){
        String sql = "select * from registertable where registerTime like '"+time+"%' and userId = "+userId;
        System.out.println(sql);
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        List<Registert> list = new ArrayList<>();
        try {
            con = DbHelper.getconnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    Registert registert = new Registert();
                    registert.setId(rs.getInt("Id"));
                    registert.setUserid(rs.getInt("userId"));
                    registert.setRegistertime(rs.getString("registerTime"));
                    list.add(registert);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbHelper.closeConnectionAndStatement(rs,con,st);
        }
        return list;
    }

    //查询用户今天是否签到
    public boolean userRegistertByThisDay(int userId){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间
        String time = "SELECT * FROM registertable WHERE userId = "+userId+" AND registerTime LIKE '"+date.substring(0,10)+"%' ";
        System.out.println(time);
        boolean flag = false;
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            con = DbHelper.getconnection();
            st = con.createStatement();
            rs = st.executeQuery(time);
            if (rs != null) {
                if (rs.next()) {
                    flag = true;
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbHelper.closeConnectionAndStatement(rs,con,st);
        }
        return flag;
    }

    //用户签到
    public String userRegistert(int userId){
        String type;
        boolean flag = userRegistertByThisDay(userId);
        if (flag){
            type = "no";
        }else {
            String sql = "insert into registertable(userId) values("+userId+")";
            System.out.println(sql);
            int b = DbHelper.executeSql(sql);
            if (b>0){
                type = "true";
            }else {
                type = "false";
            }
        }
        return type;
    }
}