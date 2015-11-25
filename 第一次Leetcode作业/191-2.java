public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        /*// 负数会引起死循环
        int count=0;
        while(n!=0){
            if((n&1)!=0) count++;
            n=n>>1;
        }
        return count;*/
        
        /* //32位整数需要循环32次
        int flag=1;
        int count=0;
        while(n!=0){
            if((n&flag)!=0) count++;
        flag=flag<<1;
        }
        return count;
        */
        
        int count=0;
        while(n!=0){
            count++;
            n=n&(n-1);
        }
        return count;
    }
}