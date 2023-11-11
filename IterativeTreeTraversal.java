/* Online Java Compiler and Editor */
import java.util.*;
public class IterativeTreeTraversal{
    
    public static class Node {
        Node left;
        Node right;
        int val;
        
        Node (int val) {
            this.val = val;
        }

    }
    
    
    
    public static void inorder (Node root) {
        Stack<Node> st = new Stack<>();
        Node left = root;
        
        while (!st.isEmpty() || left != null) {
            while (left != null) {
                st.push(left);
                left = left.left;
            }
            
            if (! st.isEmpty()) {
                Node poped = st.pop();
                System.out.println(poped.val);
                if (poped.right != null) {
                    left = poped.right;
                }
            }
        }
    }
    
    public static void preorder(Node root) {
        Stack<Node> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            Node poped = st.pop();
            System.out.println(poped.val);
            
            if (poped.right != null) {
                st.push(poped.right);
            }
            
            if (poped.left != null) {
                  st.push(poped.left);
            }
          
        }
    }
    
    public static void postorder (Node root) {
        // List<Integer> postOrder = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        
        Node left = root;
        Node prev = null;
        
        while (!st.isEmpty() || left != null) {
            while (left != null) {
                st.push(left);
                left = left.left;
            }
            
            if (!st.isEmpty()) {
                if (st.peek().right != null && st.peek().right.val != prev.val) {
                    left = st.peek().right;
                } else {
                    Node poped = st.pop();
                    prev = poped;
                    // postOrder.add(poped.val);
                    System.out.println(poped.val);
                }
            }
        }
    }

     public static void main(String []args){
         
         Node root = new Node(1); 
        root.left = new Node(2); 
        root.right = new Node(3); 
        root.left.left = new Node(4); 
        root.left.right = new Node(5); 
        root.right.left = new Node(6); 
        root.right.right = new Node(7);
         
        // Node root = new Node(4);
        // root.left = new Node(2);
        // root.right = new Node(6);
        // root.left.left = new Node(1);
        // root.left.right = new Node(3);
        
        // root.right.left = new Node(5);
        // root.right.right = new Node(7);
        
        System.out.println("preorder: ");
        preorder(root);
        System.out.println("inorder: ");
        inorder(root);
        System.out.println("postorder: ");
        postorder(root);
        
     }
}
