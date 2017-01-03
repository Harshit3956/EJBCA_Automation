package Login;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Administrator.Administrator;
import java.util.Properties;

public class login {
	public static void main(String[] args) {	
		Chrome_Initialize chrome = new Chrome_Initialize();
		WebDriver driver=chrome.initializeChrome();
		try{			
			ejbca_login page = new ejbca_login(driver);			
			Properties url=page.Prop_Obj("\\src\\Configuration\\URL.properties");
			Properties var=page.Prop_Obj("\\src\\Configuration\\CONFIG.properties");
			
			//--------------EJBCA CONSOLE--------------------------			
			driver.get(url.getProperty("EJBCA"));		//EJBCA Console
			Assert.assertEquals(var.getProperty("WelcomeTitle"),driver.findElement(By.cssSelector(".title")).getText());
			page.EJBCALogin(var.getProperty("Username"),var.getProperty("EnrollCode"),driver,var.getProperty("CreateCertLink"));				//EJBCA Login call
			
			//-------------ADMINISTRATION----------------------------
			page.Administration();
			Administrator admin = new Administrator(driver);			
			admin.local(driver);
						
		}catch(Exception e) {
			e.printStackTrace();
		} 
}
}