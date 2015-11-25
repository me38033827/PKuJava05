/*上界2147483647-, 下界2147483648. 反过来看7463847412 ->  2147483647,  -8463847412 -> -2147483648
 
为使反转不越界，那么绝对值大于10^9的参数x的前9位应满足<=463847412. 我们没有考虑最高位，是因为最高位一定<=2, 从而<=7或8
 
所以反转前先检查是否将溢出，溢出时返回-1; 反之开始反转。
*/


//处理溢出

public class Solution {
     public boolean overflow(int x) {  
        if (x / 1000000000 == 0) // x的绝对值小于1000000000, 不越界  
        {  
            return false;  
        } 
        else if (x == Integer.MIN_VALUE) // INT_MIN反转后越界，也没法按下述方法取绝对值（需要特判），直接返回true  
        {  
            return true;  
        }   
        if(x<0) x=-x;
        // x = d463847412 ->  2147483647. (参数x，本身没有越界，所以d肯定是1或2)  
        // or -d463847412 -> -2147483648.   
        for (int cmp = 463847412; cmp != 0; cmp/=10, x/=10)  
        {  
            if ( x%10 > cmp%10 )  
            {  
                return true;  
            } else if (x%10 < cmp%10)  
            {  
                return false;  
            }  
        }  
        return false;  
        }  
        
        
    public int reverse(int x) {
        int result=0;
        //int flag=1;
        if(overflow(x)) return 0;
        //if((x>Integer.MAX_VALUE)||(x<Integer.MIN_VALUE)) return 0;
        /*if(x<0){
            x=-x;
            flag=-1;
        }*/
        
        while(x!=0){
            result=result*10+x%10;
            if((result>Integer.MAX_VALUE)||(result<Integer.MIN_VALUE)) return 0;
            x/=10;
        }
        //return flag*result;
        return result;
    }
    
}