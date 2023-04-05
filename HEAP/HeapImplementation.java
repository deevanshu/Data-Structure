package com.datastructure.HEAP;
import java.util.PriorityQueue;

class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class HeapImplementation {
	public static void main(String args[]) {

		int arr[] = { 1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17 };

		int nums[] = {3,2,1,5,6,4};
		int k =2;

		PriorityQueue<Integer> pq = new PriorityQueue<>(k);

		for(int i =0 ;i<k ; i++){
			pq.add(nums[i]);
		}

		for(int i = k ; i<nums.length ;i++){

			if(pq.peek() < nums[i]){

				pq.poll();
				pq.add(nums[i]);
			}
		}

		Node Head = new Node(arr[0]);

		createBinaryTreeFromArray(Head, arr, 0);

		System.out.println("Max Heap :");
		createMaxheap(arr);
		printHeap(arr, arr.length);

		int answer[] = sort(arr, 2);
		System.out.println(answer);
	}

	public static int[] sort(int arr[], int k) {
		int n = arr.length;

		int count = 0;
		int ans[] = new int[k];

		// One by one extract an element from heap
		for (int i = n - 1; i > 0; i--) {
			// Move current root to end
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			count++;
			if (count > k) {

				break;
			}
			ans[count - 1] = temp;

			// call max heapify on the reduced heap
			maxHeapify(arr, i, 0);
		}
		return ans;
	}

	private static void printHeap(int[] arr, int n) {

		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");

		System.out.println();
	}

	private static void createMaxheap(int[] arr) {

		int startIdx = (arr.length / 2) - 1;
		for (int i = startIdx; i >= 0; i--) {
			maxHeapify(arr, arr.length, i);
		}
	}

	private static void createMinHeap(int[] arr) {

		int startIdx = (arr.length / 2) - 1;
		for (int i = startIdx; i >= 0; i--) {
			minHeapify(arr, arr.length, i);
		}
	}

	private static void minHeapify(int[] arr, int n, int i) {

		int smallest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		if (left < n && arr[left] < arr[smallest]) {

			smallest = left;
		}

		if (right < n && arr[right] < arr[smallest]) {

			smallest = right;
		}

		if (smallest != i) {

			int swap = arr[i];
			arr[i] = arr[smallest];
			arr[smallest] = swap;

			minHeapify(arr, n, smallest);
		}
	}

	private static void maxHeapify(int[] arr, int n, int i) {

		int largest = i;
		int left  = 2 * i + 1;
		int right = 2 * i + 2;

		if (left < n && arr[left] > arr[largest]) {

			largest = left;
		}
		if (right < n && arr[right] > arr[largest]) {

			largest = right;
		}

		if (largest != i) {

			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			maxHeapify(arr, n, largest);
		}
	}

	private static void createBinaryTreeFromArray(Node head, int[] arr, int i) {

	//	int arr[] = { 1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17 };
		
		//    1
		//  /    \
		//  3     5
		// / \   / \
		//4   6 13 10
	//   / \ / \
	//  9  815 17

		int left  = 2 * i + 1;
		int right = 2 * i + 2;

		if (left < arr.length) {
			if (arr[left] == -1) {
				head.left = null;
			} else {

				head.left = new Node(arr[left]);
				createBinaryTreeFromArray(head.left, arr, left);
			}
		}
		if (right < arr.length) {
			if (arr[right] == -1) {
				head.right = null;
			} else {

				head.right = new Node(arr[right]);
				createBinaryTreeFromArray(head.right, arr, right);
			}
		}
		return ;
	}
}