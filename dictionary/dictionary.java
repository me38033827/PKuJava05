package dictionary;

import java.io.File;
import java.io.FileReader;
import java.util.*;
public class dictionary {

	public static void main(String[] args) {
		//System.out.println(System.getProperty("user.dir"));
		File file1=new File("file1.txt");          //��ȡ�����ı��ļ�
		File file2=new File("file2.txt");
		if(!file1.exists()||!file2.exists()){            //�ж��ļ��Ƿ����
			System.out.println("�ļ�������");
		}
		try{                                        //��ȡ�����׳��쳣
			FileReader in1=new FileReader(file1);        
			FileReader in2=new FileReader(file2);
			char byt1[]=new char[1024];
			char byt2[]=new char[1024];
			int len1=in1.read(byt1);        //FileReader��read������֧��string��ֻ֧��char[]
			int len2=in2.read(byt2);
			String s1=new String(byt1,0,len1);    //��char[]ת����string
			String s2=new String(byt2,0,len2);
			in1.close();
			in2.close();
			//ȥ��������
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
			String[] ary1 = s1.split(" |,|\\?|\\.|\"|��|;|:");//ary1����file1�Ĵʻ�
			String[] ary2 = s2.split(" |,|\\?|\\.|\"|��|;|:");//ary2����file2�Ĵʻ�
			TreeSet<String> set1=new TreeSet<String>();     //set1��Ų��ظ��ĵ���
			for(String item1: ary1){
				set1.add(item1);
			}
			for(String item2: ary2){
				set1.add(item2);
			}
			Iterator<String> it=set1.iterator();   //��ȡ���ʼ���
			System.out.println("�����ļ��Ĵʻ��Ϊ��");
			while(it.hasNext()){
				String str=(String)it.next();
				System.out.println(str);
			}
			System.out.println("**********************");
			System.out.println("ͬʱ�����������ļ��еĴʻ��Ϊ��");
			TreeSet<String> set2=new TreeSet<String>();   //set2���file1�в��ظ��ĵ���
			TreeSet<String> set3=new TreeSet<String>();	   //set3���file2�в��ظ��ĵ���
			for(String item1: ary1){
				set2.add(item1);
			}
			for(String item2: ary2){
				set3.add(item2);
			}
			it=set2.iterator();
			while(it.hasNext()){
				String str=(String)it.next();         
				if(set3.contains(str)){              //��set3�еĵ���������set2�Ƚϣ����set2�д��ڣ����������
					System.out.println(str);
				}
			}
			System.out.println("**********************");
			List<String> list1=new ArrayList<String>();   //list1��ſ����ظ���file1�ĵ���
			List<String> list2=new ArrayList<String>();   //list2��ſ����ظ���file2�ĵ���
			for(String item1: ary1){
				list1.add(item1);
			}
			for(String item2: ary2){
				list2.add(item2);
			}
			System.out.println("�ļ�1�еĵ�������Ϊ��");
			System.out.println(list1.size());
			System.out.println("�ļ�2�еĵ�������Ϊ��");
			System.out.println(list2.size());
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
