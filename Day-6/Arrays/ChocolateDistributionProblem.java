//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i = 0;i<n;i++)
                {
                    int x = sc.nextInt();
                    arr.add(x);
                }
            int m = sc.nextInt();
            
            Solution ob = new Solution();
            
    		System.out.println(ob.findMinDiff(arr,n,m));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public long findMinDiff(ArrayList<Integer> a, int n, int m) {
        // If there are no chocolates or students
        if (m == 0 || n == 0)
            return 0;

        // Sort the given packets
        Collections.sort(a);

        // Number of students cannot be more than number of packets
        if (n < m)
            return -1;

        // Find the minimum difference
        long min_diff = Long.MAX_VALUE;

        // Iterate over the sorted list using a sliding window of size m
        for (int i = 0; i + m - 1 < n; i++) {
            long diff = a.get(i + m - 1) - a.get(i);
            if (diff < min_diff)
                min_diff = diff;
        }
        return min_diff;
    }
}