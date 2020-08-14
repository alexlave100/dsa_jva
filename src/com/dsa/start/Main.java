package com.dsa.start;

import com.dsa.aux.QueueOps;
import com.dsa.aux.RecursiveStaircase;
import com.dsa.aux.RunLengthEncoding;
import com.dsa.datastructures.ArrayQueue;
import com.dsa.datastructures.BST;
import com.dsa.datastructures.CustomStack;
import com.dsa.datastructures.HashTable;
import com.dsa.datastructures.LinkedList;
import com.dsa.datastructures.MinStack;
import com.dsa.datastructures.PriorityQueue;
import com.dsa.datastructures.QueueReverser;
import com.dsa.datastructures.Solution;
import com.dsa.datastructures.StackFromArray;
import com.dsa.datastructures.StackQueue;
import com.dsa.datastructures.TwoStacks;

import jdk.javadoc.internal.doclets.formats.html.markup.Head;

import com.dsa.datastructures.ArrayQueue;
import com.dsa.datastructures.HashTable;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Queue;

//import java.util.LinkedList;


public class Main {
    public static void main(String[] args) throws Exception {
    //   CustomStack cs = new CustomStack();
    //   StackFromArray sfa = new StackFromArray();
    //   TwoStacks ts = new TwoStacks(8);
    //   MinStack ms = new MinStack();
    //   LinkedList ll = new LinkedList();
    //   QueueOps qops = new QueueOps();
    //   ArrayQueue arrQ = new ArrayQueue(10);
    //   StackQueue sq = new StackQueue();
    //   PriorityQueue pq = new PriorityQueue(12);
    //  Queue<Integer> q = new ArrayDeque<Integer>();
    //  QueueReverser qr = new QueueReverser();

    //  RunLengthEncoding rle = new RunLengthEncoding();

      // HashTable ht = new HashTable();
      // var v = ht.firstNonRepeatingChar("aa jj hhh hjrrejejejooj");
      // System.out.println(v);
//         7
//      4     9
//    1   6 8  10
      BST bst = new BST();
      // bst.insert(7);
      // bst.insert(4);
      // bst.insert(9);
      // bst.insert(1);
      // bst.insert(6);
      // bst.insert(8);
      // bst.insert(10);
      // bst.insert(12);
      BST bst2 = new BST();
      bst2.insert(7);
      bst2.insert(4);
      bst2.insert(8);
      bst2.insert(1);
      bst2.insert(6);
      bst2.insert(8);
      bst2.insert(10);
      //System.out.println(bst.find(5));
      //System.out.println(bst.minValue());
      //  var arrList = bst.nodesAtKDistance(3);
      //  System.out.println(arrList);
      var size = bst.size();
      System.out.println("Size = " + size);
      bst.preOrderTraversal();
      System.out.println();
      System.out.println(bst.contains(11));
      bst.remove(10);
      bst.preOrderTraversal();
      System.out.println();

    }
}