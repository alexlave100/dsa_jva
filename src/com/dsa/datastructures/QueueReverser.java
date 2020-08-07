package com.dsa.datastructures;

import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class QueueReverser {

  private Stack<Integer> stack = new Stack<>();

  public QueueReverser() {}

  public void reverseFirstKElements(Queue<Integer> inputQueue, int k) {
    int size = inputQueue.size();

    if(k < 0 || k > size)
      throw new IllegalArgumentException();
    
    for(int i = 0; i < k; i++)
      stack.push(inputQueue.remove());
    while(!stack.empty())
      inputQueue.add(stack.pop());
    for(int i = 0; i < size - k; i++)
      inputQueue.add(inputQueue.remove());

    System.out.println(Arrays.asList(inputQueue));
  }
  
}