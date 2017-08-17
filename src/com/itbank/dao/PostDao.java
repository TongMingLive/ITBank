package com.itbank.dao;

import com.itbank.bean.Pcomment;
import com.itbank.bean.Post;
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
 * Created by tong- on 2017/5/26.
 */
public class PostDao {
    //发表文章
    public int insertPost(int userId,String postTitle,String postPage){
        String sql = "insert into posttable(userId,postTitle,postPage) values("+userId+",'"+postTitle+"','"+postPage+"')";
        System.out.println(sql);
        return DbHelper.executeSql(sql);
    }

    //查询用户是否顶过该篇文章
    public boolean selectUserPostGood(int postId,int userId){
        String sql = "select * from posttypetable where postId = "+postId+" and userId = "+userId+" and pcType = 1";
        System.out.println(sql);
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
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

    //查询用户是否踩过该篇文章
    public boolean selectUserPostBad(int postId,int userId){
        String sql = "select * from posttypetable where postId = "+postId+" and userId = "+userId+" and pcType = 0";
        System.out.println(sql);
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
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

    //查询用户对该篇文章的顶踩状态(-1踩,0无操作,1顶)
    public int selectUserPostGoodOrBad(int postId,int userId){
        boolean good = selectUserPostGood(postId,userId);
        boolean bad = selectUserPostBad(postId,userId);
        if (!good && !bad){
            return 0;
        }else if (good){
            return 1;
        }else {
            return -1;
        }
    }

    //用户点击顶文章按钮（会自动取消踩文章状态）
    public boolean updatePostGood(int postId,int userId){
        String post;
        String posttype;
        String delete = "delete from posttypetable where postId = "+postId+" and userId = "+userId+" and pcType = 0";
        boolean type = selectUserPostGood(postId,userId);
        if (type){
            post = "update posttable set postGood = postGood-1 where postId = "+postId;
            posttype = "delete from posttypetable where postId = "+postId+" and userId = "+userId+" and pcType = 1";
        }else{
            post = "update posttable set postGood = postGood+1 where postId = "+postId;
            posttype = "insert into posttypetable(postId,userId,pcType) values("+postId+","+userId+",1)";
        }
        System.out.println(post);
        System.out.println(posttype);
        System.out.println(delete);
        if (DbHelper.executeSql(post) > 0 && DbHelper.executeSql(posttype) >= 0 && DbHelper.executeSql(delete) >= 0){
            return true;
        }else {
            return false;
        }
    }

    //用户点击踩文章按钮（会自动取消顶文章状态）
    public boolean updatePostBad(int postId,int userId){
        String post;
        String posttype;
        String delete = "delete from posttypetable where postId = "+postId+" and userId = "+userId+" and pcType = 1";
        boolean type = selectUserPostBad(postId,userId);
        if (type){
            post = "update posttable set postGood = postBad-1 where postId = "+postId;
            posttype = "delete from posttypetable where postId = "+postId+" and userId = "+userId+" and pcType = 0";
        }else{
            post = "update posttable set postGood = postBad+1 where postId = "+postId;
            posttype = "insert into posttypetable(postId,userId,pcType) values("+postId+","+userId+",0)";
        }
        System.out.println(post);
        System.out.println(posttype);
        System.out.println(delete);
        if (DbHelper.executeSql(post) > 0 && DbHelper.executeSql(posttype) >= 0 && DbHelper.executeSql(delete) >= 0){
            return true;
        }else {
            return false;
        }
    }

    //分页查看文章
    public Map<String,Object> selectPostByLimit(int start,int end){
        String sql = "select * from posttable p,usertable u where p.userId = u.userId ORDER BY postTime DESC limit "+start+","+end;
        System.out.println(sql);
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        Map<String,Object> map = new HashMap<>();
        List<Post> postList = new ArrayList<>();
        List<Users> usersList = new ArrayList<>();
        try {
            con = DbHelper.getconnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    Post post = new Post();
                    post.setPostid(rs.getInt("postId"));
                    post.setUserid(rs.getInt("p.userId"));
                    post.setPostTitle(rs.getString("postTitle"));
                    post.setPostpage(rs.getString("postPage"));
                    post.setPosttime(rs.getString("postTime"));
                    post.setPostgood(rs.getInt("postGood"));
                    post.setPostbad(rs.getInt("postBad"));
                    postList.add(post);
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
        map.put("post",postList);
        map.put("users",usersList);
        return map;
    }

    //分页查看文章下的评论
    public Map<String,Object> selectPcommentByLimit(int postId,int start,int end){
        String sql = "select * from pcommenttable p,usertable u where p.userid = u.userid and p.postId = "+postId+" ORDER BY commentTime DESC limit "+start+","+end;
        System.out.println(sql);
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        Map<String,Object> map = new HashMap<>();
        List<Pcomment> pcommentList = new ArrayList<>();
        List<Users> usersList = new ArrayList<>();
        try {
            con = DbHelper.getconnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    Pcomment pcomment = new Pcomment();
                    pcomment.setCommentid(rs.getInt("commentId"));
                    pcomment.setPostid(rs.getInt("postId"));
                    pcomment.setUserid(rs.getInt("p.userid"));
                    pcomment.setCommentpage(rs.getString("commentPage"));
                    pcomment.setCommenttime(rs.getString("commentTime"));
                    pcommentList.add(pcomment);
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
        map.put("pcomment",pcommentList);
        map.put("users",usersList);
        return map;
    }

    //分页搜索文章
    public Map<String,Object> selectPostByKeyLimit(int start,int end,String key){
        String sql = "select * from posttable p,usertable u where p.userId = u.userId and (postTitle like '%"+key+"%' or postPage like '%"+key+"%') ORDER BY postTime DESC limit "+start+","+end;
        System.out.println(sql);
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        Map<String,Object> map = new HashMap<>();
        List<Post> postList = new ArrayList<>();
        List<Users> usersList = new ArrayList<>();
        try {
            con = DbHelper.getconnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    Post post = new Post();
                    post.setPostid(rs.getInt("postId"));
                    post.setUserid(rs.getInt("p.userId"));
                    post.setPostTitle(rs.getString("postTitle"));
                    post.setPostpage(rs.getString("postPage"));
                    post.setPosttime(rs.getString("postTime"));
                    post.setPostgood(rs.getInt("postGood"));
                    post.setPostbad(rs.getInt("postBad"));
                    postList.add(post);
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
        map.put("post",postList);
        map.put("users",usersList);
        return map;
    }

    //添加文章下评论
    public int insertPcomment(int postId,int userId,String commentPage){
        String sql = "insert into pcommenttable(postId,userId,commentPage) values("+postId+","+userId+",'"+commentPage+"')";
        System.out.println(sql);
        return DbHelper.executeSql(sql);
    }

    //分页查询个人所有评论
    public Map<String,Object> selectUserPcomment(int start,int end,int userId){
        String sql = "select * from pcommenttable c,posttable p where c.userId = "+userId+" and c.postId = p.postId ORDER BY commentTime DESC limit "+start+","+end;
        System.out.println(sql);
        System.out.println(sql);
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        Map<String,Object> map = new HashMap<>();
        List<Pcomment> pcommentList = new ArrayList<>();
        List<Post> postList = new ArrayList<>();
        try {
            con = DbHelper.getconnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    Pcomment pcomment = new Pcomment();
                    pcomment.setCommentid(rs.getInt("commentId"));
                    pcomment.setPostid(rs.getInt("postId"));
                    pcomment.setUserid(rs.getInt("p.userid"));
                    pcomment.setCommentpage(rs.getString("commentPage"));
                    pcomment.setCommenttime(rs.getString("commentTime"));
                    pcommentList.add(pcomment);
                    Post post = new Post();
                    post.setPostid(rs.getInt("postId"));
                    post.setUserid(rs.getInt("p.userId"));
                    post.setPostTitle(rs.getString("postTitle"));
                    post.setPostpage(rs.getString("postPage"));
                    post.setPosttime(rs.getString("postTime"));
                    post.setPostgood(rs.getInt("postGood"));
                    post.setPostbad(rs.getInt("postBad"));
                    postList.add(post);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbHelper.closeConnectionAndStatement(rs,con,st);
        }
        map.put("pcomment",pcommentList);
        map.put("post",postList);
        return map;
    }

    //删除某条评论
    public int deletePcomment(int commentId){
        String sql = "delete from pcommenttable where commentId = "+commentId;
        System.out.println(sql);
        return DbHelper.executeSql(sql);
    }

    //删除文章下的所有评论
    public int deletePcommentByPost(int postId){
        String sql = "delete from pcommenttable where postId = "+postId;
        System.out.println(sql);
        return DbHelper.executeSql(sql);
    }

    //删除文章(返回值-2删除评论错误,-1文章删除错误,0文章未找到,>0文章删除成功)
    public int deletePost(int postId){
        int dc = deletePcommentByPost(postId);
        if (dc>=0){
            String sql = "delete from posttable where postId = "+postId;
            System.out.println(sql);
            return DbHelper.executeSql(sql);
        }else {
            return -2;
        }
    }

}