

//Add Binary
 
//Given two binary strings, return their sum (also a binary string).
 
//For example,
//a = "11"
//b = "1"
//Return "100".


//java

public class Solution {
    public String addBinary(String a, String b) {//先进行对齐操作，然后从右往左逐位相加，注意进位即可。
       int firstSize=a.length();
       int secondSize=b.length();
       if(firstSize<secondSize)
           return addBinary(b,a);
       if(a==""||a=="0")                     
           return b;
       if(b==""||b=="0") 
           return a;
           
       String zeros="";
       for(int i=0;i<firstSize-secondSize;i++)
          zeros="0"+zeros;
       b=zeros+b;
       
       char[] firstNum=a.toCharArray();
       char[] secondNum=b.toCharArray();
       int ans=0;//进位
     
       for(int i=firstSize-1;i>=0;i--){//sum between 0 and 3
           int sum=(int)(firstNum[i]-'0')+(int)(secondNum[i]-'0')+ans;
           if(sum==0) 
             ;
           else if(sum==1){
             firstNum[i]='1';
             ans=0;
           }
           else if(sum==2){
             firstNum[i]='0';
             ans=1;
           }
           else{//sum==3
             firstNum[i]='1';
             ans=1;
           }    
       }//end for
       a= String.valueOf(firstNum);
       if(ans==1)
           a="1"+a;  
       return a;
    }
}