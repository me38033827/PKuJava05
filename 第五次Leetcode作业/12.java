/*
（1）相同的数字连写、所表示的数等于这些数字相加得到的数、如：Ⅲ=3；
 
（2）小的数字在大的数字的右边、所表示的数等于这些数字相加得到的数、 如：Ⅷ=8、Ⅻ=12；
 
（3）小的数字、（限于 Ⅰ、X 和 C）在大的数字的左边、所表示的数等于大数减小数得到的数、如：Ⅳ=4、Ⅸ=9；
 
（4）正常使用时、连写的数字重复不得超过三次。（表盘上的四点钟“IIII”例外）；
 
（5）在一个数的上面画一条横线、表示这个数扩大 1000 倍。
*/

public class Solution {
    public String intToRoman(int num) {
      String result="";
      int k=1;
      while(num!=0){
          String tmp="";
          int cur=(num%10);
          if(k==1){
              if(cur<=3){
                   tmp=newString("I",cur); //newString 是自定义的函数
              }
              else if(cur==4){
                   tmp=new String("IV");
              }else if(cur==5){
                   tmp=new String("V");
              }
              else if(cur==9){
                   tmp=new String("IX");
              }
              else{
                   tmp="V"+newString("I",cur-5);
              }
          }
          if(k==10){
              if(cur<=3){
                   tmp=newString("X",cur);
              }
              else if(cur==4){
                   tmp=new String("XL");
              }else if(cur==5){
                   tmp=new String("L");
              }
              else if(cur==9){
                   tmp=new String("XC");
              }
              else{
                   tmp="L"+newString("X",cur-5);
              }
          }
           if(k==100){
              if(cur<=3){
                   tmp=newString("C",cur);
              }
              else if(cur==4){
                   tmp=new String("CD");
              }else if(cur==5){
                   tmp=new String("D");
              }
              else if(cur==9){
                   tmp=new String("CM");
              }
              else{
                   tmp="D"+newString("C",cur-5);
              }
          }
          if(k==1000){
              if(cur<=3){
                   tmp=newString("M",cur);
              }
          }
          result=tmp+result;
          num=num/10;
          k=k*10;
      }
      return result;
    }
    
    public String newString(String s,int n){
        String result="";
        if(s==null||n<0) return result;
        for(int i=0;i<n;i++){
            result+=s;
        }
        return result;
    }
}