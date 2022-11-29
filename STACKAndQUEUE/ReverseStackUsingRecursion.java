package com.datastructures.STACKAndQUEUE;

import java.util.Stack;

public class ReverseStackUsingRecursion {



	public static void main(String args[]) {


		Stack<Character> st = new Stack<>();

		st.push('a');
		st.push('b');
		st.push('c');
		
		System.out.println(st.peek());
		
		
		reverse(st);

		System.out.println(st.peek());
	}

	private static void reverse(Stack<Character> st) {

		if(st.size()>0) {

			char temp = st.peek();
			st.pop();
			reverse(st);

			insert_at_bottom(temp , st);
		}
	}

	static void insert_at_bottom(char x , Stack<Character> st){

		if(st.isEmpty())
		{st.push(x);
		return;
		}
		else{
			/* All items are held in Function Call Stack until we
           reach end of the stack. When the stack becomes
           empty, the st.size() becomes 0, the
           above if part is executed and the item is inserted
           at the bottom */

			char a = st.peek();
			st.pop();
			insert_at_bottom(x , st);

			//push all the items held in Function Call Stack
			//once the item is inserted at the bottom
			st.push(a);
		}
	}

}
