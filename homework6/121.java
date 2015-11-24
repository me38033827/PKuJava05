public class Solution {
    public int maxProfit(int[] prices) {
        int length=prices.length;
        if(length==0)
            return 0;
        /*int i,j,min=prices[0],max=prices[0];
       
        for(i=0;i<length;i++){
            if(prices[i]<min)
                min=prices[i];
            if(prices[i]>max)
                max=prices[i];
        }
        return max-min;*/
        int i=0,j=0,max=0;  //max存当前最大收益
        for(i=0;i<length-1;i++){           //从头开始往后遍历，遇到更大收益后替换当前最大收益
            for(j=i+1;j<length;j++){
                if(prices[j]<=prices[i])       //如果i之后有更小的值，则直接进入下一次循环，因为更小的值和后面相比获得的收益更大
                    {//i++;
                        break;
                    }
                else if(prices[j]-prices[i]>max){
                    max=prices[j]-prices[i];
                }
            }
        }/*
        if(j==length-1){
        if(prices[j]-prices[i]>max)
            max=prices[j]-prices[i];}*/
        return max;
    }
}