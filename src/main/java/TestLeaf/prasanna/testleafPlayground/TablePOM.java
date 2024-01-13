package TestLeaf.prasanna.testleafPlayground;


import static org.testng.Assert.assertEquals;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TablePOM extends AbstractComponent{

	WebDriver driver;
	List<String> nameStrings;
	List <String> nList;

	public TablePOM(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}


	@FindBy(xpath = "//li[@id='menuform:j_idt41']")
	WebElement tableElement;

	@FindBy(xpath = "//li[@id='menuform:m_table']")
	WebElement tableclick;

//	@FindBy(xpath="//tr/td[3]")
//	List <WebElement> names;


	@FindBy(xpath ="//a[@aria-label='Next Page']")
	WebElement nextpageElement;

	public void table(String peru) throws InterruptedException {

		tableElement.click();
		tableclick.click();

	
		//Here i worte List of webelements in do loop because of stale element execption. so every time the do loop runs it will fecth that particulare elements

		do {
			Thread.sleep(2000);
			List <WebElement> names = driver.findElements(By.xpath("//tr/td[3]"));
			nList = names.stream().map(a->a.getText()).collect(Collectors.toList());
			nList.forEach(v->System.out.println(v));

			if(!nList.contains("Stephen Shaw")) {
				nextpageElement.click();
			}
			else {
			System.out.println(nList.indexOf(peru));
			}
		}while(!nList.contains(peru));
	}


	



}
