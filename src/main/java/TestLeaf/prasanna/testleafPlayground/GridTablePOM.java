package TestLeaf.prasanna.testleafPlayground;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GridTablePOM extends AbstractComponent {

	WebDriver driver;
	List <String> namesList ;
	List<WebElement> productnames;
	List<String> perluList;
	
	
	public GridTablePOM(WebDriver  driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}


	@FindBy(xpath = "//li[@id='menuform:j_idt41']")
	WebElement tableElement;

	@FindBy(xpath = "//li[@id='menuform:m_crud']")
	WebElement gridclick;

	@FindBy(xpath="//a[@aria-label='Next Page']")
	WebElement nextElement;



	public void gridtable() throws InterruptedException {

		tableElement.click();
		gridclick.click();

		do {
			Thread.sleep(2000);
			//Here i worte List of webelements in do loop because of stale element execption. so every time the do loop runs it will fecth that particulare elements

			productnames= driver.findElements(By.xpath("//tr/td[3]"));
			namesList = productnames.stream().map(a->a.getText()).collect(Collectors.toList());

			namesList.forEach(e->System.out.println(e));

			if(!namesList.contains("Pink Band")) {

				nextElement.click();
			}else {
				System.out.println(namesList.indexOf("Pink Band"));
			}
		}while(!namesList.contains("Pink Band"));

	}

	public void gettingPrice() {

		driver.navigate().refresh();
		waitForElementToAppear(nextElement);
		//Here i worte List of webelements in do loop because of stale element execption. so every time the do loop runs it will fecth that particulare elements

		List<WebElement> productnames2= driver.findElements(By.xpath("//tr/td[3]"));
		WebElement priceElement = productnames2.stream().filter(q->q.getText().equalsIgnoreCase("Blue Band")).findFirst().orElse(null);

		String priceString = priceElement.findElement(By.xpath("following-sibling::td[2]")).getText();


		System.out.println(priceString);

	}


	public void gettingpriceOnNextPage() throws InterruptedException {

		do {
			Thread.sleep(2000);
			List<WebElement> productnames3= driver.findElements(By.xpath("//tr/td[3]"));
			perluList= productnames3.stream().map(e->e.getText()).collect(Collectors.toList());
			perluList.forEach(q->System.out.println(q));

			if(!perluList.contains("Headphones")) {

				nextElement.click();
			}
			else {
				WebElement priceElement = productnames3.stream().filter(q->q.getText().equalsIgnoreCase("Headphones")).findFirst().orElse(null);

				String priceString = priceElement.findElement(By.xpath("following-sibling::td[2]")).getText();


				System.out.println(priceString);		
			}
		}while(!perluList.contains("Headphones"));
	}

}
