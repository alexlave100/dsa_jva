package com.dsa.start;

import com.dsa.aux.QueueOps;
import com.dsa.aux.RunLengthEncoding;
import com.dsa.datastructures.ArrayQueue;
import com.dsa.datastructures.CustomStack;
import com.dsa.datastructures.LinkedList;
import com.dsa.datastructures.MinStack;
import com.dsa.datastructures.PriorityQueue;
import com.dsa.datastructures.QueueReverser;
import com.dsa.datastructures.StackFromArray;
import com.dsa.datastructures.StackQueue;
import com.dsa.datastructures.TwoStacks;
import com.dsa.datastructures.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

//import java.util.LinkedList;


public class Main {
    public static void main(String[] args) throws Exception {
      CustomStack cs = new CustomStack();
      StackFromArray sfa = new StackFromArray();
      TwoStacks ts = new TwoStacks(8);
      MinStack ms = new MinStack();
      LinkedList ll = new LinkedList();
      QueueOps qops = new QueueOps();
      ArrayQueue arrQ = new ArrayQueue(10);
      StackQueue sq = new StackQueue();
      PriorityQueue pq = new PriorityQueue(12);

     Queue<Integer> q = new ArrayDeque<Integer>();
     QueueReverser qr = new QueueReverser();

     RunLengthEncoding rle = new RunLengthEncoding();

     System.out.println(rle.encode("abcnnnnnnnnnnbbbreee"));
     
    }
}