package com.dsa.start;

import com.dsa.datastructures.CustomStack;
import com.dsa.datastructures.LinkedList;
import com.dsa.datastructures.StackFromArray;
import com.dsa.datastructures.TwoStacks;

import java.util.Arrays;

//import java.util.LinkedList;


public class Main {
    public static void main(String[] args) throws Exception {
      CustomStack cs = new CustomStack();
      StackFromArray sfa = new StackFromArray();
      TwoStacks ts = new TwoStacks(8);

      ts.push1(1);
      ts.push2(11);
      ts.push1(2);
      ts.push2(22);
      ts.push1(3);
      ts.push2(33);
      ts.push1(4);
      ts.push2(44);

      var one1 = ts.pop1();
      var two2 = ts.pop2();
      System.out.println(one1 + " " + two2);
      ts.printIt();


    }
}