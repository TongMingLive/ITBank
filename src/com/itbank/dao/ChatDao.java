package com.itbank.dao;

import com.itbank.bean.Chat;
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
public class ChatDao {
    //查看用户的所有私聊信息
    public Map<String,Object> selectChatByUser(int userId){
        String sql = "SELECT * FROM chattable c,usertable u WHERE c.cuserId = u.userId AND c.userId = "+userId;
        System.out.println(sql);
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        Map<String,Object> map = new HashMap<>();
        List<Chat> chatList = new ArrayList<>();
        List<Users> usersList = new ArrayList<>();
        try {
            con = DbHelper.getconnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    Chat chat = new Chat();
                    chat.setChatid(rs.getInt("chatId"));
                    chat.setUserid(rs.getInt("c.userId"));
                    chat.setCuserid(rs.getInt("cuserId"));
                    chat.setChatpage(rs.getString("chatPage"));
                    chat.setChattime(rs.getString("chatTime"));
                    chat.setChattype(rs.getInt("chatType"));
                    chatList.add(chat);
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
        map.put("chattable",chatList);
        map.put("usertable",usersList);
        return map;
    }

    //用户向对象发出一条私聊
    public int insertChat(int userId,int cuserId,String chatPage){
        String sql = "insert into chattable(userId,cuserId,chatPage) values("+userId+","+cuserId+",'"+chatPage+"')";
        System.out.println(sql);
        return DbHelper.executeSql(sql);
    }

    //将被私聊对象的所有私聊读取状态标为已读
    public int updateChatType(int userId,int cuserId){
        String sql = "update chattable set chatType = 1 where userId = "+userId+" and cuserId = "+cuserId;
        System.out.println(sql);
        return DbHelper.executeSql(sql);
    }

    //删除与私聊对象的所有私聊信息
    public int deleteChat(int userId,int cuserId){
        String sql = "delete from chattable where cuserId = "+cuserId+" and userId = "+userId;
        System.out.println(sql);
        return DbHelper.executeSql(sql);
    }

}
