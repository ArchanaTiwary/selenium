package tt.com.lib;

import java.util.HashMap;

import com.tt.at.Browser;
import com.tt.utils.Reporter;

public abstract class BaseTest {
	
	public final String browserType = "CHROME";
	public  Browser browser = null;
	protected HashMap<String, String>testData=null;
	protected Reporter r=null;
	
	
	public abstract void initializeTest(String url,String testName);
	public abstract void executeTest();
	
	public void closingTest()
	{
		r.stop();
	}
	public abstract  void closeBrowser();
	
	public void setStringTestData(HashMap<String, String>data)
	{
		this.testData=data;
	}
	public String d(String key) {
		return testData.get(key).toString();
	}
	public void setReporter(Reporter r)
	{
		this.r=r;
	}
}
