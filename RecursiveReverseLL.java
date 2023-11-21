/*
    Recursive reverse linked list ...

*/
public class HelloWorld{
    
    public static class LL {

        private Node head;
        private Node tail;
        private int size;
    
        public LL() {
            this.size = 0;
        }
        
        private class Node {
            private int value;
            private Node next;
    
            public Node(int value) {
                this.value = value;
            }
    
            public Node(int value, Node next) {
                this.value = value;
                this.next = next;
            }
        }
    
        public void insertFirst(int val) {
            Node node = new Node(val);
            node.next = head;
            head = node;
    
            if (tail == null) {
                tail = head;
            }
            size += 1;
        }
    
        public void insertLast(int val) {
            if (tail == null) {
                insertFirst(val);
                return;
            }
            Node node = new Node(val);
            tail.next = node;
            tail = node;
            size++;
        }
        
        public void insert(int val, int index) {
            if (index == 0) {
                insertFirst(val);
                return;
            }
            if (index == size) {
                insertLast(val);
                return;
            }
    
            Node temp = head;
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
    
            Node node = new Node(val, temp.next);
            temp.next = node;
    
            size++;
        }
        
        
        public void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.value + " -> ");
                temp = temp.next;
            }
            System.out.println("END");
        }
        
        public void reverse(Node node) {
            if (node == tail) {
                head = tail;
                return;
            }
            
            reverse(node.next);
            tail.next = node;
            tail = node;
            tail.next = null;
        }
    }
    
    

     public static void main(String []args){
        System.out.println("Hello, World!");
        
        LL l = new LL();
        
        l.insertLast(1);
        l.insertLast(2);
        l.insertLast(3);
        l.insertLast(4);
        l.insertLast(5);
        
        l.display();
        
        l.reverse(l.head);
        
        l.display();
        
     }
}
