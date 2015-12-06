/*要求：
 
给定两个字符串s和t，写一个函数，判断t是否是s的变位词。
 
如果t跟s包含相同字符但排列顺序不同，则称t是s的变位词。
 
例如：
 
s = "anagram", t ="nagaram"，返回true
 
s = "rat", t = "car"，返回false
 
注意：可以假定字符串只包含小写字母。
*/

public class Solution {
    public boolean isAnagram(String s, String t) {
        char[] schar=s.toCharArray();
        char[] tchar=t.toCharArray();
        Arrays.sort(schar);
        Arrays.sort(tchar);
        if(String.valueOf(schar).equals(String.valueOf(tchar)))
        return true;
        else
        return false;
    }
}