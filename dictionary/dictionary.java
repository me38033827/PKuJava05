package dictionary;

import java.io.File;
import java.io.FileReader;
import java.util.*;
public class dictionary {

	public static void main(String[] args) {
		//System.out.println(System.getProperty("user.dir"));
		File file1=new File("file1.txt");          //读取两个文本文件
		File file2=new File("file2.txt");
		if(!file1.exists()||!file2.exists()){            //判断文件是否存在
			System.out.println("文件不存在");
		}
		try{                                        //读取错误抛出异常
			FileReader in1=new FileReader(file1);        
			FileReader in2=new FileReader(file2);
			char byt1[]=new char[1024];
			char byt2[]=new char[1024];
			int len1=in1.read(byt1);        //FileReader的read方法不支持string，只支持char[]
			int len2=in2.read(byt2);
			String s1=new String(byt1,0,len1);    //将char[]转换成string
			String s2=new String(byt2,0,len2);
			in1.close();
			in2.close();
			//去掉标点符号
			s1 = s1.replaceAll("\"","");
			s2 = s2.replaceAll("\"","");
			s1 = s1.replaceAll(", ",",");
			s2 = s2.replaceAll(", ",",");
			s1 = s1.replaceAll("\\. ",",");
			s2 = s2.replaceAll("\\. ",",");
			s1 = s1.replaceAll("; ",",");
			s2 = s2.replaceAll("; ",",");
			s1 = s1.replaceAll(": ",",");
			s2 = s2.replaceAll(": ",",");
			s1 = s1.replaceAll("\\? ",",");
			s2 = s2.replaceAll("\\? ",",");
			s1 = s1.replaceAll("\\.\"",",");
			s2 = s2.replaceAll("\\.\"",",");
			s1 = s1.replaceAll("\\.\r\n",",");
			s2 = s2.replaceAll("\\.\r\n",",");
			String[] ary1 = s1.split(" |,|\\?|\\.|\"|—|;|:");//ary1保存file1的词汇
			String[] ary2 = s2.split(" |,|\\?|\\.|\"|—|;|:");//ary2保存file2的词汇
			TreeSet<String> set1=new TreeSet<String>();     //set1存放不重复的单词
			for(String item1: ary1){
				set1.add(item1);
			}
			for(String item2: ary2){
				set1.add(item2);
			}
			Iterator<String> it=set1.iterator();   //获取单词集合
			System.out.println("两个文件的词汇表为：");
			while(it.hasNext()){
				String str=(String)it.next();
				System.out.println(str);
			}
			System.out.println("**********************");
			System.out.println("同时出现在两个文件中的词汇表为：");
			TreeSet<String> set2=new TreeSet<String>();   //set2存放file1中不重复的单词
			TreeSet<String> set3=new TreeSet<String>();	   //set3存放file2中不重复的单词
			for(String item1: ary1){
				set2.add(item1);
			}
			for(String item2: ary2){
				set3.add(item2);
			}
			it=set2.iterator();
			while(it.hasNext()){
				String str=(String)it.next();         
				if(set3.contains(str)){              //将set3中的单词依次与set2比较，如果set2中存在，则输出单词
					System.out.println(str);
				}
			}
			System.out.println("**********************");
			List<String> list1=new ArrayList<String>();   //list1存放可以重复的file1的单词
			List<String> list2=new ArrayList<String>();   //list2存放可以重复的file2的单词
			for(String item1: ary1){
				list1.add(item1);
			}
			for(String item2: ary2){
				list2.add(item2);
			}
			System.out.println("文件1中的单词总数为：");
			System.out.println(list1.size());
			System.out.println("文件2中的单词总数为：");
			System.out.println(list2.size());
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
