package com.itbank.bean;

public class Fans {
  private int fansid;
  private int userid;//关注者的userid
  private int fuserid;//被关注者的userid

  public int getFansid() {
    return fansid;
  }

  public void setFansid(int fansid) {
    this.fansid = fansid;
  }

  public int getUserid() {
    return userid;
  }

  public void setUserid(int userid) {
    this.userid = userid;
  }

  public int getFuserid() {
    return fuserid;
  }

  public void setFuserid(int fuserid) {
    this.fuserid = fuserid;
  }
}
