package Administrator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;



public class Administrator {
	public Administrator(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void local(WebDriver driver)
	{
		leftpane leftpane = new leftpane(driver);				//Enable Key Recovery
		leftpane.checkContent(driver);
		leftpane.SystemConfig(driver);
		leftpane.CertAuthority(driver);
		
	}

}
