public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>> ();        
        int i,j,k,m,sum2,sum1;
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
        for(m=0;m<nums.length-3;m++){            //在sum3的基础上多加一次循环，target-第一个数即为sum3问题中的0；
                sum1=target-nums[m];
            for(i=m+1;i<nums.length-2;i++)
            {         //从头到尾遍历整个数组i代表第一个元素，j代表第二个，k代表第三个
            	sum2=sum1-nums[i];                    //0-第一个元素=后两个元素之和
                j=i+1;k=nums.length-1;           //第二第三个元素分别从i+1和n-1开始遍历
                while(j<k){
                    if(nums[j]+nums[k]>sum2)
                        k--;
                    else if(nums[j]+nums[k]<sum2)
                        j++;
                    else if(nums[j]+nums[k]==sum2)
                        {List<Integer> row = new ArrayList<Integer>();
                        row.add(nums[m]);
                        row.add(nums[i]);
                        row.add(nums[j]);
                        row.add(nums[k]);
                        res.add(row);
                        while(j<nums.length-2&&nums[j+1]==nums[j]){         //如果有相同的元素直接向后遍历
                        	j++;
                        }
                        while(k<nums.length-1&&nums[k-1]==nums[k]){         //如果有相同的元素直接向前遍历
                        	k--;
                        }
                        j++;
                        }
                    
                    
                }
              while(i<nums.length-1&&nums[i+1]==nums[i]){             //如果有相同的元素直接向后遍历
            	  i++;
              }  
            }
            while(m<nums.length-3&&nums[m+1]==nums[m]){             //如果有相同的元素直接向后遍历
            	  m++;
            }
        }
        return res;
    }
}