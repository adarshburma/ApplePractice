/*
  https://leetcode.com/problems/lru-cache/description/

*/


class LRUCache {

    class Node {
		int key;
		int val;
		Node pre;
		Node next;

		Node (int key, int val) {
			this.key = key;
			this.val = val;
		}
	}

	HashMap<Integer, Node> cache;
	int cap = 0;
	Node head = null, tail = null;


    public LRUCache(int capacity) {
        cache = new HashMap<>();
		this.cap = capacity;
    }

    public void setHead(Node n) {
		n.pre = null;
		n.next = head;

		if (head != null) {
			head.pre = n;
		}

		head = n;

		if (tail == null) {
			tail = head;
		}
	}

	public void remove(Node n) {

		if (n.pre != null) {
            n.pre.next = n.next;
		} else {
			head = n.next;
		}

		if (n.next != null) {
            n.next.pre = n.pre;	
		} else {
			tail = n.pre;
		}
	}
    
    public int get(int key) {
        if (cache.containsKey(key)) {
			Node n = cache.get(key);
			remove(n);
			setHead(n);
			return n.val;
		}
		return -1;
    }
    
    public void put(int key, int value) {
        Node n = null;
        if (cache.containsKey(key)) {
			n = cache.get(key);
			n.val = value;
			remove(n);
			setHead(n);	
		} else {
            n = new Node(key, value);
            if (cache.size() == this.cap) {
                cache.remove(tail.key);
                remove(tail);
            }

            cache.put(key, n);
            setHead(n);
        }	
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
