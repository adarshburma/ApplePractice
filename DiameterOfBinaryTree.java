/*
  Given a binary tree, you need to compute the length of the tree’s diameter.
  The diameter of a binary tree is the length of the longest path between any two nodes in a tree. 
  This path may or may not pass through the root.

*/


import java.util.*;
import ds_v1.BinaryTree.TreeNode;

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

public class Main{
    static int diameter = Integer.MIN_VALUE;
    public static int diameterOfBinaryTree(TreeNode<Integer> root) {

      if (root == null) return 0;

      helper(root);

      return diameter;
  }

  public static int helper (TreeNode<Integer> root) {
    if (root == null) return 0;

    int leftDistance = helper(root.left);
    int rightDistance = helper(root.right);

    diameter = Math.max(diameter, leftDistance + rightDistance);

    return 1 + Math.max(leftDistance, rightDistance);
  }
}
