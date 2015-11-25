public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result=new ArrayList<Integer>();
        rowIndex++;
        if(rowIndex<=0) return result;
        result.add(1);
        List<Integer> prev=new ArrayList<Integer>();
        prev=result;
        for(int i=2;i<=rowIndex;i++){
            result=new ArrayList<Integer>();
            result.add(1);
            for(int j=0;j<i-2;j++){
                result.add(prev.get(j)+prev.get(j+1));
            }
            result.add(1);
            prev=result;
        }
        return result;
    }
}