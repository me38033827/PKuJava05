public class Solution {
    public List<List<Integer>> result(int[] nums, int target) {
    int size=nums.length;
    Arrays.sort(nums);
    int i,j,left,right;    //ËÄ¸öÖ¸Õë
    List<List<Integer>>  result=new ArrayList<List<Integer>>();
    for(i=0; i < size -3 ;i++)
    {
        if(i>0 && nums[i] ==nums[i-1]) continue;
        for(j=i+1 ;j<size-2 ;j++)
        {
            if(j>i+1 && nums[j] == nums[j-1] ) continue; 
            left=j+1;right=size-1;
            while(left<right)
            {
                int sum=nums[i]+nums[j]+nums[left]+nums[right];
                if(sum ==target)
                {
                    result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                    do{ left++ ; } while(left<right && nums[left-1] == nums[left]); 
                    do{ right--; } while(left<right && nums[right+1]==nums[right]);
                }
                else if(sum<target)
                    left++;
                else
                    right--;
            }
        }
    }
    return result;
    }
}