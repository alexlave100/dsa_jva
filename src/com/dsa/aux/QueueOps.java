package com.dsa.aux;

import java.util.Queue;
import java.util.Stack;

public class QueueOps {

  //reversing an array
  public void reverse(Queue<Integer> q) {
    Stack<Integer> stack = new Stack<Integer>();
    while(!q.isEmpty())
      stack.push(q.poll());
    while(!stack.empty())
      q.add(stack.pop());
  }
}