package com.itbank.bean;

public class Registert {
  private int id;//主键
  private int userid;//签到人id
  private String registertime;//签到时间

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getUserid() {
    return userid;
  }

  public void setUserid(int userid) {
    this.userid = userid;
  }

  public String getRegistertime() {
    return registertime;
  }

  public void setRegistertime(String registertime) {
    this.registertime = registertime;
  }
}
