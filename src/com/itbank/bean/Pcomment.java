package com.itbank.bean;

public class Pcomment {
  private int commentid;//
  private int postid;//文章id
  private int userid;//评论者的id
  private String commentpage;//评论内容
  private String commenttime;//评论时间

  public int getCommentid() {
    return commentid;
  }

  public void setCommentid(int commentid) {
    this.commentid = commentid;
  }

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
