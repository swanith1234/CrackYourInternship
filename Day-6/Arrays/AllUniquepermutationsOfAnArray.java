
class Solution {
  static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {
      // Sort the array to ensure permutations are generated in sorted order
      Collections.sort(arr);
      
      // ArrayList to store all unique permutations
      ArrayList<ArrayList<Integer>> result = new ArrayList<>();
      
      // Visited array to keep track of used elements
      boolean[] used = new boolean[n];
      
      // Temporary list to store current permutation
      ArrayList<Integer> currentPermutation = new ArrayList<>();
      
      // Call recursive function to generate permutations
      generatePermutations(arr, n, used, currentPermutation, result);
      
      return result;
  }
  
  static void generatePermutations(ArrayList<Integer> arr, int n, boolean[] used, 
                                   ArrayList<Integer> currentPermutation, 
                                   ArrayList<ArrayList<Integer>> result) {
      // If current permutation is of length n, add it to result
      if (currentPermutation.size() == n) {
          result.add(new ArrayList<>(currentPermutation));
          return;
      }
      
      for (int i = 0; i < n; i++) {
          // Skip used elements
          if (used[i])
              continue;
          
          // Skip duplicates (to handle repeated elements)
          if (i > 0 && arr.get(i).equals(arr.get(i - 1)) && !used[i - 1])
              continue;
          
          // Include current element in the permutation
          used[i] = true;
          currentPermutation.add(arr.get(i));
          
          // Recursive call for the next position
          generatePermutations(arr, n, used, currentPermutation, result);
          
          // Backtrack
          used[i] = false;
          currentPermutation.remove(currentPermutation.size() - 1);
      }
  }
}