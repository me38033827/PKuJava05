public class Solution {
    public List<List<Integer>> generate(int numRows) {
         List<List<Integer>> PaTr = new ArrayList<List<Integer>> ();        
         List<Integer> row1 = new ArrayList<Integer>();        
         row1.add(1);        
         List<Integer> row2 = new ArrayList<Integer>();        
         row2.add(1);         
         row2.add(1);		
         if(numRows == 1)		//���õ�һ��	
            PaTr.add(row1);		
         if(numRows == 2)       //����ǰ����
         {			
            PaTr.add(row1);			
            PaTr.add(row2);		
         }		
         if(numRows > 2)
         {  
             PaTr.add(row1); 
             PaTr.add(row2);          //����ǰ����
             int i,j;
//           for(i=3;i<=numRows;i++)
             for(i=2;i<=numRows-1;i++)     //����3��numRows��
             {
                 List<Integer> HeadRow=PaTr.get(i-1);
//               List<Integer> CurrentRow=new ArraryList<Integer>();   %��arraylistд��arrarylist
                 List<Integer> CurrentRow=new ArrayList<Integer>();
                 CurrentRow.add(1);       //��һ����1
//                 for(j=1;j<i-1;j++)
 //                {
 //                   CurrentRow.add(HeadRow.get(j-1)+HeadRow.get(j));
 //                }
                  for(j=1;j<=i-1;j++) 
                    CurrentRow.add(HeadRow.get(j-1)+HeadRow.get(j));   //�м��е���Ϊǰһ��ǰһ�е�ֵ+ǰһ�е�ǰ�е�ֵ
                 CurrentRow.add(1);        //���һ����1
                 PaTr.add(CurrentRow);
             }
             
             
         }		return PaTr; 
        
    }
}