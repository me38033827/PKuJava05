public class Solution {
    public String reverseWords(String s) {
        int begin=0,end=0;                 //begin和end分别为每个单词的开头和结尾的位置
        StringBuilder Reverse = new StringBuilder("");  
        while(begin<s.length()&&end<s.length()) 
        {  
            while(begin<s.length()&&s.charAt(begin)==' ')        //找到下一个单词的开头
            {  
                begin++;  
            }  
            if(begin==s.length()) 
            {  
                break;  
            }  
            end = begin + 1;  
            while(end<s.length()&&s.charAt(end)!=' ')          //找到当前begin的结尾位置 
            {  
                end++;  
            }  
            if(Reverse.length()!=0) 
            {  
                Reverse.insert(0," ");  
            }  
            if(end<s.length())                             //将单词依次插到结果的开头
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