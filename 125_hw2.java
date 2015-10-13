public class Solution {
    public boolean isPalindrome(String s) {
        char temp;      //存放单个字母或数字
		s=s.toLowerCase();    //将大写字母转化成小写
		StringBuilder reverse=new StringBuilder();
		for(int i=s.length();i>0;i--)      //去掉特殊字符，只留下字母和数字
		{
			temp=s.charAt(i-1);
			if((temp>='a'&&temp<='z')||(temp>='0'&&temp<='9'))
			{
				
				reverse.append(temp);
			}
		}
		for(int i=0;i<((reverse.length())/2);i++)     //将头尾依次比较
		{
			if(reverse.charAt(i)!=reverse.charAt(reverse.length()-i-1))
				return false;
		}
		return true;
    }
}