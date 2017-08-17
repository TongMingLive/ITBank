package com.itbank.dao;

import com.itbank.bean.Books;
import com.itbank.db.DbHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tong- on 2017/5/25.
 */
public class BooksDao {
    //查询所有题库
    public List<Books> selectBooks(){
        String sql = "select * from bookstable";
        System.out.println(sql);
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        List<Books> list = new ArrayList<>();
        try {
            con = DbHelper.getconnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    Books books = new Books();
                    books.setBooksid(rs.getInt("booksId"));
                    books.setBooksname(rs.getString("booksName"));
                    books.setImgsrc(rs.getString("imgSrc"));
                    books.setBackgroundColor(rs.getString("backgroundColor"));
                    list.add(books);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbHelper.closeConnectionAndStatement(rs,con,st);
        }
        return list;
    }

    //添加题库
    public int insertBooks(String booksName,String imgSrc,String backgroundColor){
        String sql = "insert into bookstable(booksName,imgSrc,backgroundColor) values('"+booksName+"','"+imgSrc+"','"+backgroundColor+"')";
        System.out.println(sql);
        return DbHelper.executeSql(sql);
    }

    //更新题库
    public int updateBooks(int booksId,String booksName,String imgSrc,String backgroundColor){
        String sql = "update bookstable set booksName = '"+booksName+"',imgSrc = '"+imgSrc+"',backgroundColor = '"+backgroundColor+"' where booksId = "+booksId;
        System.out.println(sql);
        return DbHelper.executeSql(sql);
    }

    //删除题库
    public int deleteBooks(int booksId){
        String sql = "delete from bookstable where booksId = "+booksId;
        System.out.println(sql);
        return DbHelper.executeSql(sql);
    }
}
