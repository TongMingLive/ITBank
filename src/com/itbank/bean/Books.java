package com.itbank.bean;

public class Books {
  private int booksid;//题库id用于和题目关联
  private String booksname;//题库名称
  private String imgsrc;//课程图标地址
  private String backgroundColor;//图标背景颜色

  public int getBooksid() {
    return booksid;
  }

  public void setBooksid(int booksid) {
    this.booksid = booksid;
  }

  public String getBooksname() {
    return booksname;
  }

  public void setBooksname(String booksname) {
    this.booksname = booksname;
  }

  public String getImgsrc() {
    return imgsrc;
  }

  public void setImgsrc(String imgsrc) {
    this.imgsrc = imgsrc;
  }

  public String getBackgroundColor() {
    return backgroundColor;
  }

  public void setBackgroundColor(String backgroundColor) {
    this.backgroundColor = backgroundColor;
  }
}
