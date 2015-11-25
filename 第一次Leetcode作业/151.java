public class Solution {
    public String reverseWords(String s) {
    s=s.trim();
    s=s.replaceAll("\\s{1,}"," ");
    if(s==null||s.length()==0)
         return s;
    if(s.lastIndexOf(' ')==-1) //只有一个单词，不用翻转
       return s;
       
      //翻转整个句子
       s=Reverse(s,0,s.length()-1);
      
      //翻转句子中的每个单词
      int start=0;
      int end=0;
      s=s+" ";
      while(end<=s.length()-1){
          if(s.charAt(start)==' '){
              start++;
              end++;
          }
          else if(s.charAt(end)==' '){ //碰到空格，开始反转之前的单词，重置start和end
               s=Reverse(s,start,--end);
               start=++end;
          }
          else{
              end++;
          }
      }//end while
      return s.trim();
    }
    
    public String Reverse(String s,int start,int end){
     if(s==null||s.length()==0)
         return s;
     char[] s1=s.toCharArray();
     if(start<s.length()&&end<s.length()){
     while(start<end){
          char temp=s1[start];
          s1[start]=s1[end];
          s1[end]=temp;
          start++;
          end--;
     }//end while
     }
    return new String(s1);
    }
}
    