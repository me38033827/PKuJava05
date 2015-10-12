/*�Ͻ�2147483647-, �½�2147483648. ��������7463847412 ->  2147483647,  -8463847412 -> -2147483648
 
Ϊʹ��ת��Խ�磬��ô����ֵ����10^9�Ĳ���x��ǰ9λӦ����<=463847412. ����û�п������λ������Ϊ���λһ��<=2, �Ӷ�<=7��8
 
���Է�תǰ�ȼ���Ƿ���������ʱ����-1; ��֮��ʼ��ת��
*/


//�������

public class Solution {
     public boolean overflow(int x) {  
        if (x / 1000000000 == 0) // x�ľ���ֵС��1000000000, ��Խ��  
        {  
            return false;  
        } 
        else if (x == Integer.MIN_VALUE) // INT_MIN��ת��Խ�磬Ҳû������������ȡ����ֵ����Ҫ���У���ֱ�ӷ���true  
        {  
            return true;  
        }   
        if(x<0) x=-x;
        // x = d463847412 ->  2147483647. (����x������û��Խ�磬����d�϶���1��2)  
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