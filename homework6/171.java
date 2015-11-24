public class Solution {
    public int titleToNumber(String s) {
        int i,length,res=0,temp;
        length=s.length();
        char [] sArray = s.toCharArray();
        for(i=length-1;i>=0;i--){        
            //res=res+(sArray[i]-'A'+1))*26*i;
            temp=sArray[i]-'A'+1;
            //res=res+Math.pow(26,length-1-i)*temp;
            res=res+(int)Math.pow(26,length-1-i)*temp;
        }
        return res;
    }
}