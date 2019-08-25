package cache;

import java.util.HashMap;

public class LRUCache implements ICache {
	HashMap<Integer, Integer> map = new HashMap<>();
	HashMap<Integer, Node> addMap = new HashMap<>();
	Node head = null;
	Node end = null;
	int capacity = -1;

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if (!map.containsKey(key)) {
			return -1;
		} else {
			Node address = addMap.get(key);
			if (address != head) {
				deleteNode(address);
				addNode(address);
			}
			return map.get(key);
		}
	}

	public void addNode(Node node) {
		node.next = head;
		if (head != null) {
			head.prev = node;
		}
		head = node;
		head.prev = null;
		if (end == null) {
			end = head;
		}
	}

	public void deleteNode(Node node) {
		if (node.prev != null) {
			node.prev.next = node.next;
		}
		if (node.next != null) {
			node.next.prev = node.prev;
		}
		if (node == head) {
			head = node.next;
			end = null;
		}
		if (node == end) {
			end = node.prev;
		}
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			Node address = addMap.get(key);
			if (address != head) {
				deleteNode(address);
				addNode(address);
			}
		} else {
			Node node = new Node(key);
			addNode(node);
			addMap.put(key, node);
		}
		map.put(key, value);
		if (map.size() > capacity) {
			int k = end.key;
			addMap.remove(k);
			map.remove(k);
			deleteNode(end);
		}
	}

	@Override
	public void size(int size) {
		this.capacity = size;
	}
}

class Node {
	int key;
	Node next;
	Node prev;

	public Node(int key) {
		this.key = key;
	}
}
