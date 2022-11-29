package com.datastructures.STACKAndQUEUE;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackAndQueue {


	public static void main(String args[]) {


		Stack<Integer> st = new Stack<>();

		Queue<Integer> qu = new LinkedList<>();
		if(st.peek()==2) {


		}

		// 1 2 3 , top = 1 , remove = 1 
		int x = 1;
		while(x<=3) {

			Stack<Integer> st2 = new Stack<>();
			while (!st.isEmpty()) {
				st2.push(st.pop());
			}
			st.push(x);
			while (!st2.isEmpty()) {
				st.push(st2.pop());
			}
			x++;
		}
		System.out.println(st.peek());
		System.out.println(st.pop());

		qu.poll();
		st.add(5);
		st.push(6);
		System.out.println(st.peek());
		int ans = st.pop();

		//	qu.remove();
		qu.add(1);
		qu.add(2);
		qu.add(3);

		int re = qu.remove();
		int rr = qu.peek();
		qu.clear();
		//custom stack

		stack<Integer> sta = new stack(3) ;
		sta.push(1);
		sta.push(2);
		sta.push(3);

		sta.peek();

		int an = sta.pop();

		sta.peek();

		stack<String> sts = new stack(2) ;
		sts.push("a");
		sts.push("" );
		sts.push("a");


	}
}

class queue <T>{

	int top = 0;
	int rear =-1;
	int size ;

	ArrayList <T> ar;

	public queue(int size) {

		this.size = size;
		ar = new ArrayList<>(size);		

	}

	public void add(T data) {

		if(rear == size+1) {

			System.out.println("Queue Overflow");
		}
		else {

			ar.add(data);
			rear=rear+1;

		}
	}

	public void remove() {


		ar.remove(top);
		top++;

	}
	public void peek() {

		ar.get(top);

	}
}

class stack <T>{

	int top =-1;
	int size ;
	int defaultSize = 20;
	ArrayList <T> st;

	public stack(int s) {

		this.size = s;
		st = new ArrayList<T>(s);
	}
	public stack() {

		this.size = defaultSize;
		st = new ArrayList<T>(defaultSize);
	}

	public void push(T data) {

		if (top + 1 == size) {

			// Display message when array is full
			System.out.println("Stack Overflow");
		}
		else {
			top=top+1;
			st.add(data);
		}

	}
	public T pop() {
		if (top == -1) {

			// Display message when there are no elements in
			// the stack
			System.out.println("Stack Underflow");
			return null;
		}
		else {
			int data = top;
			top-=1;
			return st.remove(data);
		}
	}
	public T peek() {

		if (top == -1) {

			// Display message when there are no elements in
			// the stack
			System.out.println("Stack Underflow");
			return null;
		}
		else {
			return st.get(top);
		}
	}

	public boolean empty() {
		return false;
	}
}