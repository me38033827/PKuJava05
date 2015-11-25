求第index个丑数


public class Solution {
    
    public int getUglyNum(int index) {
      List<Integer> ugly=new ArrayList<Integer>(); 
      ugly.add(0);
      int nextUglyIndex=1;
      while(nextUglyIndex<index){
         int ugly2=2;
         int ugly3=3;
         int ugly5=5;
         for(int i=0;i<ugly.size();i++){
            while(ugly.get(i)*2>ugly.back()){
               ugly2=ugly.get(i)*2;
            }
            while(ugly.get(i)*3>ugly.back()){
               ugly3=ugly.get(i)*3;
            }
            while(ugly.get(i)*5>ugly.back()){
               ugly5=ugly.get(i)*5;
            }
         }//end for
         ugly.add(min(ugly2,ugly3,ugly5));
         nextUglyIndex++;
      }
      return ugly.back();
    }
      
}