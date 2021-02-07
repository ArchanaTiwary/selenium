package com.tt.at;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
	String browserType = "chrome";
	WebDriver driver  = null;
	WebElement element = null;
	
	public WebDriver initBrowser()
	{
		if(browserType.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserType.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);   //implicit wait
		//it throws NoSuchElementFoundException
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);   //PageLoad Timeout
		
		
		return driver;
	}
	
	public void close()
	{
		driver.quit();
	
	}
	
	public WebElement getObject(String locatorType, String value)
	{
		try {
			if(locatorType.equalsIgnoreCase("ID"))
			{
				element = driver.findElement(By.id(value));
			}
			else if (locatorType.equalsIgnoreCase("CLASS"))
			{
				element = driver.findElement(By.className(value));
			}
			else if (locatorType.equalsIgnoreCase("XP"))
			{
				element = driver.findElement(By.xpath(value));
			}
			else if(locatorType.equalsIgnoreCase("LINKTEXT"))
			{
				element = driver.findElement(By.linkText(value));
			}
		}
		catch(Exception e)
		{
			System.err.println("Object is not found");
			element = null;
		}
		return element;
	}
	public WebElement getObjectTag(String tag)
	{
		try {
			element=driver.findElement(By.tagName(tag));

		}catch(Exception e) {
			System.out.println("Tag not found");
			element=null;
		}
		

		return element;
	}
	public int getObjCountbyXP(String xp) {
		int count=0;
		try {
		List<WebElement> elems=driver.findElements(By.xpath(xp));
		if(elems!=null && elems.size()>0)
			count=elems.size();
		}catch(Exception e)
		{
			System.out.println("Element not found by xpath"+xp);
		}
		return count;
	}
	public WebElement getObjectid(String id)
	{
		//Code for Implicit & Explicit wait
		//return getObject("ID", id);
//		try {
//			element=driver.findElement(By.id(id));
//
//		}catch(Exception e) {
//			System.out.println("ID not found");
//			element=null;
//		}
		return getObject("ID",id);

	}
	public WebElement getObjectClass(String className)
	{
		//Code for Implicit & Explicit wait

		return getObject("CLASS",className);

	}
	
	public WebElement getObjectXP(String xp)
	{
		//Code for Implicit & Explicit wait

		//return getObject("XP", xp);
//		try {
//			element=driver.findElement(By.xpath(xp));
//			
//		}catch(Exception e) {
//			System.out.println("Xpath not Found");
//			element=null;
//		}
		return getObject("XP",xp);
		
		
	}
	public WebElement getObjectByLinktext(String name) {
		
		return getObject("LINKTEXT",name);
	}
	
	public void setText(String data)
	{
		if(element!=null)
		{
			element.clear();
			element.sendKeys(data);
		}
	}
	public void click()
	{
		if(element!=null)
		{
			element.click();
		}
	}
	public String getText()
	{
		String ret= "";
		if(element!=null)
		{
//			try {
//				
//			}catch(Exception e) {
//				System.out.println("");
//			}
			ret = element.getText();
		}
		return ret;
	}
		
	public void launchBrowser(String url)
	{
		driver.get(url);   //getting url from SampleTest.java
		System.out.println("Browser launched URL: "+url);
	}
	
	//Explicit Wait................
	//it throws ElementNotVisibleException 
	public void waitForObjectIsVisible(String locator,String value) {
		WebDriverWait wait=new WebDriverWait(driver,20);
		try {
		if(locator.equalsIgnoreCase("ID"))
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(value)));
		else if(locator.equalsIgnoreCase("XP"))
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
		else if(locator.equalsIgnoreCase("LINKTEXT"))
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(value)));
		else if(locator.equalsIgnoreCase("NAME"))
			element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(value)));
		}catch(Exception e) {
			System.out.println("Object is not found with Locator: "+locator+"and the locator value: "+value);
		}
	}
	public void selectOption(String value) {
		Select sele=new Select(element);
		sele.selectByVisibleText(value);
	}
	public void printAllOption() {
		Select sele=new Select(element);
		List <WebElement> option=sele.getOptions();
		System.out.println("---All the option of Select Box---");
		for(int i=0;i<option.size();i++) {
			System.out.println(option.get(i).getText());
		}
		System.out.println("------------------------------------");
	}

	public WebDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}
	public void switchToFrame(String id)
	{
	WebElement iframe= driver.findElement(By.id(id));
	
	
		driver.switchTo().frame(iframe);
	}
	public void switchToFrameByXP(String xp)
	{
	WebElement iframe=driver.findElement(By.xpath(xp));
	driver.switchTo().frame(xp);
	
		
	}
public void exitFrame()
{
	driver.switchTo().defaultContent();
	
}
public void switchToAlert()
{
	driver.switchTo().alert();
	
}
public void acceptAlert()
{
	driver.switchTo().alert().accept();
}
public void cancelAlert()
{
	driver.switchTo().alert().dismiss();
}
public String getAlertMassage()
{
	return driver.switchTo().alert().getText();
}
public void setTextInAlert(String data)
{
	driver.switchTo().alert().sendKeys(data);
}
}
