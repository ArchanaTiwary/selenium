package tt.com.lib;

import com.tt.at.Browser;

public class BasePage {
	
	protected Browser browser;
	
	public BasePage(){
		
	}
	public BasePage(Browser browser)
	{
		setBrowser(browser);
	}
	public void setBrowser(Browser browser)
	{
		this.browser=browser;
	}

}
