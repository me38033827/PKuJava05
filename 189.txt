public class Solution {
    public void rotate(int[] nums, int k) {
        if(nums==null||k<=0) return;
        int len=nums.length;
        k=k%len;
        Reverse(nums,0,nums.length - 1);
        Reverse(nums,0,k- 1);
        Reverse(nums,k,nums.length - 1);
    }
    
    public void Reverse(int[] digit,int begin,int end)
    {
        int tmp;
        for (int i = begin, j = end; i < j; i++, j--) {
            tmp = digit[i];
            digit[i] = digit[j];
            digit[j] = tmp;
        }
    }
    
}