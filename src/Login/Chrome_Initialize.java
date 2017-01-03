package Login;

import java.util.concurrent.TimeUnit;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome_Initialize {
	
	public WebDriver driver;
	
	public WebDriver initializeChrome()
	{		
		try{
			Properties var = new Properties();
			FileInputStream varfile = new FileInputStream(System.getProperty("user.dir")+"\\src\\Configuration\\CONFIG.properties");
			var.load(varfile);
			
			System.setProperty("webdriver.chrome.driver", var.getProperty("Chromedriver"));
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		}catch(Exception e){}
		return driver;
	}
	
	public void quitChrome(WebDriver driver)
	{
		driver.quit();
	}

}
