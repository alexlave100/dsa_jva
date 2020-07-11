package com.dsa.datastructures;

public class StackFromArray {
  //push
  //pop
  //peek
  //isEmpty

  //int[]
  private int[] stack;
  private int currentStackSize;

  public StackFromArray() {
    this.currentStackSize = 0;
    this.stack = new int[10];
  }
  public StackFromArray(int size) {
    this.currentStackSize = 0;
    this.stack = new int[size];
  }

  public void push(int item) {
    //Create a new Stack with 2X the size if current Stack is full
    isStackFull(); 
    stack[currentStackSize++] = item;
  }

  public int pop() {
    if (isEmpty())
      throw new IllegalStateException("Empty stack");
    return stack[--currentStackSize];
  }

  public int peek() {
    if (isEmpty()) 
      throw new IllegalStateException("Empty stack");
    return stack[currentStackSize-1];
  }

  public int forward() {
    if (stack.length > currentStackSize)
      return stack[currentStackSize];
    else return -1;
  }
  public boolean isEmpty() {
    return currentStackSize == 0;
  }

  private void isStackFull() {
    if (this.stack.length == currentStackSize){
      int[] newStack = new int[stack.length*2];
      for (int i = 0; i < this.stack.length; i++)
        newStack[i] = stack[i];
      stack = newStack;
    }
  }

  public void printOutStack() {
    for (int i  = 0; i < currentStackSize; i++)
      System.out.println(stack[i]);
  }
}