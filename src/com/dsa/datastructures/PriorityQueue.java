package com.dsa.datastructures;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;

public class PriorityQueue {
  // Nested QueueObject class
  // private class QueueObject {
  //   int object;
  //   public QueueObject(int object) {
  //     this.object = object;
  //   }
  // }

  private int[] priorityQueue;
  private int queueSize, counter = 0;
  
  public PriorityQueue(int queueSize) {
    this.priorityQueue = new int[queueSize];
    this.queueSize = queueSize;
  }

  // 
  public void insert(int item) {
    if(isFull())
      throw new IllegalStateException();

    int i = shiftItemsRightInPQ(item);
    priorityQueue[i] = item;
    counter++;

    System.out.println(Arrays.toString(priorityQueue));
  }

  private int shiftItemsRightInPQ(int item) {
    int i;
    // O(n)
    for (i = counter - 1; i >= 0; i--) {
      if (item < priorityQueue[i])
        priorityQueue[i + 1] = priorityQueue[i];
      else break;
    }
    return i + 1;
  }

  // Remove least priority first
  public int remove() {
    return priorityQueue[--counter];
  }

  public boolean isEmpty() {
    return counter == 0;
  }

  public boolean isFull() {
    return counter == queueSize;
  }



  // public void encode() {
  //   String str = "aaabbc";
  //   char[] input = str.toCharArray();
  //   int length = str.length();
  //   char prev1Char = input[2], prev2Char = input[2];
  //   StringBuilder sb = new StringBuilder();

  //   // aaabbc
  //   for(int i = 2; i < length; i += 2) {
  //     if(input[i] == prev2Char) {
  //       if()
  //       prevChar = input[i + 1];
  //     }
  //   }

    
    // return priorityQueue.length == 0;
    // System.out.println(input[0]^0);
  // }
}