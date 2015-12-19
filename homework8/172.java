public class Solution {
    public int trailingZeroes(int n) {
        /*int count=0;
        if(n==0)
            return 0;
        while(n%10==0){
            n=n/10;
            count++;
        }
        return count;*/
        int count=0;
        if(n==0)
        return 0;
        /*while((n-5)>0){
            n-=5;
            count++;
        }*/
        //分别统计n的阶乘中5的个数，25的个数，125的个数……
        while(n/5!=0){
            count+=n/5;
            n/=5;
        }
        return count;
    }
}