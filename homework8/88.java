public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i,j,temp;
        for(i=0;i<n;i++)  //ºÏ²¢
        {
            nums1[m+i]=nums2[i];
        }
        for(i=0;i<m+n;i++)  //ÅÅÐò
        {
            for(j=0;j<m+n-i-1;j++)
            {
                if(nums1[j+1]<nums1[j])
                {
                    temp=nums1[j+1];
                    nums1[j+1]=nums1[j];
                    nums1[j]=temp;
                }
            }    
        }
    }
}