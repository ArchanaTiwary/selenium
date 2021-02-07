package com.tt.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

	
		public String filepath =" ";
		public String OnEnv=" ";
		Properties prop;
		String currentInstance=" ";
		public PropertiesUtil(String filepath)
		{
			this.filepath=filepath;
			prop = new Properties();
			try
			{
			InputStream in = new FileInputStream(this.filepath);
			prop.load(in);
			in.close();
			currentInstance=get("run_on_instance");
			System.out.println("Scripts are running on instance" + currentInstance);
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
public String get(String propName)
{
	return get(propName,currentInstance);
}
public String get(String propName,String prefix)
{
	String ret=" ";
	if(prefix!=null && !"".equals(prefix))
		propName=prefix+"_"+propName;
	ret=prop	.getProperty(propName);
	System.out.println("value of property["+propName+"] is =>" + ret);
	return ret;
}

public String getFilepath() {
	return filepath;
}
public void setFilepath(String filepath) {
	this.filepath = filepath;
}
public String getOnEnv() {
	return OnEnv;
}
public void setOnEnv(String OnEnv) {
	this.OnEnv = OnEnv;
}
public Properties getProp() {
	return prop;
}
public void setProp(Properties prop) {
	this.prop = prop;
}
public String getCurrentInstance() {
	return currentInstance;
}
public void setCurrentInstance(String currentInstance) {
	this.currentInstance = currentInstance;
}
public static void main (String args[])
{
	PropertiesUtil props=new PropertiesUtil("C:\\Users\\USER\\Desktop\\proptest\\envprop");
	String UserName=props.get("user_name");
	String UserPassword=props.get("user_password");
	String appUrl=props.get("app_url");
}
}

