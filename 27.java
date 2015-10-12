
/*
Given an array and a value, remove all instances of that value in place and return the new length.
 
The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 

1£¬2£¬1£¬3£¬4£¬1
1

2£¬3£¬4 
3

*/


public class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums==null||nums.length==0) return 0;
        int len=nums.length;
        int low=0,high=len-1;
        while(low<high){
            while(low<high&&nums[low]!=val) ++low;
            while(low<high&&nums[high]==val) --high;
            swap(nums,low,high);
        }
        if(nums[low]!=val) return low+1;
        return low;
   }
   public static void swap(int[] data, int a, int b) {  
        int t = data[a];  
        data[a] = data[b];  
        data[b] = t;  
   } 
}