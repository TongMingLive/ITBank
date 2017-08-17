package com.itbank.dao;

import com.itbank.bean.Fans;
import com.itbank.bean.Users;
import com.itbank.db.DbHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tong- on 2017/5/25.
 */
public class FansDao {
    //查询谁关注了我
    public Map<String,Object> selectUserByFans(int userId){
        String sql = "SELECT * FROM fanstable f,usertable u WHERE f.userId = u.userId AND f.fuserId = "+userId;
        System.out.println(sql);
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        Map<String,Object> map = new HashMap<>();
        List<Fans> fansList = new ArrayList<>();
        List<Users> usersList = new ArrayList<>();
        try {
            con = DbHelper.getconnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    Fans fans = new Fans();
                    fans.setFansid(rs.getInt("fansId"));
                    fans.setUserid(rs.getInt("f.userId"));
                    fans.setFuserid(rs.getInt("fuserId"));
                    fansList.add(fans);
                    Users users = new Users();
                    users.setUserid(rs.getInt("u.userId"));
                    users.setUsername(rs.getString("userName"));
                    users.setUsersex(rs.getInt("userSex"));
                    users.setUserexperience(rs.getInt("userExperience"));
                    users.setUsertype(rs.getInt("userType"));
                    usersList.add(users);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbHelper.closeConnectionAndStatement(rs,con,st);
        }
        map.put("fanstable",fansList);
        map.put("usertable",usersList);
        return map;
    }

    //查询用户关注的人
    public Map<String,Object> selectFansByUser(int userId){
        String sql = "SELECT * FROM fanstable f,usertable u WHERE f.fuserId = u.userId AND f.userId = "+userId;
        System.out.println(sql);
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        Map<String,Object> map = new HashMap<>();
        List<Fans> fansList = new ArrayList<>();
        List<Users> usersList = new ArrayList<>();
        try {
            con = DbHelper.getconnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    Fans fans = new Fans();
                    fans.setFansid(rs.getInt("fansId"));
                    fans.setUserid(rs.getInt("f.userId"));
                    fans.setFuserid(rs.getInt("fuserId"));
                    fansList.add(fans);
                    Users users = new Users();
                    users.setUserid(rs.getInt("u.userId"));
                    users.setUsername(rs.getString("userName"));
                    users.setUsersex(rs.getInt("userSex"));
                    users.setUserexperience(rs.getInt("userExperience"));
                    users.setUsertype(rs.getInt("userType"));
                    usersList.add(users);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbHelper.closeConnectionAndStatement(rs,con,st);
        }
        map.put("fanstable",fansList);
        map.put("usertable",usersList);
        return map;
    }

    //关注其他用户
    public int addFans(int userId,int fuserId){
        String sql = "insert into fanstable(userId,fuserId) values("+userId+","+fuserId+")";
        System.out.println(sql);
        return DbHelper.executeSql(sql);
    }

    //取消关注
    public int deleteFuser(int userId,int fuserId){
        String sql = "delete from fanstable where userId = "+userId+" and fuserId = "+fuserId;
        System.out.println(sql);
        return DbHelper.executeSql(sql);
    }

}
