package com.dsa.datastructures;

public class Array {

  private int arraySize;
  private int size;
  private int[] array;

  public Array(int arraySize) {
    this.arraySize = arraySize;
    this.array = new int[this.arraySize];
    this.size = 0;
  }

  public void insert(int num) {
    if (size == this.array.length) {
      int[] newArray = new int[size * 2];
      for (int i = 0; i < size; i++)
        newArray[i] = array[i];
      array = newArray;
    }
    array[size++] = num;
  }

  public void removeAt(int index) {
    if (index >= size || index < 0)
      throw new IllegalArgumentException();
    for (int i = index; i < size; i++)
      array[i] = array[i + 1];
    size--;
  }

  public int indexOf(int item){
    for (int i = 0; i < size; i++)
      if (array[i] == item) return i;
    return -1;    
  }

  public void print() {
    for (int i = 0; i < size; i++)
      System.out.println(array[i]);
  }
}