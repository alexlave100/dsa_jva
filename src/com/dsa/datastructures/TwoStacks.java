package com.dsa.datastructures;

public class TwoStacks {
  private int[] twoStack;
  int size;
  int currentStack1_Size;
  int currentStack2_Size; 
  
  public TwoStacks() {
    this.twoStack = new int[10];
    currentStack1_Size = 0;
    currentStack2_Size = 10/2;
  }
  public TwoStacks (int size) {
    if(size%2 != 0) 
      size++;
    this.size = size;
    this.twoStack = new int[this.size];
    currentStack1_Size = 0;
    currentStack2_Size = this.size/2;
  }

  public void push1(int item) {
    if (currentStack1_Size == size/2)
      throw new StackOverflowError("STACKOVERFLOW1");
    twoStack[currentStack1_Size++] = item;
  }

  public void push2(int item) {
    if (currentStack2_Size == size)
      throw new StackOverflowError("STACKOVERFLOW2");
    twoStack[currentStack2_Size++] = item;
  }

  public int pop1() {
    if (isEmpty1())
      throw new IllegalStateException("EMPTY1");
    return twoStack[--currentStack1_Size];
  }

  public int pop2() {
    if (isEmpty2())
      throw new IllegalStateException("EMPTY2");
    return twoStack[--currentStack2_Size];
  }

  public boolean isFull1() {
    return currentStack1_Size == size/2;
  }

  public boolean isFull2() {
    return currentStack2_Size == size;
  }

  public void printIt() {
    for (int i = 0; i < currentStack1_Size; i++)
      System.out.println(twoStack[i]);
    for (int i = size/2; i < currentStack2_Size; i++)
      System.out.println(twoStack[i]);
  }

  public boolean isEmpty1() {
    return currentStack1_Size == 0;
  }

  public boolean isEmpty2() {
    return currentStack2_Size == this.size/2;
  }
}