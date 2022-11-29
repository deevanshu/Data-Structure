package com.datastructures.SEARCHINGSORTING;

public class FirstLastOccuranceOfX {

	public static void main(String[] args)
	{
		int array[]={ 1, 3, 5, 5, 5, 5, 7, 123, 125 };
		int x=71;
		int start=0 , end=array.length-1 ,startIndex=-1,endIndex=-1 ,count=0 ;
		boolean startFound=false , endFound=false;

		while(start<end) {
			count++;
			if(array[start]==x && !startFound) {

				startFound=true;
				startIndex=start;
			}
			
			else {
				start++;
			}
			
			if(array[end]==x && !endFound) {

				endFound=true;
				endIndex=end;
			}
			
			else {
				end--;
			}
			
			if(startFound && endFound) {
				break;
			}
		}
		
		System.out.println(count);
		
		if(!startFound && !endFound) {
			System.out.println("Start Index : -1  End Index: -1");
		}

		else if (startIndex==-1 && endIndex!=-1) {
			startIndex = endIndex;
			System.out.println("Start Index :"+startIndex +" End Index:"+endIndex);
		}

		else if (startIndex!=-1 && endIndex==-1) {
			endIndex = startIndex;
			System.out.println("Start Index :"+startIndex +" End Index:"+endIndex);
		}
		
		else {
			System.out.println("Start Index :"+startIndex +" End Index:"+endIndex);
		}
	}
}
