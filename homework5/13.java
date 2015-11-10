public class Solution {
    public int romanToInt(String s) {
        //I:1,V:5,X:10,L:50,C:100,D:500,M:1000
        //按位考虑，如果是V（5），L（50），D（500），M（1000）则直接加相应的值，如果是I（1），X（10），C（100）则要考虑其后面是否有5x或者10X，如果有则就减去相应的值，如果没有则加上相应的值
        int length,i,j,k,res=0;
        length=s.length();
        char[] roman=s.toCharArray();
        for(i=0;i<length;i++){       //按位考虑
            if(roman[i]=='D')      //如果是D（500），则直接加500；      
                res+=500;
            if(roman[i]=='L')        //如果是L（50），则直接加50；   
                res+=50;
            if(roman[i]=='V')        //如果是V（5），则直接加5；   
                res+=5;
            if(roman[i]=='M')        //如果是M（1000），则直接加1000；      
                res+=1000;
            if(roman[i]=='I')        //如果是I（1），则分情况考虑
            {
                j=s.indexOf('V',i+1);
                k=s.indexOf('X',i+1);
                if(j==-1&&k==-1){     //如果后面没有V（5）或者X（10），则加1
                    res+=1;
                }else{                  //如果后面有V（5）或者X（10），则减1
                    res-=1;
                }
                
            }
            if(roman[i]=='X')           //同I
            {
                j=s.indexOf('L',i+1);
                k=s.indexOf('C',i+1);
                if(j==-1&&k==-1){
                    res+=10;
                }else{
                    res-=10;
                }
                
            }
            if(roman[i]=='C')        //同I
            {
                j=s.indexOf('D',i+1);
                k=s.indexOf('M',i+1);
                if(j==-1&&k==-1){
                    res+=100;
                }else{
                    res-=100;
                }
                
            }
           
        }
     
        return res;
    }
}