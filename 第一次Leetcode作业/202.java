public class Solution {
    public boolean isHappy(int n) {
    //所有不快乐数的数位平方和计算，最後都会进入 4 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4 的循环中。
    int[] Unhappy={4,16,37,58,89,145,42,20};
    //在十进位下，100以内的快乐数有：1, 7, 10, 13, 19, 23, 28, 31, 32, 44, 49, 68, 70, 79, 82, 86, 91, 94, 97, 100。
    int[] Happy={1, 7, 10, 13, 19, 23, 28, 31, 32, 44, 49, 68, 70, 79, 82, 86, 91, 94, 97, 100};
    
    if(InArray(Happy,n)) return true; //如果n在100以内定义好的快乐数组中，直接返回true
   
    boolean flag=false;
    while(n!=1){
      if(InArray(Unhappy,n)) break; //进入不快乐数的死循环数组，直接跳出循环，返回false
      n=sumOfSquares(n);
     }
     if(n==1) flag=true;
     return flag;
    }

    public int sumOfSquares(int n) //求n的各位数的平方和
    {
        int result = 0;
        while(n!=0)
        {
            int digit = n%10; //最右侧数字
            n /= 10;
            result += (digit*digit);
        }
        return result;
    }
    
    public boolean InArray(int a[],int n){ //判断n是否在数组中
        boolean flag=false;
        for(int i=0;i<a.length;i++){
            if(n==a[i]) {
                flag=true;
                break;
            }
        }
        return flag;
    }
}