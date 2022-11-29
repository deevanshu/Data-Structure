package com.datastructure.Greedy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Job {

	char id;
	int deadline;
	int profit;

	public Job() {};
	public Job(char id, int deadline, int profit)
	{
		this.id = id;
		this.deadline = deadline;
		this.profit = profit;
	}

	public void printJobScheduling(ArrayList<Job> arr, int t) {
		
//	        arr.sort((o1, o2) -> {
//	        return Integer.valueOf(o2.profit).compareTo(o1.profit);
//	        });
	    
		Collections.sort(arr , (a, b) -> b.profit - a.profit);

        int maxDeadline = arr.get(0).deadline;
        for (int i = 1; i < arr.size(); i++) {
           maxDeadline = Math.max(maxDeadline, arr.get(i).deadline);
        }
  
        int slot[] = new int[maxDeadline + 1];
        for (int i = 0; i <= maxDeadline; i++)
            slot[i] = -1;
   
        int countJobs = 0, jobProfit = 0;
        
       for (int i = 0; i < arr.size(); i++) {
         for (int j = arr.get(i).deadline; j > 0; j--) {
            if (slot[j] == -1) {
            slot[j] = i;
            countJobs++;
            jobProfit += arr.get(i).profit;
            break;
         }
      }
   }
       
       int [] res = new int[2];
       res[0] = countJobs;
       res[1] = jobProfit;
	}
}
public class JobSequencing {

	public static void main(String args[])
	{
		ArrayList<Job> arr = new ArrayList<Job>();
		arr.add(new Job('a', 2, 100));
		arr.add(new Job('b', 1, 19));
		arr.add(new Job('c', 2, 27));
		arr.add(new Job('d', 1, 25));
		arr.add(new Job('e', 3, 15));
		
//		arr.add(new Job('a', 4, 20));
//		arr.add(new Job('b', 1, 10));
//		arr.add(new Job('c', 1, 40));
//		arr.add(new Job('d', 1, 30));

	//	1 4 20   2 1 10   3 1 40   4 1 30

		Job job = new Job();

		job.printJobScheduling(arr, 3);
	}
}
