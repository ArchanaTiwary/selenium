package com.tt.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtil {
	public static String getFileName(String filepath)
	{
		String output ="";
		File f= new File(filepath);
		output=f.getName();
		return output;
	}
	public static String getAbsolutepath(String filepath)
	{
		String output ="";
		File f= new File(filepath);
		output=f.getAbsolutePath();
		return output;
	}
	public static boolean exists(String filepath)
	{
		return (new File(filepath)).exists();
	}
	public static void createFolders(String filepath)
	{
	try
	
	{
		Files.createDirectories(Paths.get(filepath));
	}
	catch(Exception e)
	{
		
	}
	}
	public static void createtxtFile(String path,String fileName)
	{
		try
		{
			String fullFilepath=path+fileName;
		File f=new File(path+fileName+".txt");
		f.createNewFile();
		if(f.createNewFile()) {
			System.out.println("File\"" + fullFilepath + "\" is created");
		}
		else
		{
			System.out.println("File\"" + fullFilepath + "\" is not created");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void writeFile(String filepath, String content)
	{
		try
		{
			FileWriter fw = new FileWriter(filepath);
			fw.write(content);
			fw.close();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void appenddetails(String filepath,String content)
	{
		try
		{
			if(!exists(filepath))
			{
				System.out.println("can't write,sorry!! the file doesn't exists ");
				
			}
			else
			{
				FileWriter fw=new FileWriter(filepath,true);
				fw.append("\n");
				fw.append(DateUtil.getCurrentDate("ddMMyyyy") + ":"+ content);
				//BufferedWriter bw=new BufferedWriter(fw);
				//bw.newLine();
				//bw.append(content);
				//bw.close();
				fw.close();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
public  static void main(String args[])
{
	System.out.println(FileUtil.getFileName("C:\\Users\\USER\\Desktop\\seleniumclasses\\DemoReport.html"));
	System.out.println(FileUtil.getAbsolutepath("C:\\Users\\USER\\Desktop\\seleniumclasses\\DemoReport.html"));
	System.out.println(FileUtil.exists("C:\\Users\\USER\\Desktop\\seleniumclasses\\DemoReport.html"));
	FileUtil.createFolders("C:\\Users\\USER\\Desktop\\seleniumclasses\\Screenshot1");
	FileUtil.createtxtFile("C:\\Users\\USER\\Desktop\\seleniumclasses\\Screenshot1\\","log");
	//FileUtil.writeFile("C:\\Users\\USER\\Desktop\\seleniumclasses\\Screenshot1\\log.txt","hello!");
	FileUtil.appenddetails("C:\\Users\\USER\\Desktop\\seleniumclasses\\Screenshot1\\log.txt","appended");
}
}
