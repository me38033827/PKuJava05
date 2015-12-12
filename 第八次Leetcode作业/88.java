/*Merge Sorted Array
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
*/

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int count=m+n-1;
        m--;
        n--;
        while(m>=0&&n>=0){
            nums1[count--]=nums1[m]>nums2[n]?nums1[m--]:nums2[n--];
        }
        while(n>=0){
            nums1[count--]=nums2[n--];
        }
           
    }
}