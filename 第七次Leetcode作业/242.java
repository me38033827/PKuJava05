/*Ҫ��
 
���������ַ���s��t��дһ���������ж�t�Ƿ���s�ı�λ�ʡ�
 
���t��s������ͬ�ַ�������˳��ͬ�����t��s�ı�λ�ʡ�
 
���磺
 
s = "anagram", t ="nagaram"������true
 
s = "rat", t = "car"������false
 
ע�⣺���Լٶ��ַ���ֻ����Сд��ĸ��
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