class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
      int[] Answer=new int[m+n];
      int i=0,j=0,k=0;
      while(i<m&&j<n){
if(nums1[i]<nums2[j]){
  Answer[k]=nums1[i];
  k++;
  i++;
}
else{
  Answer[k]=nums2[j];
  k++;
  j++;
}
      }
      while(j<n){
           Answer[k]=nums2[j];
  k++;
  j++;
      }
      while(i<m){
           Answer[k]=nums1[i];
  k++;
  i++;
      }
       i=0;
      while(i<m+n){
          nums1[i]=Answer[i];
          i++;
      }
   
  }
}