/*

Given the root of a binary tree, the task is to flatten the tree into a linked list using the same TreeNode class. 
The left child pointer of each node in the linked list should always be NULL, and the right child pointer should point to the next node in the linked list. 
The nodes in the linked list should be in the same order as that of the preorder traversal of the given binary tree.


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

public class Main {
	public static TreeNode<Integer> flattenTree(TreeNode<Integer> root) {
		dfs(root);

		// Replace this placeholder return statement with your code 
		return root;
	}

	// Iterative approach ...
	public static TreeNode<Integer> flattenTree(TreeNode<Integer> root) {
		TreeNode<Integer> curr = root;

		while (curr != null) {
			if (curr.left != null) {
				TreeNode<Integer> prev = curr.left;
				while (prev.right != null) {
					prev = prev.right;
				}
				prev.right = curr.right;
				curr.right = curr.left;
				curr.left = null;
			}
			curr = curr.right;
		}

		return root;
	}

	// recurcive approach ...
	public static TreeNode<Integer> dfs(TreeNode<Integer> root) {

		if (root == null) return root;

		TreeNode<Integer> leftTail = dfs(root.left);
		TreeNode<Integer> rightTail = dfs(root.right);

		if (leftTail != null) {
			leftTail.right = root.right;
			root.right = root.left;
			root.left = null;
		}

		return rightTail != null ? rightTail : leftTail != null ? leftTail : root;
	}
}
