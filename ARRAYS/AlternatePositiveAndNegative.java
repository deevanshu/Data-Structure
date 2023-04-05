package com.datastructures.ARRAYS;
import java.util.ArrayList;


public class AlternatePositiveAndNegative {

	void rightrotate(int arr[], int n, int outofplace,
			int cur)
	{
		int tmp = arr[cur];
		for (int i = cur; i > outofplace; i--)
			arr[i] = arr[i - 1];
		arr[outofplace] = tmp;
	}
	void rearrange(int arr[], int n)
	{
		int outofplace = -1;

		for (int index = 0; index < n; index++)
		{
			if (outofplace >= 0)
			{
				// find the item which must be moved into
				// the out-of-place entry if out-of-place
				// entry is positive and current entry is
				// negative OR if out-of-place entry is
				// negative and current entry is negative
				// then right rotate
				//
				// [...-3, -4, -5, 6...] --> [...6, -3,
				// -4, -5...]
				//	 ^						 ^
				//	 |						 |
				//	 outofplace	 -->	 outofplace
				//
				if (((arr[index] >= 0)
						&& (arr[outofplace] < 0))
						|| ((arr[index] < 0)
								&& (arr[outofplace] >= 0))) {
					rightrotate(arr, n, outofplace, index);

					// the new out-of-place entry is now 2
					// steps ahead
					if (index - outofplace >= 2)
						outofplace = outofplace + 2;
					else
						outofplace = -1;
				}
			}

			// if no entry has been flagged out-of-place
			if (outofplace == -1)
			{
				// check if current entry is out-of-place
				if (((arr[index] >= 0)
						&& ((index %2 ) == 0))
						|| ((arr[index] < 0)
								&& (index %2) != 0))
					outofplace = index;
			}
		}
	}
	static void printArray(int arr[], int n)
	{
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		System.out.println("");
	}
	public static void main(String[] args)
	{
		int nums[] = {3,1,-2,-5,2,-4};

		ArrayList<Integer> list = new ArrayList<>();
		int posIndex = 0 , negIndex=-1 ; 

		for(int i=0 ; i<nums.length ; i++){

			if(nums[i]>0){
				if(posIndex < list.size() && list.get(posIndex) < 0) {

					list.add(posIndex , nums[i]);
					posIndex++;
					negIndex++;
				}
				else {
					list.add(posIndex , nums[i]);
					posIndex++;
				}
			} 

			else{
				
				if(negIndex==-1){
					negIndex = posIndex;
				}
				list.add(negIndex , nums[i]);
				negIndex++;
			}  
		}
		negIndex = posIndex;
		posIndex = 0 ;

		boolean FromPosIndex = true  , FromNegIndex = false ;
		for(int i=0 ; i<nums.length ; i++){


			if(FromPosIndex && posIndex < list.size()){

				nums[i] = list.get(posIndex); 
				FromPosIndex = false;
				FromNegIndex = true ;
				posIndex++ ;
				continue;
			}  
			if(FromNegIndex  && negIndex < list.size()) {

				nums[i] = list.get(negIndex);
				FromNegIndex = false;
				FromPosIndex = true ;
				negIndex++ ;
			}  

		}

		AlternatePositiveAndNegative rearrange = new AlternatePositiveAndNegative();
		int arr[] = {-5, 3, 4, 5, -6,
				-2, 8, 9, -1, -4};
		int n = arr.length;

		System.out.println("Given array is ");
		printArray(arr, n);

		//rearrange.rearrange(arr, n);
		rearrange.rearrange1(arr, n);
	}
	private void rearrange1(int[] arr, int n) {

		int i=0 , negCntr=0 , posCntr=0;

		while(posCntr<n) {
			if(arr[posCntr]<0) {

				int temp = arr[posCntr];
				arr[posCntr]= arr[negCntr];
				arr[negCntr]=temp;

				posCntr++;
				negCntr++;
			}			
			else {	
				posCntr++;
			}
		}
		System.out.println("After Seggregating Pos & Neg");

		placeNegPos(arr ,negCntr);
	}
	private void placeNegPos(int[] arr , int posCnt) {

		for(int i=0;i<arr.length;i++) {

			if(arr[i] < 0 && arr[posCnt] > 0) {
				shiftToRight(arr , posCnt ,i+1);
				if(posCnt+1<arr.length) {
					posCnt++;
				}
				else {
					break;
				}
			}
		}
	}
	private void shiftToRight(int[] arr, int end, int start) {

		for(int k=end;k>start;k--) {

			int temp=arr[k];
			arr[k]=arr[k-1];
			arr[k-1]=temp;
		}
	}	
}