/*
Best Time to Buy and Sell Stock

Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
*/

public class Solution {
    public int maxProfit(int[] prices) {//·ÖÖÎ·¨
        if(prices==null|| prices.length==0||prices.length==1) return 0;
        int n=prices.length;
        int size=n/2;
        int[] low=new int[size];
        int[] high=new int[n-size];
        int lindex=0,hindex=0;
        for(int i=0;i<n;i++){
            if(i<n/2)
              low[lindex++]=prices[i];
            else
              high[hindex++]=prices[i];
        }
        int lowresult=maxProfit(low);
        int highresult=maxProfit(high);
        int result1=lowresult>highresult?lowresult:highresult;
        int result2=maxArray(high)-minArray(low);
        int result=result1>result2?result1:result2;
        return result;
        
    }
    
    public int maxArray(int nums[]){
        if(nums==null||nums.length == 0) return -1;
        int result=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>result)
             result=nums[i];
        }
        return result;
    }
    public int minArray(int nums[]){
        if(nums==null||nums.length == 0) return -1;
        int result=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<result)
             result=nums[i];
        }
        return result;
    }
     
}