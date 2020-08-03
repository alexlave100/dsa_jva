package com.dsa.aux;

public class Pair {
  private Object p1;
  private Object p2;
  private Object[] o = new Object[2];
  
  public Pair(){}

  public Pair(Object p1, Object p2) {
    this.p1 = p1;
    this.p2 = p2;
    this.o[0] = this.p1;
    this.o[1] = this.p2;
  }

  public void setPair(Object p1, Object p2) {
    o[0] = p1;
    o[1] = p2;
  }

  public Object[] getPair() {
    return o;
  }
}