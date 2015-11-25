//Given a string s consists of upper/lower-case alphabets and empty //space characters ¡¯ ¡®, return the length of last word in the string.
//If the last word does not exist, return 0.
//Note: A word is defined as a character sequence consists of non-space characters only.
//For example,
//Given s = ¡°Hello World¡±,
//return 5.


class Solution {    
public int lengthOfLastWord(const String s) {

int lenth=0;
if(s==null) return lenth;

for(int i=s.size()-1;i>=0;i++){
lenth++
if(s[i]='') break;

}// end for

return lenth;

}

}  



import java.util.*;
public class Solution {
    public int lengthOfLastWord(String s) {
        
          if(s==""||s.length()==0) {
              return 0;
          }
          /* int length=0;
          for(int i=s.length()-1;i>=0;i++){
              if(s.charAt(i)==' ')  break;
              ++length;
          }// end for
          */
         s=s.trim();
         if(s.lastIndexOf(' ')==-1){ 
              return s.length();
         }else {
              return s.length()-1-s.lastIndexOf(" ");
         }
    }
   
}