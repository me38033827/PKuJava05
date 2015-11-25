public class Solution {
    public int[] singleNumber2(int[] nums) {
        int result[2];
        int[] nums1;
        int[] nums2;
        if(nums==null||nums.length==0) return -1;
        int res=nums[0];
        for(int i=1;i<nums.length;i++)
           res^=nums[i];
        int index=findFirstbitis1(res);
        
        for(int i=1;i<nums.length;i++){
            if(isbit1(nums[i],index)){
               int j=0;
               nums1[j]=nums[i];
               j++;
             }else{
               int k=0;
               nums1[k]=nums[i];
               k++;
             }    
        }
        result[0]=singleNumber(nums1);
        result[1]=singleNumber(nums2);
        return result;

    }

    public int singleNumber(int[] nums) {
        if(nums==null||nums.length==0) return -1;
        int result=nums[0];
        for(int i=1;i<nums.length;i++)
           result^=nums[i];
     
    }


    public int findFirstbitis1(int res) {
        int index=0;
        if(res&1==0&&index<32){
           index++;
           res=res>>1;
        }
       return index;
    }


    public bool isbit1(int res,int index){

        return (res>>index)&1;
    }
}