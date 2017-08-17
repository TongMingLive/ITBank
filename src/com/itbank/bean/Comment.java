package com.itbank.bean;

public class Comment {
  private int commentid;//
  private int bookid;//题目的id
  private int userid;//评论者的userid
  private String commentpage;//评论内容
  private String commenttime;//评论时间

  public int getCommentid() {
    return commentid;
  }

  public void setCommentid(int commentid) {
    this.commentid = commentid;
  }

  public int getBookid() {
    return bookid;
  }

  public void setBookid(int bookid) {
    this.bookid = bookid;
  }

  public int getUserid() {
    return userid;
  }

  public void setUserid(int userid) {
    this.userid = userid;
  }

  public String getCommentpage() {
    return commentpage;
  }

  public void setCommentpage(String commentpage) {
    this.commentpage = commentpage;
  }

  public String getCommenttime() {
    return commenttime;
  }

  public void setCommenttime(String commenttime) {
    this.commenttime = commenttime;
  }
}
