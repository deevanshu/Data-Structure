package com.datastructures.STACKAndQUEUE;
import java.util.HashMap;

class Node  {

	int key   ;
	int value ;
	Node prev ;
	Node next ;

	public Node (int key , int value) {

		this.key = key ;
		this.value = value;
		this.prev = null;
		this.next = null;
	}
}

class LRU{

	HashMap<Integer , Node> hm ;
	int capacity , count=0;
	Node head , tail;

	public LRU(int capacity) {

		this.capacity = capacity;
		hm   = new HashMap<>();	
		head = new Node(0,0);
		tail = new Node(0,0);
		head.next = tail;
		head.prev = null;
		tail.next = null;
		tail.prev = head;

	}
	public int getFromCache(int key) {

		if(hm.containsKey(key)) {

			Node temp = hm.get(key);
			int res = temp.value;
			if(count>1) {
				deleteNode(temp);
				addToHead(temp);
			}
			return res;
		}

		return -1;
	}
	private void addToHead(Node temp) {

		temp.next = head;
		head.prev = temp;
		head      = temp;
	}
	private void deleteNode(Node temp) {

		if(temp!=head) {
			temp.prev.next = temp.next;
			if(temp.next!=null) {
				temp.next.prev = temp.prev;
			}
			else {

				tail = temp.prev;
			}
			temp.next = null;
			temp.prev = null;
		}
		else {

			head = head.next;
			temp.next = null;
			temp.prev = null;
			head.prev = null;
		}
	}
	public void putEntryIntoCache(int key, int value) {

		if(hm.containsKey(key)) {

			Node temp = hm.get(key);
			temp.value = value;
			if(count > 1) {
				deleteNode(temp);
				addToHead(temp);
			}
		}
		else {

			Node node = new Node(key, value);
			hm.put(key , node);

			if(count < capacity) {

				if(count==0) {
					head = node;
					tail = node;
				}
				else {
					addToHead(node);
				}
				count++;
			}
			else {

				if(count>1) {
					tail.prev.next = null;
					Node temp = tail.prev;
					tail.prev = null;
					hm.remove((Integer)tail.key);
					tail = temp;
					addToHead(node);
				}
				else {

					hm.remove(tail.key);
					head = node;
					tail = node;
				}
			}
		}
	}

}
public class LRUCACHE {
	public static void main(String args[]) {

		LRU lu = new LRU(1);
		lu.putEntryIntoCache(2, 1);
		System.out.println(lu.getFromCache(2));

		lu.putEntryIntoCache(3, 2);
		System.out.println(lu.getFromCache(2));
		System.out.println(lu.getFromCache(3));

	}
}