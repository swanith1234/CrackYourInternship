//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends

class Solution
{
    // Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Sort the jobs based on profit in descending order
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);

        // Find the maximum deadline among all jobs to create a schedule array
        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, arr[i].deadline);
        }

        // Create an array to keep track of free time slots
        boolean[] schedule = new boolean[maxDeadline + 1];

        int jobCount = 0;
        int maxProfit = 0;

        // Iterate through all the jobs
        for (int i = 0; i < n; i++) {
            // Find a free slot for this job (starting from its deadline)
            for (int j = arr[i].deadline; j > 0; j--) {
                if (!schedule[j]) {
                    // Slot found, schedule the job
                    schedule[j] = true;
                    jobCount++;
                    maxProfit += arr[i].profit;
                    break;
                }
            }
        }

        // Return the number of jobs done and the maximum profit
        return new int[] {jobCount, maxProfit};
    }
}
