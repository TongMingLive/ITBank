package com.itbank.bean;

public class Post {
  private int postid;//
  private int userid;//发表者的id
  private String postTitle;//文章标题
  private String postpage;//文章内容
  private String posttime;//发表时间
  private int postgood;//文章被赞数量
  private int postbad;//文章被踩数

  public int getPostid() {
    return postid;
  }

  public void setPostid(int postid) {
    this.postid = postid;
  }

  public int getUserid() {
    return userid;
  }

  public void setUserid(int userid) {
    this.userid = userid;
  }

  public String getPostTitle() {
    return postTitle;
  }

  public void setPostTitle(String postTitle) {
    this.postTitle = postTitle;
  }

  public String getPostpage() {
    return postpage;
  }

  public void setPostpage(String postpage) {
    this.postpage = postpage;
  }

  public String getPosttime() {
    return posttime;
  }

  public void setPosttime(String posttime) {
    this.posttime = posttime;
  }

  public int getPostgood() {
    return postgood;
  }

  public void setPostgood(int postgood) {
    this.postgood = postgood;
  }

  public int getPostbad() {
    return postbad;
  }

  public void setPostbad(int postbad) {
    this.postbad = postbad;
  }
}
