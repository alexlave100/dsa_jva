package com.dsa.aux;

public class RunLengthEncoding {
  public String encode(String input) {
    if(input == null || input.length() == 0)
      throw new IllegalArgumentException();

    int counter = 0;
    char prevChar = 0;
    char[] charInput = input.toCharArray();
    StringBuilder sb = new StringBuilder();
    //         p1p2
    // a  a  a  a  a  a b  b  c
    for(char c : charInput) {
      if(c == prevChar) {
        counter++;
      }else if(prevChar != 0) {
        sb.append(counter).append(prevChar);
        counter = 1;
      }else counter = 1;
      prevChar = c; 
    }
    sb.append(counter).append(prevChar); //1c
    return sb.toString();
  }
}