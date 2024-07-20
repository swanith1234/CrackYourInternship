//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java


class Solution { 
    // Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n) {
        Stack<Integer> stack = new Stack<>();
        
        // Step 1: Push all people to the stack
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }
        
        // Step 2: Get two people and compare them
        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();
            
            if (M[a][b] == 1) {
                // a knows b, so a cannot be a celebrity, push b
                stack.push(b);
            } else {
                // a does not know b, so b cannot be a celebrity, push a
                stack.push(a);
            }
        }
        
        // Step 3: Single candidate remains, check if they are a celebrity
        int candidate = stack.pop();
        
        for (int i = 0; i < n; i++) {
            // candidate should not know anyone else
            // everyone should know the candidate
            if (i != candidate && (M[candidate][i] == 1 || M[i][candidate] == 0)) {
                return -1;
            }
        }
        
        return candidate;
    }
}