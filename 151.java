public class Solution {
    public String reverseWords(String s) {
        int begin=0,end=0;                 //begin��end�ֱ�Ϊÿ�����ʵĿ�ͷ�ͽ�β��λ��
        StringBuilder Reverse = new StringBuilder("");  
        while(begin<s.length()&&end<s.length()) 
        {  
            while(begin<s.length()&&s.charAt(begin)==' ')        //�ҵ���һ�����ʵĿ�ͷ
            {  
                begin++;  
            }  
            if(begin==s.length()) 
            {  
                break;  
            }  
            end = begin + 1;  
            while(end<s.length()&&s.charAt(end)!=' ')          //�ҵ���ǰbegin�Ľ�βλ�� 
            {  
                end++;  
            }  
            if(Reverse.length()!=0) 
            {  
                Reverse.insert(0," ");  
            }  
            if(end<s.length())                             //���������β嵽����Ŀ�ͷ
            {  
                Reverse.insert(0,s.substring(begin,end));  
            }
            else
            {  
                Reverse.insert(0,s.substring(begin,s.length()));  
                break;  
            }  
            begin = end + 1;  
        }  
        return Reverse.toString();  
        
    }
}