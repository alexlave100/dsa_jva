package com.dsa.datastructures;

import java.util.Arrays;
import java.util.Stack;

public class MinStack {
  private Stack<Integer> stack = new Stack<>();
  private Stack<Integer> minStack = new Stack<>();

  public MinStack () {}

  public void push (int item) {
    stack.push(item);
    
    if (minStack.isEmpty() || item <= minStack.peek())
      minStack.push(item);  
  }

  public int pop () {
    if (stack.isEmpty()) 
      throw new IllegalStateException();

    var r = stack.pop();
    return r == minStack.peek() ? minStack.pop() : r;
  }

  public int retrieveMinimum () {
    return minStack.peek();
  }

  public void printStack () {
    System.out.println(Arrays.asList(stack));
  }
}