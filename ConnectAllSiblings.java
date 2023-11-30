/*
  The task is to connect all nodes in a binary tree. 
  Connect them from left to right so that the next pointer of each node points to the node on its immediate right.
  The next pointer of the right-most node at each level should point to the first node of the next level in the tree.
  Each node in the given binary tree for this problem includes a next pointer, along with the left and right pointers. 
  Your solution must set the next pointer to connect the same level nodes to each other and across levels.
*/

import java.util.*;

public class NextRightPointers{
    // Function to populate same level pointers
	public static void populateNextNodePointers(EduTreeNode<Integer> node) {
		// Write your code here
		Queue<EduTreeNode<Integer>> q = new LinkedList<>();
		q.add(node);

		EduTreeNode<Integer> last = node;

		while (! q.isEmpty()) {
			EduTreeNode<Integer> curr = q.peek();
			last.next = curr;
			int size = q.size();

			for(int i = 0 ; i < size; i++) {
				EduTreeNode<Integer> poped = q.poll();
				if (i > 0) {
					curr.next = poped;
					curr = curr.next;
				}

				if (poped.left != null) {
					q.add(poped.left);
				}

				if (poped.right != null) {
					q.add(poped.right);
				}
			}

			curr.next = null;
			last = curr;
		}
	}


	// Do not modify the code below
	// Function to find the given node and return its next node
	public static EduTreeNode<Integer> getNextNode(EduTreeNode<Integer> node, int nodeData) {
		// Performing Binary Search
		while (node != null && nodeData != node.data) {
			if (nodeData < node.data) {
				node = node.left;
			} else {
				node = node.right;
			}
		}
		if (node != null) {
			return node.next;
		} else {
			return null;
		}
	}
}
