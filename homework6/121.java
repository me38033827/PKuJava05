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
        int i=0,j=0,max=0;  //max�浱ǰ�������
        for(i=0;i<length-1;i++){           //��ͷ��ʼ�����������������������滻��ǰ�������
            for(j=i+1;j<length;j++){
                if(prices[j]<=prices[i])       //���i֮���и�С��ֵ����ֱ�ӽ�����һ��ѭ������Ϊ��С��ֵ�ͺ�����Ȼ�õ��������
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