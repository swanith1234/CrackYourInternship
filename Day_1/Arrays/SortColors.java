class Solution {
  public void sortColors(int[] nums) {
   int start=0;
   int end=(nums.length)-1;
   int middle=0;
   int temp=0;
   while(middle<=end){
      if(nums[middle]==0){
           temp=nums[middle];
          nums[middle]=nums[start];
          nums[start]=temp;
          start++;
          middle++;
      }
    else  if(nums[middle]==1){
          middle++;
      }
    else  if(nums[middle]==2){
           temp=nums[middle];
          nums[middle]=nums[end];
          nums[end]=temp;
          end--;
      }

   }
  }
}