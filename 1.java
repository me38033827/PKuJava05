
/*Two Sum
 Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2 
/*

// ʹ��map

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result=new int[2];
        if(nums==null||nums.length==0) return result;
        HashMap<Integer,Integer> m=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(m.containsKey(target-nums[i])){
                result[1]=i+1;
                result[0]=m.get(target-nums[i])+1;
                return result;
            }
             m.put(nums[i],i);
        }
        return result;
    }
}

