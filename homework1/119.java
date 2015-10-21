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
            for(i=2;i<rowIndex+1;i++)         //从第三行到第rowIndex行构造每一行
            {   CurrentRow.clear();
                CurrentRow.add(1);
                //ExRow.add(1);
                // ExRow.add(1);    
                for(j=1;j<=i-1;j++)
                {   
                    CurrentRow.add(ExRow.get(j-1)+ExRow.get(j));
                    
                }
                CurrentRow.add(1);
                //ExRow=CurrentRow;                  //list不能直接赋值，直接赋值的是指针！！
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