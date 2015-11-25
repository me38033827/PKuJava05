Majority Element

Given an array of size n, find the majority element. The majority element is the element that appears more than ? n/2 ? times.

You may assume that the array is non-empty and the majority element always exist in the array.

public class Solution {
    public int majorityElement(int[] nums) {
        if(nums==null) return -1;
        int result=nums[0];
        int times=1;
        for(int i=1;i<nums.length;i++){
            if(times==0){
                result=nums[i];
                times=1;
            }
            else if(nums[i]==result)
               times++;
            else
               times--;
        }
        
        return result;
    }
}