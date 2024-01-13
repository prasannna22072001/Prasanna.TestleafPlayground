package TestLeaf.prasanna.testleafPlayground;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IFramesPOM extends AbstractComponent{

	WebDriver driver;
	
	public IFramesPOM(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath = "//li[@id='menuform:j_idt39']")
	WebElement browserElement;

	@FindBy(xpath = "//li[@id='menuform:m_frame']")
	WebElement ifElement;
	
	@FindBy(tagName = "iframe")
	List<WebElement> iframeElements;
	
	@FindBy(id="Click")
	WebElement clickElement;
	
	public void iframe() {
		
		browserElement.click();
		ifElement.click();
		
		System.out.println("Total number of iframes are " + iframeElements.size());
		
		driver.switchTo().frame(0);
		clickElement.click();
		driver.switchTo().defaultContent();
		System.out.println("Total number of iframes are " + iframeElements.size());

	}
	
	public void nestedIFrame() {

		driver.switchTo().frame(1);
		System.out.println("Total number of iframes are " + iframeElements.size());

		
//		driver.switchTo().frame("frame2);
//		clickElement.click();
	}
	




}
