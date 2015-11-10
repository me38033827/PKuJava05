public class Solution {
    public int romanToInt(String s) {
        //I:1,V:5,X:10,L:50,C:100,D:500,M:1000
        //��λ���ǣ������V��5����L��50����D��500����M��1000����ֱ�Ӽ���Ӧ��ֵ�������I��1����X��10����C��100����Ҫ����������Ƿ���5x����10X���������ͼ�ȥ��Ӧ��ֵ�����û���������Ӧ��ֵ
        int length,i,j,k,res=0;
        length=s.length();
        char[] roman=s.toCharArray();
        for(i=0;i<length;i++){       //��λ����
            if(roman[i]=='D')      //�����D��500������ֱ�Ӽ�500��      
                res+=500;
            if(roman[i]=='L')        //�����L��50������ֱ�Ӽ�50��   
                res+=50;
            if(roman[i]=='V')        //�����V��5������ֱ�Ӽ�5��   
                res+=5;
            if(roman[i]=='M')        //�����M��1000������ֱ�Ӽ�1000��      
                res+=1000;
            if(roman[i]=='I')        //�����I��1��������������
            {
                j=s.indexOf('V',i+1);
                k=s.indexOf('X',i+1);
                if(j==-1&&k==-1){     //�������û��V��5������X��10�������1
                    res+=1;
                }else{                  //���������V��5������X��10�������1
                    res-=1;
                }
                
            }
            if(roman[i]=='X')           //ͬI
            {
                j=s.indexOf('L',i+1);
                k=s.indexOf('C',i+1);
                if(j==-1&&k==-1){
                    res+=10;
                }else{
                    res-=10;
                }
                
            }
            if(roman[i]=='C')        //ͬI
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