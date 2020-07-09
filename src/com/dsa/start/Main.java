package com.dsa.start;

import com.dsa.datastructures.LinkedList;

import java.util.Arrays;

//import java.util.LinkedList;


public class Main {
    public static void main(String[] args) throws Exception {

      
      LinkedList list =  new LinkedList();
      list.addLast(1);
      list.addLast(2);
      list.addLast(3);
      list.addLast(4);
      list.addLast(5);
      list.addLast(6);
      list.addLast(7);
      list.addLast(8);
      var v = list.findMiddleNode();
     
      System.out.print("middle = ");
      for (int i = 0; i < v.length; i++)
        System.out.print(v[i] + " ");
      System.out.println();
      
     // System.out.println(list.size());
     // System.out.println(list.contains(6));

      list.reverse();
      //list.deleteAt(5);
      int[] arr = list.toArray();

      System.out.println(Arrays.toString(arr));
      list.deleteAt(4);
      int[] arr1 = list.toArray();
      System.out.println(Arrays.toString(arr1));

      System.out.println(list.findKthFromTheEnd(4));
      list.addLoop();
      System.out.println(list.hasLoop());
    }
}