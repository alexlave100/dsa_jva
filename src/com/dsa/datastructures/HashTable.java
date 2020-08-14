package com.dsa.datastructures;

import java.util.HashMap;
import java.util.Map;

public class HashTable {

  Map<Character, Integer> map = new HashMap<>();

  public char firstNonRepeatingChar(String input) {
    var chars = input.toCharArray();
    for(char c : chars) {
      var value = map.containsKey(c) ? map.get(c) : 0;
      map.put(c, value + 1);
    }
    for (char c : chars) {
      if(map.get(c) == 1)
        return c;
    }

    return Character.MIN_VALUE;
  }
}