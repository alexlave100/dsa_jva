package com.dsa.datastructures;

import java.util.ArrayList;
import java.util.List;


public class BST {

  private class Node {
    Node leftChild, rightChild;
    int value;
    public Node(int value) {
      this.value = value;
    }
    @Override
    public String toString() {
      return "Node= " + value;
    }
  }

  private Node root;

  public BST() {
  }

  public void insert(int value) {
    Node newNode = new Node(value);
    if(isEmpty())
      root = newNode;
    else {
      Node node = root;   
      while(node != null) {
        if(value >= node.value) {
          if(node.rightChild != null)
            node = node.rightChild;
          else {
            node.rightChild = newNode;
            break;
          }
        } else if(node.leftChild != null) {
            node = node.leftChild;
          } else {
            node.leftChild = newNode;
            break;
          }
      }
    }
  }


  // Breadth First Traversal
  // Level Order Traversal (level by level in the tree)
  

  // Variations of Depth First Traversals
  // Pre Order Traversal(Root Left Right) - 20, 10, 6, 3, 8, 14, 30, 24, 26
  // In Order Traversal(Left Root Right) - 3, 6, 8, 10, 14, 20, 24, 26, 30
  // Post Order Traversal(Left Right Root) - 3, 8, 6, 14, 10, 26, 24, 30, 20

  public boolean isEqual(BST tree) {
    if(tree == null)
      return false;
    return isEqual(root, tree.root);
  }
  int i = 0;
  private boolean isEqual(Node first, Node second) {
    // Pre order Traversal
    if(first != null)
      System.out.println(first.value + "->" + i++);
    else System.out.println("Null->" + i++);
    
    // Base case - are both nodes null?
    if(first == null && second == null) {
      return true;
    }
    
    // Recursively go through both trees to check if they are equal
    if(first != null && second != null) {                        //      7            7
      return first.value == second.value                         //   4     9      4     8
              && isEqual(first.leftChild, second.leftChild)      // 1   6  8 10  1   6  8 10
              && isEqual(first.rightChild, second.rightChild);   
    }                                                            // 

    return false;
  }
  public List<Integer> nodesAtKDistance(int k) {
    List<Integer> nodesAtK = new ArrayList<Integer>();
    nodesAtKDistance(root, k, nodesAtK);
    return nodesAtK;
  }

  private void nodesAtKDistance(Node root, int distance, List<Integer> nodesAtK) {
    if(root == null)
      return;
    if(distance == 0) {
      nodesAtK.add(root.value);
      return;
    }
    nodesAtKDistance(root.leftChild, distance - 1, nodesAtK);
    nodesAtKDistance(root.rightChild, distance - 1, nodesAtK);
  }

  
  public boolean isBST() {
    return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE); // min = 6
  }

  private boolean isBST(Node current, int minValue, int maxValue) {
    // Is the current node null? Then we are done traversing the tree, return true
    if(current == null) {
      return true;
    }
    System.out.println(current.value + " " + minValue + " " + maxValue);
    // Is the current value in the right range? Otherwise return false
    if(current.value < minValue || current.value > maxValue)
      return false;
    
    // Recursively go down up the nodes of the tree and check that the range of their values are correct
    return isBST(current.leftChild, minValue, current.value - 1)
        && isBST(current.rightChild, current.value, maxValue);


        // return current == null ? true 
        //         : current.value < minValue || current.value > maxValue ? false
        //         : isBST(current.leftChild, minValue, current.value - 1) 
        //           && isBST(current.rightChild, current.value + 1, maxValue);
  }


  public int minValue() {
    if(root == null)
      throw new IllegalStateException("Tree is empty");
    return minValue(root);
  }

  private int minValue(Node root) {
    if(root.leftChild == null && root.rightChild == null)
      return root.value;
    return Math.min(Math.min(minValue(root.leftChild), minValue(root.rightChild)), root.value);
  }

  public int height() {
    return height(root);
  }

  private int height(Node node) {
    if(node == null) {
      return -1;
    } else if(node.leftChild == null && node.rightChild == null) {
      return 0;
    }else {
      return 1 + Math.max(height(node.leftChild), height(node.rightChild));
    }
  }

  public void preOrderTraversal() {
    Node n = root;
    preOrderTraversal(n);
  }

  private void preOrderTraversal(Node root) {
    if(root == null)
      return;
    System.out.print("-" + root.value);
    preOrderTraversal(root.leftChild);
    preOrderTraversal(root.rightChild);
  }

  public void postOrderTraversal() {
    postOrderTraversal(root);
  }

  private void postOrderTraversal(Node root) {
    if(root == null)
      return;
    postOrderTraversal(root.leftChild);
    postOrderTraversal(root.rightChild);
    System.out.println(root.value);
  }

  public void inOrderTraversal() {
    inOrderTraversal(root);
  }

  private void inOrderTraversal(Node root) {
    if(root == null) {
      return;
    }
    inOrderTraversal(root.leftChild);
    System.out.println(root.value);
    inOrderTraversal(root.rightChild); 
  }

  public void remove(int value) {
    if(isEmpty()) {
      throw new IllegalStateException("Empty tree");
    } else {
    Node curr = root;
    remove(value, null, curr);
    }
  }

  // Remove node from tree
  public void remove(int value, Node parent, Node current) {
    //Navigate to the node to be removed
    if(value < current.value && current.leftChild != null) { // If value is less than current node value, move left
      remove(value, current, current.leftChild); // Recursive call to move left in the BST
    } else if(value > current.value && current.rightChild != null) { // If value is larger than current node value, move right
      remove(value, current, current.rightChild); // Recursive call to move left in right in the BST
    } else {
      if(current.leftChild != null && current.rightChild != null) { // Edge case - has the node two child nodes?
        var minVal = getMinValue(current.rightChild); // Get leftmost value in the right subtree
        current.value = minVal; //Assign new value to node you want to remove
        remove(value, current, current.rightChild); //Recursive call to remove the leaf node you copied the value from, with current node as the parent
      } else if(parent == null) { // Edge case - remove root node with only one child 
        if(current.leftChild != null) { 
          current.value = current.leftChild.value;
          current.rightChild = current.leftChild.rightChild;
          current.leftChild = current.leftChild.leftChild;
        } else if(current.rightChild != null) {
          current.value = current.rightChild.value;
          current.leftChild = current.rightChild.leftChild;
          current.rightChild = current.rightChild.rightChild;
        } else {
          // Single node in tree, remove or not? 
          // If yes, then set root = null;
        }
      } else if(parent.leftChild == current) { // Is node to be removed left or right child of its parent?
        if(current.leftChild != null) { 
          parent.leftChild = current.leftChild;
        } else {
          parent.leftChild = current.rightChild;
        }
      } else if(parent.rightChild == current) { // Is node to be removed left or right child of its parent?
        if(current.rightChild != null) {
          parent.rightChild = current.rightChild;
        } else {
          parent.rightChild = current.leftChild;
        }
      }
    }
  }

  public int size() {
    return size(root);
  }

  // //Iterative
  // private int size(Node current) {
  //   while() {

  //   }
  // }

  // Recursive
  private int size(Node current) {
    if(current == null) {
      return 0;
    } else if(current.leftChild == null && current.rightChild == null) {
      return 1;
    } else {
      return 1 + size(current.leftChild) + size(current.rightChild);
    }
  }

  private int getMinValue(Node node) {
    if(node.leftChild == null) {
      return node.value;
    } else {
      return getMinValue(node.leftChild);
    }
  }

  public boolean contains(int value) {
    if(isEmpty()){
      return false;
    } else {
    Node curr = root;
    return contains(value, curr);
    }
  }
  // Recursive solution
  public boolean contains(int value, Node curr) {
    if(value < curr.value) {
      if(curr.leftChild == null) {
        return false;
      } else {
        return contains(value, curr.leftChild);
        }
      } else if(value > curr.value) {
        if(curr.rightChild == null) {
          return false;
        } else {
          return contains(value, curr.rightChild);
        }
      } else {
        return true;
      }
  }
  // Iterative solution
  public boolean find(int value) {
    Node node = root;
    while(node != null) {
      if(value < node.value)
        node = node.leftChild;
      else if(value > node.value)
        node = node.rightChild;
      else return true;
    }
    return false;
  }

  public boolean isEmpty() {
    return root == null;
  }
}