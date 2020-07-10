package com.dsa.datastructures;

import java.util.HashMap;
import java.util.Stack;

public class CustomStack {
  
  Stack<Character>stack = new Stack<>();

  public CustomStack(){}

  public String reverseString(String s){
    if (s == null)
      throw new IllegalArgumentException("Argument is NULL");

    for (Character character : s.toCharArray())
      stack.push(character);

    StringBuffer reveStringBuffer = new StringBuffer();
    while (!stack.empty()) {
      reveStringBuffer.append(stack.pop());
    }

    return reveStringBuffer.toString();
  }
  
  public Boolean isBalanced(String s) {
    for (Character c : s.toCharArray()) {

    }
    return false;
  }
}