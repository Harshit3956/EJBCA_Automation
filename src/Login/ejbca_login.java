package Login;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.FileInputStream;
import java.util.Properties;

public class ejbca_login {	
	public  ejbca_login (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}		
	
	//----------------EJBCA Login-----------------------	
	@FindBy(linkText="Create Browser Certificate")
	public WebElement CreateCert;
	
	@FindBy(id="textfieldusername")
	public WebElement usertext;
	
	@FindBy(id="textfieldpassword")
	public WebElement userpasswd;
	
	@FindBy(id="buttonsubmitusername")
	public WebElement btnSearch;	
	
	@FindBy(id="ok")
	public WebElement enroll;
	
	public void EJBCALogin(String searchText, String searchpasswd, WebDriver driver, String title)
	{
		CreateCert.click();
		Assert.assertEquals(title,driver.findElement(By.xpath("//a[text()='Create Browser Certificate']")).getText());
		usertext.sendKeys(searchText);
		userpasswd.sendKeys(searchpasswd);
		btnSearch.click();
		enroll.click();
	}
	
	
	//---------------------Administration-------------------------------
	@FindBy(linkText="Administration")
	public WebElement Administration;
	
	public void Administration()
	{
		Administration.click();
	}
	
	
	//----------------------FUNCTIONS-----------------------------------
	
	public Properties Prop_Obj(String PropFilePath)
	{
		Properties url = new Properties();
		try{			
			FileInputStream urlfile = new FileInputStream(System.getProperty("user.dir")+PropFilePath);
			url.load(urlfile);
		}catch(Exception e){}	
		return url;
	}	
	
//	public void VerifyTitle(WebDriver driver, String title)
//	{
//		String j= driver.findElement(By.cssSelector(".title")).getText();
//		Assert.assertEquals(title,j);
//	}
}
