package Certificates;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Administrator.leftpane;

public class System_Config {
	public  System_Config (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="checkboxenablekeyrecovery")
	public WebElement sysconf;
	
	@FindBy(name="buttonsave")
	public WebElement save;
	
	public void Sys_Config(WebDriver driver){
		
		leftpane leftpane = new leftpane(driver);
		leftpane.switchFrame(driver, "mainFrame");
		if(!sysconf.isSelected()){
			sysconf.click();
            }
		save.click();						//Key Recovery Enabled
	}

}
