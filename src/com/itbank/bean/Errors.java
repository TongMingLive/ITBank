package com.itbank.bean;

public class Errors {
  private int errorid;//
  private int userid;//做错该题的用户id
  private int bookid;//做错的题目的id

  public int getErrorid() {
    return errorid;
  }

  public void setErrorid(int errorid) {
    this.errorid = errorid;
  }

  public int getUserid() {
    return userid;
  }

  public void setUserid(int userid) {
    this.userid = userid;
  }

  public int getBookid() {
    return bookid;
  }

  public void setBookid(int bookid) {
    this.bookid = bookid;
  }
}
