package Administrator;

import java.io.FileInputStream;
import java.util.Properties;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Certificates.*;

public class leftpane {
	public  leftpane (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	//-----------------Frame Switch-----------------------------
	public void switchFrame(WebDriver driver, String framelable)
	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame(framelable);
	}	
	
	//-----------------System Configuration------------------------
	@FindBy(linkText="System Configuration")
	public WebElement sysconf;
	
	public void SystemConfig(WebDriver driver)
	{
		switchFrame(driver,"leftFrame");
		sysconf.click();
		System_Config sysconf = new System_Config(driver);
		sysconf.Sys_Config(driver);
	}
	
	//------------------Certificate Authority-----------------------
	@FindBy(linkText="Certification Authorities")
	public WebElement certAuth;
	
	public void CertAuthority(WebDriver driver)
	{
		switchFrame(driver,"leftFrame");
		certAuth.click();
		Cert_Authority CertAuth = new Cert_Authority(driver);
		CertAuth.Certificate_Authority(driver);
	}
	
	//-----------------Check Content-------------------------------
		public void checkContent(WebDriver driver)
		{
			switchFrame(driver,"leftFrame");
			Properties var = new Properties();
			try{			
				FileInputStream urlfile = new FileInputStream(System.getProperty("user.dir")+"\\src\\Configuration\\CONFIG.properties");
				var.load(urlfile);
			}catch(Exception e){}	
			//String j= sysconf.getText();
			//System.out.println(j);
			Assert.assertEquals(var.getProperty("SystemConfiguration"),sysconf.getText());
			//Assert.assertEquals(var.getProperty("CryptoToken"),sysconf.getText());
			Assert.assertEquals(var.getProperty("CertificationAuthority"),certAuth.getText());
			//Assert.assertEquals(var.getProperty("CertificateProfile"),sysconf.getText());
			//Assert.assertEquals(var.getProperty("EndEntityProfile"),sysconf.getText());
			//Assert.assertEquals(var.getProperty("Services"),sysconf.getText());
			switchFrame(driver, "mainFrame");
		}
}
