public class Solution {
    public boolean isHappy(int n) {
        int temp=n,sum=0;
        int i=0,j=0;
        int[] a=new int[1000];
        a[i]=n;//����Ѿ����ֵ�ƽ����
        if(n==1)
            return true;
        while(true)
        {   sum=0;
            while(temp!=0)  //��ÿλ����ƽ����
            {
                sum=sum+(temp%10)*(temp%10);
                temp=temp/10;
            }
            if(sum==1)
                return true;
            temp=sum;     
            for(j=0;j<=i;j++)
            {
                if(sum==a[j])
                return false;
            }
            i++;
            a[i]=sum;
           //sum=0    %sum=0��������ᵼ����ѭ��
           
        }
            
    }
}