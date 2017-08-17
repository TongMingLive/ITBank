package com.itbank.dao;

import com.itbank.bean.Book;
import com.itbank.db.DbHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tong on 17-6-5.
 */
public class BookDao {

    //查询当前系列下题目的count
    public int selectBooksCount(int booksId){
        String sql = "select count(*) as c from booktable where booksId = "+booksId;
        System.out.println(sql);
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        int count = 0;
        try {
            con = DbHelper.getconnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs != null) {
                if (rs.next()) {
                    count = rs.getInt("c");
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbHelper.closeConnectionAndStatement(rs,con,st);
        }
        return count;
    }

    //添加题目
    public int insertBook(int booksId,int bookType,String bookTitle,String answerA,String answerB,String answerC,String answerD,String trueAnswer){
        String sql = "insert into booktable(booksId,bookType,bookTitle,answerA,answerB,answerC,answerD,trueAnswer) values("+booksId+","+bookType+",'"+bookTitle+"','"+answerA+"','"+answerB+"','"+answerC+"','"+answerD+"','"+trueAnswer+"')";
        System.out.println(sql);
        return DbHelper.executeSql(sql);
    }

    //查询某系列所有题目
    public List<Book> selectBookByBooksId(int booksId){
        String sql = "select * from booktable where booksId = "+booksId;
        System.out.println(sql);
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        List<Book> list = new ArrayList<>();
        try {
            con = DbHelper.getconnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    Book book = new Book();
                    book.setBookid(rs.getInt("bookId"));
                    book.setBooksid(rs.getInt("booksId"));
                    book.setBooktype(rs.getInt("bookType"));
                    book.setBooktitle(rs.getString("bookTitle"));
                    book.setAnswera(rs.getString("answerA"));
                    book.setAnswerb(rs.getString("answerB"));
                    book.setAnswerc(rs.getString("answerC"));
                    book.setAnswerd(rs.getString("answerD"));
                    book.setTrueanswer(rs.getString("trueAnswer"));
                    book.setBooktrue(rs.getInt("bookTrue"));
                    book.setBookfalse(rs.getInt("bookFalse"));
                    list.add(book);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbHelper.closeConnectionAndStatement(rs,con,st);
        }
        return list;
    }

    //查询某系列题目(与count结合根据下标查询)
    public List<Book> selectBookByBooksId(int booksId,int start,int end){
        String sql = "select * from booktable where booksId = "+booksId+" limit "+start+","+end;
        System.out.println(sql);
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        List<Book> list = new ArrayList<>();
        try {
            con = DbHelper.getconnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    Book book = new Book();
                    book.setBookid(rs.getInt("bookId"));
                    book.setBooksid(rs.getInt("booksId"));
                    book.setBooktype(rs.getInt("bookType"));
                    book.setBooktitle(rs.getString("bookTitle"));
                    book.setAnswera(rs.getString("answerA"));
                    book.setAnswerb(rs.getString("answerB"));
                    book.setAnswerc(rs.getString("answerC"));
                    book.setAnswerd(rs.getString("answerD"));
                    book.setTrueanswer(rs.getString("trueAnswer"));
                    book.setBooktrue(rs.getInt("bookTrue"));
                    book.setBookfalse(rs.getInt("bookFalse"));
                    list.add(book);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbHelper.closeConnectionAndStatement(rs,con,st);
        }
        return list;
    }

    //修改题目正确与错误的数量(check 0错误,1正确)
    public int updateBookCheck(int bookId,int check){
        String sql;
        if (check == 0){
            sql = "update booktable set bookFalse = bookFalse+1 where bookId = "+bookId;
            System.out.println(sql);
            return DbHelper.executeSql(sql);
        }else if (check == 1){
            sql = "update booktable set bookTrue = bookTrue+1 where bookId = "+bookId;
            System.out.println(sql);
            return DbHelper.executeSql(sql);
        }else {
            return -1;
        }
    }

    //添加错题
    public int insertBookError(int userId,int bookId){
        String sql = "insert into errortable(userId,bookId) values("+userId+","+bookId+")";
        System.out.println(sql);
        return DbHelper.executeSql(sql);
    }

    //查询个人错题(查询所有)
    public List<Book> selectErrors(int userId){
        String sql = "select * from errortable e,bookstable b where e.bookId = b.bookId and e.userId = "+userId;
        System.out.println(sql);
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        List<Book> list = new ArrayList<>();
        try {
            con = DbHelper.getconnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    Book book = new Book();
                    book.setBookid(rs.getInt("bookId"));
                    book.setBooksid(rs.getInt("booksId"));
                    book.setBooktype(rs.getInt("bookType"));
                    book.setBooktitle(rs.getString("bookTitle"));
                    book.setAnswera(rs.getString("answerA"));
                    book.setAnswerb(rs.getString("answerB"));
                    book.setAnswerc(rs.getString("answerC"));
                    book.setAnswerd(rs.getString("answerD"));
                    book.setTrueanswer(rs.getString("trueAnswer"));
                    book.setBooktrue(rs.getInt("bookTrue"));
                    book.setBookfalse(rs.getInt("bookFalse"));
                    list.add(book);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbHelper.closeConnectionAndStatement(rs,con,st);
        }
        return list;
    }

    //查询个人错题(根据题型)
    public List<Book> selectErrors(int userId,int booksId){
        String sql = "select * from errortable e,bookstable b where e.bookId = b.bookId and b.booksId = "+booksId+" and e.userId = "+userId;
        System.out.println(sql);
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        List<Book> list = new ArrayList<>();
        try {
            con = DbHelper.getconnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    Book book = new Book();
                    book.setBookid(rs.getInt("bookId"));
                    book.setBooksid(rs.getInt("booksId"));
                    book.setBooktype(rs.getInt("bookType"));
                    book.setBooktitle(rs.getString("bookTitle"));
                    book.setAnswera(rs.getString("answerA"));
                    book.setAnswerb(rs.getString("answerB"));
                    book.setAnswerc(rs.getString("answerC"));
                    book.setAnswerd(rs.getString("answerD"));
                    book.setTrueanswer(rs.getString("trueAnswer"));
                    book.setBooktrue(rs.getInt("bookTrue"));
                    book.setBookfalse(rs.getInt("bookFalse"));
                    list.add(book);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbHelper.closeConnectionAndStatement(rs,con,st);
        }
        return list;
    }

}
