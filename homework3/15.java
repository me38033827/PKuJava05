public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        	List<List<Integer>> res = new ArrayList<List<Integer>> ();        
        
        /*row1.add(1); 
        res.add(row1);
        return res;*/
        int i,j,k,sum;
        for(i=0;i<nums.length-1;i++){               //排序
            for(j=0;j<nums.length-i-1;j++){
                if(nums[j]>nums[j+1])
                {
                    k=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=k;
                }
                
            }
        }
        for(i=0;i<nums.length-2;i++){         //从头到尾遍历整个数组i代表第一个元素，j代表第二个，k代表第三个
        	sum=0-nums[i];                    //0-第一个元素=后两个元素之和
            //for(j=i+1;j<nums.length-1;j++){
              //  sum2=sum1-nums[j];
                //for(k=j+1;k<nums.length;k++){
                  //  if(nums[k]==sum2)
            j=i+1;k=nums.length-1;           //第二第三个元素分别从i+1和n-1开始遍历
            while(j<k){
                if(nums[j]+nums[k]>sum)
                    k--;
                else if(nums[j]+nums[k]<sum)
                    j++;
                else if(nums[j]+nums[k]==sum)
                    {List<Integer> row = new ArrayList<Integer>();
                    row.add(nums[i]);
                    row.add(nums[j]);
                    row.add(nums[k]);
                    res.add(row);
                    //if(nums[j+1]==nums[j])
                    while(j<nums.length-2&&nums[j+1]==nums[j]){         //如果有相同的元素直接向后遍历
                    	j++;
                    }
                    //if(nums[k-1]==nums[k])
                    while(k<nums.length-1&&nums[k-1]==nums[k]){         //如果有相同的元素直接向前遍历
                    	k--;
                    }
                    j++;
                    }
                
                
            }
                //}
            //}
          //if(nums[i+1]==nums[i])
          while(i<nums.length-1&&nums[i+1]==nums[i]){             //如果有相同的元素直接向后遍历
        	  i++;
          }  
        }
        return res;
    }
}