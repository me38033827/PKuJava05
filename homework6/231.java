public class Solution {
    public boolean isPowerOfTwo(int n) {
        //float temp;             //float会出错。。（float）16777217%2.0=0.0
        double temp;
        boolean flag=false;
        temp=(double)n;
        if(n==1)                   //1也是2的power（0）
            return true;
        if(temp%2.0!=0){
            return false;
        }else{
            while(temp>2){
                temp=temp/2;
            }
            if(temp==2)
                flag=true;
            else
                flag=false;
            
        }
        return flag;
    }
}