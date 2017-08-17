package com.itbank.bean;

public class Posttype {
  private int pcid;//主键
  private String postid;//文章id
  private int userid;//操作人的id
  private int pctype;//顶或踩 0:踩 1:顶

  public int getPcid() {
    return pcid;
  }

  public void setPcid(int pcid) {
    this.pcid = pcid;
  }

  public String getPostid() {
    return postid;
  }

  public void setPostid(String postid) {
    this.postid = postid;
  }

  public int getUserid() {
    return userid;
  }

  public void setUserid(int userid) {
    this.userid = userid;
  }

  public int getPctype() {
    return pctype;
  }

  public void setPctype(int pctype) {
    this.pctype = pctype;
  }
}
