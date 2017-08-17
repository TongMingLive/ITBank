package com.itbank.bean;

public class Book {
  private int bookid;//题目id用于和评论进行关联
  private int booksid;//该题目所属的题库
  private int classid;//该题目所属的章节
  private int booktype;//题型 0:选择题 1:判断题 2:填空题
  private String booktitle;//题目标题
  private String answera;//选项A
  private String answerb;//选项B
  private String answerc;//选项C
  private String answerd;//选项D
  private String trueanswer;//正确答案
  private int booktrue;//该题做对次数
  private int bookfalse;//该题做错次数

  public int getBookid() {
    return bookid;
  }

  public void setBookid(int bookid) {
    this.bookid = bookid;
  }

  public int getBooksid() {
    return booksid;
  }

  public void setBooksid(int booksid) {
    this.booksid = booksid;
  }

  public int getClassid() {
    return classid;
  }

  public void setClassid(int classid) {
    this.classid = classid;
  }

  public int getBooktype() {
    return booktype;
  }

  public void setBooktype(int booktype) {
    this.booktype = booktype;
  }

  public String getBooktitle() {
    return booktitle;
  }

  public void setBooktitle(String booktitle) {
    this.booktitle = booktitle;
  }

  public String getAnswera() {
    return answera;
  }

  public void setAnswera(String answera) {
    this.answera = answera;
  }

  public String getAnswerb() {
    return answerb;
  }

  public void setAnswerb(String answerb) {
    this.answerb = answerb;
  }

  public String getAnswerc() {
    return answerc;
  }

  public void setAnswerc(String answerc) {
    this.answerc = answerc;
  }

  public String getAnswerd() {
    return answerd;
  }

  public void setAnswerd(String answerd) {
    this.answerd = answerd;
  }

  public String getTrueanswer() {
    return trueanswer;
  }

  public void setTrueanswer(String trueanswer) {
    this.trueanswer = trueanswer;
  }

  public int getBooktrue() {
    return booktrue;
  }

  public void setBooktrue(int booktrue) {
    this.booktrue = booktrue;
  }

  public int getBookfalse() {
    return bookfalse;
  }

  public void setBookfalse(int bookfalse) {
    this.bookfalse = bookfalse;
  }
}
