public class Solution {
    public List<Integer> getRow(int rowIndex) { List<Integer> CurrentRow = new ArrayList<Integer>();
        List<Integer> ExRow = new ArrayList<Integer>();
        if (rowIndex==0)    
        CurrentRow.add(1);
        if(rowIndex==1)
            {CurrentRow.add(1);
            CurrentRow.add(1);
            }
        int i,j;
        if(rowIndex>=2)
        {   //CurrentRow.add(1);
            ExRow.add(1);
            ExRow.add(1);
            for(i=2;i<rowIndex+1;i++)         //�ӵ����е���rowIndex�й���ÿһ��
            {   CurrentRow.clear();
                CurrentRow.add(1);
                //ExRow.add(1);
                // ExRow.add(1);    
                for(j=1;j<=i-1;j++)
                {   
                    CurrentRow.add(ExRow.get(j-1)+ExRow.get(j));
                    
                }
                CurrentRow.add(1);
                //ExRow=CurrentRow;                  //list����ֱ�Ӹ�ֵ��ֱ�Ӹ�ֵ����ָ�룡��
                ExRow.clear();
                for(j=0;j<=i;j++)
                {
                	ExRow.add(CurrentRow.get(j));
                }
            }
            //CurrentRow.add(1);
        }
        return CurrentRow;
        
    }
}