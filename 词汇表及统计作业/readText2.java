 import java.io.BufferedReader;
 import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;

public class readText2 {
	    public static HashMap<String,Integer> txtString(File file){
		LinkedHashMap<String,Integer> map = new LinkedHashMap<String,Integer>();  
		try{
			 //构造一个BufferedReader类来读取文件
		     BufferedReader br = new BufferedReader(new FileReader(file));
		     String s = null;
		     while((s = br.readLine())!=null){//使用readLine方法，一次读一行
		    	 String[] sAfterSplit;
		    	 sAfterSplit=s.split(" ");
		    	 for(int i=0;i<sAfterSplit.length;i++){
		    		 if(map.containsKey(sAfterSplit[i])){
		    			 int newvalue=map.get(sAfterSplit[i])+1;
		    			 map.put(sAfterSplit[i], newvalue);
		    		 }
		    		 else 
		    			 map.put(sAfterSplit[i], 1);
		    	 }
		     }
		     br.close();    
	         }catch(Exception e){
		        e.printStackTrace();
		     }
	         return map;
		     }
		     
		    public static void main(String[] args){
		         File file1 = new File("D:/test1.txt");
		         File file2 = new File("D:/test2.txt");
		         HashMap<String,Integer> map1 = txtString(file1);
		         HashMap<String,Integer> map2 = txtString(file2);
		         int len1=map1.size();
		         int len2=map2.size();
		         //输出处理前的结果·
		         System.out.println("文件1的词汇表:");
		         System.out.println("word counts");
		         for( Iterator<Entry<String, Integer>> iter1=map1.entrySet().iterator();iter1.hasNext();)
		         {
		          Map.Entry entry = ( Map.Entry)iter1.next();
		          System.out.println(entry.getKey()+"    "+entry.getValue());
		         }
		         System.out.println("文件2的词汇表:");
		         System.out.println("word counts");
		         for( Iterator<Entry<String, Integer>> iter2=map2.entrySet().iterator();iter2.hasNext();)
		         {
		          Map.Entry entry = ( Map.Entry)iter2.next();
		          System.out.println(entry.getKey()+"    "+entry.getValue());
		         }
		     
		         //处理合并
		         Iterator<Entry<String, Integer>> iter=map2.entrySet().iterator();
		         while(iter.hasNext()){
		        	 Map.Entry entry = ( Map.Entry)iter.next();
		        	 String key=(String) entry.getKey();
		        	 int value=(Integer) entry.getValue();
		        	 if(!map1.containsKey(key)){
		        	     map1.put(key, value);
		        	     map2.remove(key);
		        	 }	 
		         }
		         //输出处理后的结果
		         System.out.println("两个文件总共的词汇表:");
		         for(Iterator<Entry<String, Integer>> iter1=map1.entrySet().iterator();iter1.hasNext();)
		         {
		        	 Map.Entry entry =( Map.Entry) iter1.next();
			         System.out.print(entry.getKey()+" ");
		         }
		         System.out.println();
		         System.out.println("同时出现在两个文件中的交集单词词汇表:");
		         for( Iterator<Entry<String, Integer>> iter2=map2.entrySet().iterator();iter2.hasNext();)
		         {
		        	 Map.Entry entry = ( Map.Entry)iter2.next();
			         System.out.print(entry.getKey()+" ");
		         }
		         System.out.println();
		         System.out.println("文件1的词汇表中包含单词总数："+len1);
		         System.out.println("文件2的词汇表中包含单词总数："+len2);
		         System.out.println("属于文件1且不属于文件2的单词占文件1的百分比："+(1-(double)map2.size()/len1));
		         System.out.println("属于文件2且不属于文件1的单词占文件2的百分比："+(1-(double)map2.size()/len2));
		         
		         
		    }
}
