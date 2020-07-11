package com.dsa.datastructures;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CustomStack {

  private final List<Character> left  = Arrays.asList('(', '{', '[', '<');
  private final List<Character> right = Arrays.asList(')', '}', ']', '>');

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
    if (s.isEmpty())
      throw new IllegalArgumentException("Empty string");

    for (Character c : s.toCharArray()) {
      if (left.contains(c))
        stack.push(c);
      if (right.contains(c)) {
        if (stack.empty() || right.indexOf(c) != left.indexOf(stack.pop()))
          return false;
      }
    }

    return stack.empty();
  }
  
}