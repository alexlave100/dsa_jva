package com.dsa.datastructures;

import java.util.Arrays;

public class ArrayQueue {
  private int[] arrayQ;
  private int first, last, counter, length;

  public ArrayQueue(int qSize) {
    this.arrayQ = new int[qSize];
    this.length = arrayQ.length;
  }

  public void enqueue(int value) {
    if(isFull())
      throw new IllegalStateException("Full ArrayQueue");

    arrayQ[last] = value;
    last = (last + 1) % length;
    counter++;  
  }

  public int dequeue() {
    if(isEmpty())
      throw new IllegalArgumentException("Empty ArrayQueue");
    
    arrayQ[first] = 0;  
    first = (first + 1) % length;
    counter--;
    return arrayQ[(first-1)%length];
  }

  // O(n/2)
  public void reverseFirstKElements(int k) {
    if(isEmpty() || k > counter || k < 0)
      throw new IllegalStateException();

    int placeHolder, j = 0;
    for(int i = k - 1; i >= j; i--) {
      placeHolder = arrayQ[j];
      arrayQ[j++] = arrayQ[i];
      arrayQ[i] = placeHolder;
    }
  }

  public int peek() {
    return arrayQ[first];
  }

  public boolean isEmpty() {
    return counter == 0;
  }

  public boolean isFull() {
    return counter == length;
  }

  public String printQueue() {
    return Arrays.toString(arrayQ);
  }
}