//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                nums[i]  =Integer.parseInt(S[i]);
            int k = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            System.out.println(obj.solveWordWrap(nums, k));
        }
    }
}

// } Driver Code Ends

class Solution
{
    public int solveWordWrap (int[] nums, int k)
    {
         
          int n = nums.length;
        int[] dp = new int[n];
        int[] cost = new int[n];

         
        Arrays.fill(dp, Integer.MAX_VALUE);
        Arrays.fill(cost, 0);

        for (int i = n - 1; i >= 0; i--) {
            int length = -1;   
            dp[i] = Integer.MAX_VALUE;

            for (int j = i; j < n; j++) {
                length += (nums[j] + 1);   
                if (length > k) break;   

                
                if (j == n - 1) {
                    cost[j] = 0;   
                } else {
                    cost[j] = (k - length) * (k - length);   
                }

                
                if (j + 1 < n) {
                    dp[i] = Math.min(dp[i], cost[j] + dp[j + 1]);
                } else {
                    dp[i] = Math.min(dp[i], cost[j]);
                }
            }
        }

        return dp[0];
    }
}