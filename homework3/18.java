public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>> ();        
        int i,j,k,m,sum2,sum1;
        for(i=0;i<nums.length-1;i++){               //����
            for(j=0;j<nums.length-i-1;j++){
                if(nums[j]>nums[j+1])
                {
                    k=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=k;
                }
                
            }
        }
        for(m=0;m<nums.length-3;m++){            //��sum3�Ļ����϶��һ��ѭ����target-��һ������Ϊsum3�����е�0��
                sum1=target-nums[m];
            for(i=m+1;i<nums.length-2;i++)
            {         //��ͷ��β������������i�����һ��Ԫ�أ�j����ڶ�����k���������
            	sum2=sum1-nums[i];                    //0-��һ��Ԫ��=������Ԫ��֮��
                j=i+1;k=nums.length-1;           //�ڶ�������Ԫ�طֱ��i+1��n-1��ʼ����
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
                        while(j<nums.length-2&&nums[j+1]==nums[j]){         //�������ͬ��Ԫ��ֱ��������
                        	j++;
                        }
                        while(k<nums.length-1&&nums[k-1]==nums[k]){         //�������ͬ��Ԫ��ֱ����ǰ����
                        	k--;
                        }
                        j++;
                        }
                    
                    
                }
              while(i<nums.length-1&&nums[i+1]==nums[i]){             //�������ͬ��Ԫ��ֱ��������
            	  i++;
              }  
            }
            while(m<nums.length-3&&nums[m+1]==nums[m]){             //�������ͬ��Ԫ��ֱ��������
            	  m++;
            }
        }
        return res;
    }
}