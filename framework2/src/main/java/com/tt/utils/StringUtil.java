package com.tt.utils;

import org.apache.commons.lang3.math.NumberUtils;

public class StringUtil {
	


	public static String ExtractNumberFromString(String msg,int occ)
	{
		String output = msg;
		int curr=0;
		String[] words = msg.split(" ");
		for(int i=0;i<words.length;i++)
		{
			//System.out.println(words[i]);
		if (NumberUtils.isNumber(words[i]))
			{
				curr++;
				if(curr==occ)
				{
				output=words[i];
				break;
			}
			
		}
		}
		
		
		return output;
	}
	public static String ExtractStringBetween(String msg,String before,String after)
	{ 
		String output = " ";
		int startIndex=msg.indexOf(before) + before.length();
		int endIndex=msg.lastIndexOf(after);
		if((startIndex==(-1))||(endIndex==(-1)))
		{
			output="no match found";
			return output;
		}
		//System.out.println("BeforeIndex:" +startIndex);
		//System.out.println("afterIndex:" +endIndex);
		int temp=0;
		if(startIndex>endIndex)
		{
			endIndex=endIndex+after.length();
			temp=startIndex;
			startIndex=endIndex;
			endIndex=temp;
		}
		else
		{
			startIndex=startIndex+before.length();
		}
		output=msg.substring(startIndex, endIndex).trim();
		return output;
	}
	public static String ExtractRandomString(int size)
	{
		String output=" ";
		String randomOf="abcdefghijklmnop127684938";
		int len= randomOf.length();
		for(int i=0;i<size;i++)
		{ 
			int index=(int)(Math.random()*len);
			output=output + randomOf.charAt(index);
		}
		
		return output;
	}
	
	
	public static void main (String args[])
	{
		
		System.out.println("Number extracted is:" + StringUtil.ExtractNumberFromString("Your order 591998 is created successfully" +"and has 15 items",1));
		System.out.println("String between five and seven  is:" + StringUtil.ExtractStringBetween("five six seven","five","seven"));
		System.out.println("Random String is:" + StringUtil.ExtractRandomString(8));
	}
	}
	
	


