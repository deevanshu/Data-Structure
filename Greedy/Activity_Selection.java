package com.datastructure.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Meetings {

	int startTime;
	int endTime;
	int position;

	public Meetings(int startTime, int endTime, int position) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.position = position;
	}
}

class mycomparator implements Comparator<Meetings>
{
	public int compare(Meetings o1, Meetings o2) {

		if(o1.endTime > o2.endTime) {
			return 1;
		}
		if(o1.endTime < o2.endTime) {
			return -1;
		}
		return 0;
	}
}

public class Activity_Selection {

	public static void main(String args[]) {

		int start[] =  {75250  ,50074  , 43659,8931 ,11273 , 27545,50879 ,77924};  // -> 0 ,1 , 3 ,5 , 5 ,8
		int end[]   =  {112960 ,114515 ,81825 ,93424, 54316, 35533, 73383, 160252}; //  -> 

		ArrayList<Meetings> meet = new ArrayList<>();
		for(int i = 0; i < start.length; i++) {
			meet.add(new Meetings(start[i], end[i], i));
		}

		//		Collections.sort(meet , new mycomparator());

		Collections.sort(meet , ( o1,  o2) ->

		o1.endTime - o2.endTime

		//				if(o1.endTime > o2.endTime) {
		//					return 1;
		//				}
		//				if(o1.endTime < o2.endTime) {
		//					return -1;
		//				}
		//				return 0;
				);

		int ans = maxMeetings(start , end ,start.length ,meet);
		System.out.println(ans);
	}

	private static int maxMeetings(int[] start, int[] end, int n, ArrayList<Meetings> meet ) {

		if(n==1){

			return 1;
		}	

		int ans=1 , minValue=meet.get(0).endTime;


		for(int i = 1 ; i<meet.size() ; i++){


			if(meet.get(i).startTime > minValue) {
				ans++;
				minValue = meet.get(i).endTime;
			}
		}
		return ans;
	}
}