/*
   Given the root of a binary tree, check whether it is a symmetric tree. 
   A symmetric tree refers to a tree that is a mirror of itself, i.e., symmetric around its root.

*/



// Definiton of a binary tree node class
// class TreeNode<T> {
//     T data;
//     TreeNode<T> left;
//     TreeNode<T> right;

//     TreeNode(T data) {
//         this.data = data;
//         this.left = null;
//         this.right = null;
//     }
// }

import java.util.*;
import ds_v1.BinaryTree.TreeNode;


public class Main{
  // bfs ...
  public static boolean isSymmetric (TreeNode<Integer> root) {
    Queue<TreeNode<Integer>> q = new LinkedList<>();
    q.add(root.left);
    q.add(root.right);

    while(!q.isEmpty()) {
      TreeNode<Integer> left = q.poll();
      TreeNode<Integer> right = q.poll();

      if (left == null && right == null) continue;

      if (left == null || right == null) return false;

      if (left.data != right.data) return false;

      q.add(left.left);
      q.add(right.right);
      q.add(left.right);
      q.add(right.left);
    }

    return true;
  }


  // dfs ...
    public static boolean isSymmetric(TreeNode<Integer> root) {
    
    return helper(root.left, root.right);
  }

  public static boolean helper( TreeNode<Integer> left, TreeNode<Integer> right) {
    if (left == null && right == null) return true;

    if (left == null || right == null) return false;

    if (left.data == right.data) {
       return helper(left.left, right.right) && helper(left.right, right.left); 
    }
    return false;
  }
}
