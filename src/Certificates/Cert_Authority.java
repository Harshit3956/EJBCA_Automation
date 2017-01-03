package Certificates;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Administrator.leftpane;

public class Cert_Authority {
	public  Cert_Authority (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="textfieldcaname")
	public WebElement textBox;
	
	@FindBy(name="buttoncreateca")
	public WebElement create;
	
	public void Certificate_Authority(WebDriver driver)
	{
		leftpane leftpane = new leftpane(driver);
		leftpane.switchFrame(driver, "mainFrame");
		textBox.sendKeys("ExampleRootCA");
		create.click();			
		ExampleRootCA(driver);
	}
		
	//--------------Creating ExampleRootCA---------------	
	@FindBy(how=How.XPATH,using="//option[text()='SHA256WithRSA']")
	public WebElement SHA256;
	
	@FindBy(how=How.XPATH,using="//option[text()='AdminCA1']")
	public WebElement AdminCA1;
	
	@FindBy(name="textfielddescription")
	public WebElement description;
	
	@FindBy(name="textfieldsubjectdn")
	public WebElement SubjectDN;
	
	@FindBy(name="textfieldvalidity")
	public WebElement validity;
	
	@FindBy(name="checkboxusecrldistributionpointoncrl")
	public WebElement IssueDist;
	
	@FindBy(name="checkboxgeneratedefaultcrlissuer")
	public WebElement generate;
	
	@FindBy(name="textfieldcrlperiod")
	public WebElement expirePeriod;
	
	@FindBy(name="textfieldcrloverlaptime")
	public WebElement overlapPeriod;
	
	@FindBy(name="buttoncreate")
	public WebElement createExampleRootCA;
	
	public void ExampleRootCA(WebDriver driver)
	{
		SHA256.click();
		AdminCA1.click();
		Select defaultKeyDropdown = new Select(driver.findElement(By.xpath("//select[@name='selectdefaultkey']")));
        defaultKeyDropdown.selectByValue("defaultKey");
        Select signKeyDropdown = new Select(driver.findElement(By.xpath("//select[@name='selectcertsignkey']")));
        signKeyDropdown.selectByValue("signKey");
        description.sendKeys("Root CA for Example Inc");
        SubjectDN.clear();
        SubjectDN.sendKeys("CN=ExampleRootCA,O=Example Inc,C=RS");
        validity.sendKeys("20y");
        if(!IssueDist.isSelected()){
        	IssueDist.click();
            }
        generate.click();
        expirePeriod.clear();
        expirePeriod.sendKeys("1y");
        overlapPeriod.clear();
        overlapPeriod.sendKeys("2d");
        createExampleRootCA.click();
	}
	
	
}