package com.itbank.dao;

import com.itbank.bean.Users;
import com.itbank.db.DbHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by tong- on 2017/5/1.
 */
public class UsersDao {
    //查询用户名重复
    public boolean selectUserName(String userName){
        String sql = "select * from usertable where userName = '"+userName+"'";
        System.out.println(sql);
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        boolean b = false;
        try {
            con = DbHelper.getconnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs != null) {
                if (rs.next()) {
                    b = true;
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbHelper.closeConnectionAndStatement(rs,con,st);
        }
        return b;
    }

    //用户登录
    public Users loginUser(String userName, String userPassword){
        String sql = "select * from usertable where userName = '"+userName+"' and userPassword = '"+userPassword+"'";
        System.out.println(sql);
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        Users user =new Users();
        try {
            con = DbHelper.getconnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs != null) {
                if (rs.next()) {
                    user.setUserid(rs.getInt("userId"));
                    user.setUsername(rs.getString("userName"));
                    user.setUserpassword(rs.getString("userPassword"));
                    user.setUsertype(rs.getInt("userType"));
                    user.setUserexperience(rs.getInt("userExperience"));
                    user.setUsersex(rs.getInt("userSex"));
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbHelper.closeConnectionAndStatement(rs,con,st);
        }
        return user;
    }

    //用户注册
    public int registUser(String userName, String userPassword,int userSex){
        String sql = "insert into usertable(userName,userPassword,userSex) values('"+userName+"','"+userPassword+"',"+userSex+")";
        System.out.println(sql);
        return DbHelper.executeSql(sql);
    }

    //修改密码
    public int updateUserPassword(int userId,String userPassword){
        String sql = "update usertable set userPassword = '"+userPassword+"' where userId = "+userId;
        System.out.println(sql);
        return DbHelper.executeSql(sql);
    }

    //用户经验修改
    public int updateUserExperience(int userId,int experience){
        String sql = "update usertable set userExperience = userExperience+"+experience+" where userId = "+userId;
        System.out.println(sql);
        return DbHelper.executeSql(sql);
    }
}
