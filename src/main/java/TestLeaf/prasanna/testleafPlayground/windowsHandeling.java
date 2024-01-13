package TestLeaf.prasanna.testleafPlayground;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class windowsHandeling extends AbstractComponent{

	WebDriver driver;
	Set<String> windowHandles ;
	
	public windowsHandeling(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath = "//li[@id='menuform:j_idt39']")
	WebElement browserElement;

	@FindBy(xpath = "//li[@id='menuform:m_window']")
	WebElement windowElement;
	
	@FindBy(xpath="//button[@id='j_idt88:new']")
	WebElement clickElement;
	
	@FindBy(xpath="(//div[@class='overview-numbers'])[1]/strong")
	WebElement text1;
	
	
	@FindBy(xpath="//button[@id='j_idt88:j_idt93']")
	WebElement close_windowsButton;
	
	public void window() {
		
		browserElement.click();
		windowElement.click();
		
	}
	
	public void newWindow() throws InterruptedException {
		
		Thread.sleep(3000);
        // Get the window handles
       windowHandles = driver.getWindowHandles();

        // Switch to the new window
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(driver.getWindowHandle())) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
//        driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

       
	}
	
	
	public void newtab() throws InterruptedException {
		
		clickElement.click();

		newWindow();
		 
        System.out.println(driver.getCurrentUrl());
        String textString = text1.getText();
        System.out.println(textString);
        driver.switchTo().window((String) windowHandles.toArray()[0]);


	}

	public  void newSeperateWindow() throws InterruptedException {
	
		close_windowsButton.click();
		newWindow();
        System.out.println(driver.getCurrentUrl());

		
	}



}
