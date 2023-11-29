/*

Find the vertical order traversal of a binary tree when the root of the binary tree is given. 
In other words, return the values of the nodes from top to bottom in each column, column by column from left to right. 
If there is more than one node in the same column and row, return the values from left to right.

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

  public static class Node {
    TreeNode<Integer> node;
    int verticalOrder;

    Node (TreeNode<Integer> node, int verticalOrder) {
      this.node = node;
      this.verticalOrder = verticalOrder;
    }

  }

  public static List<List<Integer>> verticalOrder(TreeNode<Integer> root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        q.add(new Node(root, 0));
        int minIndex = Integer.MAX_VALUE, maxIndex = Integer.MIN_VALUE;

        while (!q.isEmpty()) {
          Node poped = q.poll();

          minIndex = Math.min(minIndex, poped.verticalOrder);
          maxIndex = Math.max(maxIndex, poped.verticalOrder);

          if (!map.containsKey(poped.verticalOrder)) {
            map.put(poped.verticalOrder, new ArrayList<>());
          }

          map.get(poped.verticalOrder).add(poped.node.data);

          if (poped.node.left != null) {
            q.add(new Node(poped.node.left, poped.verticalOrder-1));
          }

           if (poped.node.right != null) {
             q.add(new Node(poped.node.right, poped.verticalOrder+1));
           }
        }

        for (int i = minIndex; i <= maxIndex; i++) {
          res.add(map.get(i));
        }


        // Replace this placeholder return statament with your code
        return res;
  }
}
