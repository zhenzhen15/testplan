package com.testfan.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class FileTest {
	
	public static void main(String[] args) throws Exception {
//		fileTest();
//		fileStream();
		//fileReader();
		
		fileUtilsTest();
	}
	
	private static void fileUtilsTest() throws IOException {
		String str=FileUtils.readFileToString(new File("db1.csv"),"utf8");
		System.out.println(str);
		System.out.println(" 分割符 ---------------");
		Charset charset =Charset.forName("utf8");
		List<String> lines=FileUtils.readLines(new File("db1.csv"), charset);
		
		for (String string : lines) {
			System.out.println(string);
		}
		FileUtils.write(new File("db1.csv"), "12121212\n",charset,true);
	}
	
	private static void fileTest() throws Exception {
		//System.getProperty("user.dir") 工程当前目录
//		System.out.println(System.getProperty("user.dir"));
		String path =System.getProperty("user.dir")+File.separator+"data"+File.separator+"test";
//		new File(path).mkdirs();
//		 FileOutputStream fos=new FileOutputStream(path+File.separator+"1.txt");
		Charset charset =Charset.forName("utf8");
		//文件夹创建 文件创建，写文件 一步到位
		FileUtils.write(new File(path+File.separator+"db_test.csv"), "12121212\n", charset, true);
		//FileUtils.write(file, data);
	}
	// 走读开发代码需要
	// 通过字节流文件读写 FileOutputStream  FileInputStream
	public static void fileStream() throws Exception{
		
		String path ="1.txt";
	    FileOutputStream fos=new FileOutputStream(path, true);
        String str="这是一个测试文档\n";
        fos.write(str.getBytes());//将字符串转成字节数组
        fos.close();
        
    	FileInputStream fileInputStream = new FileInputStream(path);   
    	byte[] buf = new byte[1024];  
    	int length = 0;
    	//循环读取文件内容，输入流中将最多buf.length个字节的数据读入一个buf数组中,返回类型是读取到的字节数。
    	//当文件读取到结尾时返回 -1,循环结束。
    	while((length = fileInputStream.read(buf)) != -1){   
    	   System.out.print(new String(buf,0,length));
    	}
    	//最后记得，关闭流
    	fileInputStream.close();
	}
	
	//通过字符流 1 个汉字 2个字节编码
	//FileReader FileWriter
	public static void fileReader() throws Exception{
       String path="2.txt";
       //通过字符流的方式写入文件FileWrite
       FileWriter fw=new FileWriter(path, true);
       String str2="这是第二个测试文档\n";
       fw.write(str2);
       fw.close(); //如果不使用close，则创建的文件没有内容，因此在写入后要及时关闭
       
       FileReader fr=new FileReader(path);
       char chars[]=new char[512];  //每次最多读1kb
       int temp=0;
       while((temp=fr.read(chars))!=-1){
           System.out.println(new String(chars,0,temp));
       }
       fr.close();
	}

}
