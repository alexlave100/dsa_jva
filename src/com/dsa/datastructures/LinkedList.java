package com.dsa.datastructures;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.Queue;

import com.dsa.aux.Pair;

public class LinkedList {

  //Nested Node class
  private class Node {   
    private final int value;
    private Node next;

    private Node(final int value){
      this.value = value;
    }
  }

  private Node first;
  private Node last;
  private int indexSize;
  Queue<Integer> q = new ArrayDeque<>();

  public LinkedList() {
    this.indexSize = 0;
  }

  //addFirst
  public void addFirst(final int value) {
    final Node n = new Node(value);
    if(isEmpty())
      first = last = n;
    else {
      n.next = first;
      first = n;
    }
    indexSize++;
  }

  //addLast
  public void addLast(final int value) {
    final Node n = new Node(value);
    if(isEmpty())
      first = last = n;
    else {
      last.next = n;
      last = n;
    }
    indexSize++;
  }

  public void addLoop() {
    last.next = first.next;
  }

  //deleteFirst
  public void deleteFirst() {
    if (isEmpty())
      throw new NoSuchElementException();
    else if (onlyOneNodeInList())
      first = last = null;
    else {
      final Node current = first.next;
      first.next = null;
      first = current;
    }
    indexSize--;
  }

  //deleteLast
  public void deleteLast() {
    if (isEmpty())
      throw new NoSuchElementException();
    if (onlyOneNodeInList())
      first = last = null;
    else {
      final Node current = getPrevious();
      last = current;
      last.next = null;
    }
    indexSize--;
  }

  public void deleteAt(final int index) {
    if (index < 0 || index > indexSize) 
      return;
    if (index == 0) {
      deleteFirst();
      return;
    }
    if (index == indexSize) {
      deleteLast();
      return;
    }
    deleteNodeAtIndex(index);
  }

  private Node getPrevious() {
    Node node = first;
    while (node.next != null) {
      if (node.next == last) return node;
      node = node.next;
    }
    return null;
  }

  public int size() {
    return indexSize;
  }
  
  public int[] toArray() {
    final int[] array = new int[indexSize];
    Node current = first;
    int index = 0;
    while (current != null) {
      array[index++] = current.value;
      current = current.next;
    }
    return array;
  }

  //contains
  public Boolean contains(final int value) {
    return indexOf(value) != -1;
  }

  public void deleteNodeAtIndex(final int index) { 
    Node previous = first,
         current = first.next;
   for (int i = 1; i < index; i++) {
      previous = current;
      current = current.next;
    }
    previous.next = current.next;
    current = null;
    indexSize--;
}

  //indexOf
  public int indexOf(final int value) {
    int index = 0;
    Node current = first;
    while (current != null) {
      if (current.value == value) return index;
      index++;
      current = current.next;
    }
    return -1;
  }

  private Boolean onlyOneNodeInList() {
    return first == last;
  }

  public void reverse(){
    if(isEmpty()) return;

    Node previous = null, current = first, next;

    while (current != null) {
      next = current.next;
      current.next = previous;
      previous = current;
      current = next;
    }
    last = first;
    first = previous;
  }

  public int findKthFromTheEnd(final int k) throws Exception {
    if (isEmpty()) throw new Exception("List is empty");
    //This is if we know the size of our linked list (k > indexSize)
    if (k < 0) 
     throw new IllegalStateException("K is less than zero");

    Node trail, lead = trail = first;
    
    for (int j = 0; j < k - 1; j++) {
      lead = lead.next;
      if(lead.next == null)
        throw new IllegalArgumentException("K out of range.");      
    }
    while (lead.next != null) {
      lead = lead.next;
      trail = trail.next;
    }
    return trail.value;
  }

  public int[] findMiddleNode() {
    final int[] a = new int[2];
    if (isEmpty()) return a;
        
    Node previous = first, current = first;
    
    while (current != last && current.next != last) {
      previous = previous.next;
      current = current.next.next;
    }
    if (current == last) {
      a[0] = previous.value;
    }
    else {
      a[0] = previous.value;
      a[1] = previous.next.value;
    }

    return a;
  }

  public Boolean hasLoop() {
    Node slow, fast = slow = first;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast)
        return true;
    }
    return false;
  }

  private Boolean isEmpty() {
    return first == null;
  }

  public void printLinkedList() {
    Node node = first;
    while (node.next != null) {
      System.out.print(node.value + "->");
      node = node.next;
    }
    System.out.println(node.value);
  }
}