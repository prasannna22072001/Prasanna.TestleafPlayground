package TestLeaf.prasanna.testleafPlayground;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalenderPOM extends AbstractComponent {

	WebDriver driver;
	List <String> namesList ;
	List<WebElement> productnames;
	List<String> perluList;


	public CalenderPOM(WebDriver  driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}


	@FindBy(xpath = "//li[@id='menuform:j_idt41']")
	WebElement tableElement;

	@FindBy(xpath = "//li[@id='menuform:m_calendar']")
	WebElement calenderclick;

	@FindBy(css=".fc-toolbar-title")
	WebElement month;

	@FindBy(xpath = "//div/button[.='Next']")
	WebElement nextElement;

	@FindBy(xpath="//a[@class='fc-daygrid-day-number']")
	List <WebElement> datesElements;

	@FindBy(id="j_idt87:title")
	WebElement eventTitleElement;
	
	
	@FindBy(id="j_idt87:addButton")
	WebElement saveElement;
	
	public void calenderPage() throws InterruptedException {

		String nela = "May 2024";
		tableElement.click();
		calenderclick.click();

		Thread.sleep(2000);


		while(!month.getText().contains(nela)){

			nextElement.click();
		}
		
		WebElement specificdate = datesElements.stream().filter(q->q.getText().equalsIgnoreCase("13")).findFirst().orElse(null);
		specificdate.click();

		waitForElementToAppear(eventTitleElement);
		eventTitleElement.sendKeys("Birthday");
		saveElement.click();

	}

}
