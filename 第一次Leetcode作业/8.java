public class Solution {
   public static int g_nStatus=0;//全局变量，特殊标记，判断是否为非法输入（"","+\-","1a"）1表示非法，0表示合法
   public int myAtoi(String str) {
   g_nStatus=1;//初始化为非法输入
   if (str == null || str.length() < 1)//str=""时，返回0，同时标记为非法输入
		return 0;
	str = str.trim();
	char flag='\0';
	int i = 0;
	if (str.charAt(0) == '-') {
		flag = '-';
		i++;
	} else if (str.charAt(0) == '+') {
	    flag = '+';
		i++;
	}
	double result = 0;
	while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
		result = result * 10 +(int)(str.charAt(i) - '0');
		i++;
	}
 
	if (flag == '-')
		result = -result;
	//判断是否一处溢出
	if (result > Integer.MAX_VALUE)
		return Integer.MAX_VALUE;
 
	if (result < Integer.MIN_VALUE)
		return Integer.MIN_VALUE;
	
	if(flag!='\0'&&str.length()==1)//str="+"或str="-"，返回0，同时标记为非法输入
	   g_nStatus=1;
	else if(str.length()==i)//溢出返回最值，或者出现非数字字符返回0，同时标记为非法输入
	   g_nStatus=0;
 
	return (int) result;
    }
   
}
