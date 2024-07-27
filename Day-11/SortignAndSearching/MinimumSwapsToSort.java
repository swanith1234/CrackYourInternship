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
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends




class Solution {
    // Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[]) {
        int n = nums.length;

        // Create a pair array of elements and their original indices
        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i], i);
        }

        // Sort the array based on the elements
        Arrays.sort(arr, Comparator.comparingInt(p -> p.value));

        // Initialize visited array
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        int swaps = 0;

        // Iterate through the array
        for (int i = 0; i < n; i++) {
            // If already visited or already in the right place, skip it
            if (visited[i] || arr[i].index == i) {
                continue;
            }

            // Find the cycle length
            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = arr[j].index;
                cycleSize++;
            }

            // If there is a cycle of size c, we need (c-1) swaps
            if (cycleSize > 0) {
                swaps += (cycleSize - 1);
            }
        }

        return swaps;
    }
}

// Pair class to store element and its index
class Pair {
    int value;
    int index;

    Pair(int value, int index) {
        this.value = value;
        this.index = index;
    }
}