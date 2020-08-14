package com.dsa.datastructures;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    TreeNode root;
    
  private List<Integer> valueList = new ArrayList<Integer>();

  public void levelOrder() {
    levelOrder(root);
  }

  public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> list = new ArrayList<List<Integer>>();
      for(int i = 0; i <= height(root); i++) {
          List<Integer> l = new ArrayList<Integer>();
          getNodesAtDistance(root, i, l);
          list.add(l);
          System.out.println(list);
      }
      return list;
  }
  
  public int height(TreeNode root) {
      if(root == null)
          return -1;
      if(root.left == null && root.right == null)
          return 0;
      return 1 + Math.max(height(root.left), height(root.right));
  }
  
  private List<Integer> getNodesAtDistance(TreeNode root, int distance, List<Integer> l) {
      if(root == null)
        return null;  
      if(distance == 0) {
          l.add(root.val);
      }
       getNodesAtDistance(root.left, distance - 1, l);
       getNodesAtDistance(root.right, distance -1, l);
      System.out.println(l);
       return l;
  }
}