public class Solution {
    public int majorityElement(int[] nums) {
        int i=0,Max=0,count=0;
        /*if(j==0)                ���������λ����ʱ����
        return nums[0];
        for(i=0;i<nums.length;i++){
            count=1;
            for(j=i+1;j<nums.length;j++){
                if(nums[j]==nums[i])
                    count++;
                if(count>=nums.length/2)
                    return nums[i];
            }
            if(nums[i+1]==nums[i])
            i++;
        }
        return 0;*/
        
        /*if(j==0)                     ������ͬ��һ����������ͬ��ɾ�����������
        return nums[0];
        while(i<j-1){
        
            if(nums[i]==nums[j]){
                temp=nums[j];
                j--;
                
            }
            else{
                i++;
                j--;
            }
        }
        if(i==j||nums[i]==nums[j])
        return nums[i];
        else
        return temp;*/
        for(i=0;i<nums.length;i++){          //��������ͬ��ɾ����������ͬ��count++��
            if(count==0){
                Max=nums[i];
                count++;
            }else{
                if(nums[i]==Max)
                count++;
                else{
                    count--;
                }
            }
            
        }
        return Max;
       
    }
}