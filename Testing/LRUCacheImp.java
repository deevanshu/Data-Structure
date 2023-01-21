package Testing;
import java.util.HashMap;

class Node{

	int key;
	int value;
	Node next;
	Node prev;

	public Node(int key , int value) {

		this.key = key;
		this.value = value;
		next = null;
		prev = null;
	}
}


public class LRUCacheImp {

	static HashMap<Integer , Node>hm;
	static int count=0 , capacity=0;
	static Node head , tail;

	public LRUCacheImp(int val) {

		hm = new HashMap<>(val);
		capacity=val;
		head = new Node(0,0);
		tail = new Node(0,0);
		head.next = tail;
		head.prev = null;
		tail.next = null;
		tail.prev = head;

	}
	public static void putEntryIntoCache(int key, int value) {

		if(hm.containsKey(key)) {

			Node  exist = hm.get(key);
			exist.value = value;
			if(count > 1) { // if more than 1 node then only re shuffle to put currently accessed node in front
				deleteNode(exist);
				addToHead(exist);
			}
		}
		else {

			Node temp = new Node(key , value);
			hm.put(key, temp);
			if(count < capacity) {

				if(count==0) {

					head = temp;
					tail = temp;
				}
				else {
					addToHead(temp);
				}
				count++;
			}
			else {

				if(count>1) {  // At least 2 nodes are there as capacity is 2 

					tail.prev.next = null;
					Node  prevTemp= tail.prev;
					tail.prev = null;
					hm.remove(tail.key);
					tail = prevTemp;
					addToHead(temp);
				}
				else { // Only 1 node is there as capacity is 1 

					hm.remove(tail.key);
					head = temp;
					tail = temp;
				}
			}
		}
	}
	public static int getFromCache(int key) {

		if(hm.containsKey(key)) {

			Node  val = hm.get(key);
			if(count>1) {  // if more than 1 node then only re shuffle
				deleteNode(val);
				addToHead(val);
			}
			return val.value;
		}
		return -1;
	}
	public static void addToHead(Node temp) {

		temp.next = head;
		head.prev = temp;
		head = temp;	
	}
	public static void deleteNode(Node temp) {

		if(temp!=head) {

			if(temp!=tail) {

				temp.prev.next = temp.next;
				temp.next.prev = temp.prev;
				temp.prev = null;
				temp.next = null;
			}
			else {

				temp.prev.next = null;
				Node prevNode  = temp.prev;
				temp.prev = null;
				tail = prevNode;
			}
		}
		else {

			if(count>1) {
				Node nextNode = temp.next;
				temp.next.prev = null;
				temp.next = null;
				head = nextNode;
			}
			else {

				head = new Node(0,0);
				tail = new Node(0,0);
				head.next = tail;
				head.prev = null;
				tail.next = null;
				tail.prev = head;
			}
		}
	}
	public static void main(String args[]) {

		LRUCacheImp lu = new LRUCacheImp(3);
		lu.putEntryIntoCache(2, 1);
		System.out.println(lu.getFromCache(2));
		lu.putEntryIntoCache(3, 2);
		System.out.println(lu.getFromCache(3));
		lu.putEntryIntoCache(3, 8);
		System.out.println(lu.getFromCache(3));
		lu.putEntryIntoCache(5, 2);
		lu.putEntryIntoCache(6, 4);
		System.out.println(lu.getFromCache(6));
		System.out.println(lu.getFromCache(2));
	}
}
