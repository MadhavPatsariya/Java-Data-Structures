package SlidingWindow;

import java.util.HashMap;

public class LRUCache {
    HashMap<Integer, Node> map = new HashMap<>();
    int capacity;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            recentlyUsed(key);
            return map.get(key).val;
        }
        else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            update(key, value);
        }
        else{
            if(map.size() >= capacity) {
                remove();
            }
            newEntry(key, value);
        }
    }

    public void newEntry(int key, int value) {
        Node newNode = new Node(key, value);
        Node next = head.next;
        head.next = newNode;
        newNode.prev = head;
        newNode.next = next;
        next.prev = newNode;
        map.put(key, newNode);
    }

    public void update(int key, int value) {
        Node current = map.get(key);
        Node next = current.next;
        Node prev = current.prev;
        prev.next = next;
        next.prev = prev;
        map.remove(key);
        Node headsNext = head.next;
        Node newNode = new Node(key, value);
        head.next = newNode;
        headsNext.prev = newNode;
        newNode.next = headsNext;
        newNode.prev = head;
        map.put(key, newNode);
    }

    public void recentlyUsed(int key){
        Node current = map.get(key);
        Node next = current.next;
        Node prev = current.prev;
        prev.next = next;
        next.prev = prev;
        Node headsNext = head.next;
        head.next = current;
        headsNext.prev = current;
        current.next = headsNext;
        current.prev = head;
    }

    public void remove() {
        Node t = tail.prev;
        t.prev.next = tail;
        tail.prev = t.prev.next;
        map.remove(t.key);
    }
}

class Node {
    int val;
    int key;
    Node next;
    Node prev;
    public Node(int _key, int _val) {
        this.val = _val;
        this.key = _key;
    }
}

class Generate {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        cache.get(1);
        cache.put(3,3);
        cache.get(2);
        cache.put(4,4);
        cache.get(1);
        cache.get(3);
        cache.get(4);
    }
}