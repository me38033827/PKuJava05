/*
��1����ͬ��������д������ʾ����������Щ������ӵõ��������磺��=3��
 
��2��С�������ڴ�����ֵ��ұߡ�����ʾ����������Щ������ӵõ������� �磺��=8����=12��
 
��3��С�����֡������� ��X �� C���ڴ�����ֵ���ߡ�����ʾ�������ڴ�����С���õ��������磺��=4����=9��
 
��4������ʹ��ʱ����д�������ظ����ó������Ρ��������ϵ��ĵ��ӡ�IIII�����⣩��
 
��5����һ���������滭һ�����ߡ���ʾ��������� 1000 ����
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
                   tmp=newString("I",cur); //newString ���Զ���ĺ���
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