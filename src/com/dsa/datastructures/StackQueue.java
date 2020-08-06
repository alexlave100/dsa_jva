package com.dsa.datastructures;

import java.util.Stack;

public class StackQueue {

  // enqueue
  // dequeue
  // isempty
  // peek

  private Stack<Integer> s1 = new Stack<Integer>();
  private Stack<Integer> s2 = new Stack<Integer>();

  public StackQueue() {}
  
  // O(1)
  public void enqueue(int value) {
    s1.push(value);
  }

  // O(n)
  public int dequeue() {
    if(isEmpty())
      throw new IllegalStateException();
    emptySecondStack();
    return s2.pop();
  }

  // O(n)
  public int peek() {
    emptySecondStack();
    return s2.peek();
  }


  private void moveBetweenStacks(Stack<Integer> source, Stack<Integer> destination) {
    while(!source.empty())
      destination.push(source.pop());    
  }

  private void emptySecondStack() {
    if(s2.empty()) 
      moveBetweenStacks(s1, s2);
  }

  public boolean isEmpty() {
    return s1.empty() && s2.empty();
  }
}