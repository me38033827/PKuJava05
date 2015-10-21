public class Solution {
    public List<List<Integer>> generate(int numRows) {
         List<List<Integer>> PaTr = new ArrayList<List<Integer>> ();        
         List<Integer> row1 = new ArrayList<Integer>();        
         row1.add(1);        
         List<Integer> row2 = new ArrayList<Integer>();        
         row2.add(1);         
         row2.add(1);		
         if(numRows == 1)		//设置第一行	
            PaTr.add(row1);		
         if(numRows == 2)       //设置前两行
         {			
            PaTr.add(row1);			
            PaTr.add(row2);		
         }		
         if(numRows > 2)
         {  
             PaTr.add(row1); 
             PaTr.add(row2);          //设置前两行
             int i,j;
//           for(i=3;i<=numRows;i++)
             for(i=2;i<=numRows-1;i++)     //设置3至numRows行
             {
                 List<Integer> HeadRow=PaTr.get(i-1);
//               List<Integer> CurrentRow=new ArraryList<Integer>();   %把arraylist写成arrarylist
                 List<Integer> CurrentRow=new ArrayList<Integer>();
                 CurrentRow.add(1);       //第一列置1
//                 for(j=1;j<i-1;j++)
 //                {
 //                   CurrentRow.add(HeadRow.get(j-1)+HeadRow.get(j));
 //                }
                  for(j=1;j<=i-1;j++) 
                    CurrentRow.add(HeadRow.get(j-1)+HeadRow.get(j));   //中间列的置为前一行前一列的值+前一行当前列的值
                 CurrentRow.add(1);        //最后一列置1
                 PaTr.add(CurrentRow);
             }
             
             
         }		return PaTr; 
        
    }
}