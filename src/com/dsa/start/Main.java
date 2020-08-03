package com.dsa.start;

import com.dsa.aux.QueueOps;
import com.dsa.datastructures.ArrayQueue;
import com.dsa.datastructures.CustomStack;
import com.dsa.datastructures.LinkedList;
import com.dsa.datastructures.MinStack;
import com.dsa.datastructures.StackFromArray;
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

      arrQ.enqueue(10);
      arrQ.enqueue(20);
      arrQ.enqueue(30);
      var deq1 = arrQ.dequeue();
      var deq2 = arrQ.dequeue();
      arrQ.enqueue(33);
      arrQ.enqueue(35);
      arrQ.enqueue(40);
      arrQ.enqueue(40);
      arrQ.enqueue(50);
      arrQ.enqueue(60);
      arrQ.enqueue(70);
      arrQ.enqueue(80);
      arrQ.enqueue(90);
      arrQ.dequeue();
      arrQ.enqueue(100);
      arrQ.dequeue();
      arrQ.dequeue();
      arrQ.enqueue(110);
      arrQ.enqueue(120);
      arrQ.enqueue(134);
      System.out.print("Dequed = " + deq1 + " " + deq2 + " " + arrQ.printQueue() + "\n");

    }
}