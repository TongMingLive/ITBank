package com.itbank.bean;

public class Chat {
  private int chatid;//
  private int userid;//私聊者userid
  private int cuserid;//被私聊对象的userid
  private String chatpage;//私聊内容
  private String chattime;//留言的时间
  private int chattype;//读取状态 0未读 1已读

  public int getChatid() {
    return chatid;
  }

  public void setChatid(int chatid) {
    this.chatid = chatid;
  }

  public int getUserid() {
    return userid;
  }

  public void setUserid(int userid) {
    this.userid = userid;
  }

  public int getCuserid() {
    return cuserid;
  }

  public void setCuserid(int cuserid) {
    this.cuserid = cuserid;
  }

  public String getChatpage() {
    return chatpage;
  }

  public void setChatpage(String chatpage) {
    this.chatpage = chatpage;
  }

  public String getChattime() {
    return chattime;
  }

  public void setChattime(String chattime) {
    this.chattime = chattime;
  }

  public int getChattype() {
    return chattype;
  }

  public void setChattype(int chattype) {
    this.chattype = chattype;
  }
}
