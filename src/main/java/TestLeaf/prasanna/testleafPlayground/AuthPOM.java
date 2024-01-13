package TestLeaf.prasanna.testleafPlayground;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthPOM extends AbstractComponent{

	WebDriver driver;
	
	public AuthPOM(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath = "//li[@id='menuform:j_idt38']")
	WebElement homeElement;

	@FindBy(xpath = "//li[@id='menuform:m_auth']")
	WebElement authElement;
	
	@FindBy(css=".ui-button-text.ui-c")
	WebElement basicauthElement;
	
	public void authentication() {
		homeElement.click();
		authElement.click();
		basicauthElement.click();
	}
	
	public void newWindow() throws InterruptedException {
		
		Thread.sleep(3000);
        // Get the window handles
        Set<String> windowHandles = driver.getWindowHandles();

        // Switch to the new window
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(driver.getWindowHandle())) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        
        System.out.println(driver.getCurrentUrl());
        driver.manage().window().maximize();
		       

	}
	
	
//	public void alert() throws InterruptedException {
//		
//		Thread.sleep(3000);
//		Alert alert = driver.switchTo().alert();
//
//        alert.sendKeys("admin");
//        alert.sendKeys("\t"); // Press TAB to move to the password field
//        alert.sendKeys("testleaf");
//
//        alert.accept();
//		
//        
//	}






}
