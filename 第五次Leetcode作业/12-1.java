/*
��1����ͬ��������д������ʾ����������Щ������ӵõ��������磺��=3��
 
��2��С�������ڴ�����ֵ��ұߡ�����ʾ����������Щ������ӵõ������� �磺��=8����=12��
 
��3��С�����֡������� ��X �� C���ڴ�����ֵ���ߡ�����ʾ�������ڴ�����С���õ��������磺��=4����=9��
 
��4������ʹ��ʱ����д�������ظ����ó������Ρ��������ϵ��ĵ��ӡ�IIII�����⣩��
 
��5����һ���������滭һ�����ߡ���ʾ��������� 1000 ����
*/

public class Solution {
    public String intToRoman(int num) {
    HashMap<Integer,String> map = new HashMap<Integer,String>(); 
        map.put(1,"I");
        map.put(5,"V");
        map.put(10,"X");
        map.put(50,"L");
        map.put(100,"C");
        map.put(500,"D");
        map.put(1000,"M");

      String result="";
      int k=1;
      while(num!=0){
          String tmp="";
          int cur=(num%10);
        
              if(cur<=3){
                   tmp=newString(map.get(k),cur);//newString ���Զ���ĺ���
              }
              else if(cur==4){
                   tmp=new String(map.get(k)+map.get(k*5));
              }else if(cur==5){
                   tmp=new String(map.get(k*5));
              }
              else if(cur==9){
                   tmp=new String(map.get(k)+map.get(k*10));
              }
              else{
                   tmp=map.get(k*5)+newString(map.get(k),cur-5);
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