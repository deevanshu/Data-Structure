package com.datastructures.SEARCHINGSORTING;

import java.util.Arrays;
import java.util.Comparator;

public class WeightedJobSchedulling {

	int start, finish, profit;

	WeightedJobSchedulling(int start, int finish, int profit)
	{
		this.start = start;
		this.finish = finish;
		this.profit = profit;
	}

	public static void main(String args[]) {

		WeightedJobSchedulling jobs[] = {
				new WeightedJobSchedulling(3, 5, 20), new WeightedJobSchedulling(1, 2, 50),
				new WeightedJobSchedulling(6, 19, 100), new WeightedJobSchedulling(2, 100, 200)
		}; 

		System.out.println("Optimal profit is " + schedule(jobs));
	}

	static public int schedule(WeightedJobSchedulling jobs[]) {
		
	        int T[] = new int[jobs.length];
	        JobComparator comparator = new JobComparator();
	        Arrays.sort(jobs, comparator);
	        T[0] = jobs[0].profit;
	        
	        for(int i=1; i < jobs.length; i++){
	            T[i] = jobs[i].profit;
	            
	            for(int j=0;j<i; j++){
	                if(jobs[j].finish <= jobs[i].start){
	                    T[i] = Math.max(T[i], jobs[i].profit + jobs[j].profit);
	                }
	            }
	        }
	        
	        int maxVal = Integer.MIN_VALUE;
	        for (int val : T) {
	            if (maxVal < val) {
	                maxVal = val;
	            }
	        }
	        return maxVal;
		
	}
}
class JobComparator implements Comparator<WeightedJobSchedulling>
{
	public int compare(WeightedJobSchedulling a, WeightedJobSchedulling b)
	{
		if(a.finish - b.finish > 0) {

			return 1;
		}
		else {

			return -1;
		}
	
	}
}