 import java.io.BufferedReader;
 import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class readText {
	    public static HashSet<String> txtString(File file){
		LinkedHashSet<String> set = new LinkedHashSet<String>();  
		try{
			 //构造一个BufferedReader类来读取文件
		     BufferedReader br = new BufferedReader(new FileReader(file));
		     String s = null;
		     while((s = br.readLine())!=null){//使用readLine方法，一次读一行
		    	 String[] sAfterSplit;
		    	 sAfterSplit=s.split(" ");
		    	 for(int i=0;i<sAfterSplit.length;i++)
                     set.add(sAfterSplit[i]);
		     }
		     br.close();    
	         }catch(Exception e){
		        e.printStackTrace();
		     }
	         return set;
		     }
		     
		    public static void main(String[] args){
		         File file1 = new File("D:/test1.txt");
		         File file2 = new File("D:/test2.txt");
		         HashSet<String> set1 = txtString(file1);
		         HashSet<String> set2 = txtString(file2);
		         int len1=set1.size();
		         int len2=set2.size();
		         //输出处理前的结果·
		         System.out.println("文件1的词汇表:");
		         for(Iterator<String> iter1=set1.iterator();iter1.hasNext();)
		         {
		          System.out.print(iter1.next()+" ");
		         }
		         System.out.println();
		         System.out.println("文件2的词汇表:");
		         for(Iterator<String> iter2=set2.iterator();iter2.hasNext();)
		         {
		          System.out.print(iter2.next()+" ");
		         }
		         System.out.println();
		         //处理合并
		         Iterator<String> iter=set2.iterator();
		         while(iter.hasNext()){
		        	 String item=iter.next();
		        	 if(!set1.contains(item)){
		        	     set1.add(item);
		        	     set2.remove(item);
		        	 }	 
		         }
		         //输入处理后的结果
		         System.out.println("两个文件总共的词汇表:");
		         for(Iterator<String> iter1=set1.iterator();iter1.hasNext();)
		         {
		          System.out.print(iter1.next()+" ");
		         }
		         System.out.println();
		         System.out.println("同时出现在两个文件中的交集单词词汇表:");
		         for(Iterator<String> iter2=set2.iterator();iter2.hasNext();)
		         {
		          System.out.print(iter2.next()+" ");
		         }
		         System.out.println();
		         System.out.println("第一个文件的词汇表中包含单词总数："+len1);
		         System.out.println("第二个文件的词汇表中包含单词总数："+len2);
		         
		    }
}
