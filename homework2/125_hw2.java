public class Solution {
    public boolean isPalindrome(String s) {
        char temp;      //��ŵ�����ĸ������
		s=s.toLowerCase();    //����д��ĸת����Сд
		StringBuilder reverse=new StringBuilder();
		for(int i=s.length();i>0;i--)      //ȥ�������ַ���ֻ������ĸ������
		{
			temp=s.charAt(i-1);
			if((temp>='a'&&temp<='z')||(temp>='0'&&temp<='9'))
			{
				
				reverse.append(temp);
			}
		}
		for(int i=0;i<((reverse.length())/2);i++)     //��ͷβ���αȽ�
		{
			if(reverse.charAt(i)!=reverse.charAt(reverse.length()-i-1))
				return false;
		}
		return true;
    }
}