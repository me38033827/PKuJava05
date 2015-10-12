/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 
For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome. 

Note:
 Have you consider that the string might be empty? This is a good question to ask during an interview.
 
For the purpose of this problem, we define empty string as valid palindrome. 
*/



public class Solution {
    public boolean isPalindrome(String s) {
        if(s==null) return true;
        s=s.replaceAll("\\pP|\\pS", "");
        s=s.replace(" ","");
        s=s.toLowerCase();
        int low=0;
        int high=s.length()-1;
        while(low<high){
            if(s.charAt(low)==s.charAt(high)){
                low++;
                high--;
            }
            else
             return false;
        }
          return true;
    }
}