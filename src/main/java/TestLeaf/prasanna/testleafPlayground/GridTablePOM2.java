package TestLeaf.prasanna.testleafPlayground;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GridTablePOM2 extends AbstractComponent {

	WebDriver driver;
	List <String> namesList ;
	List<WebElement> productnames;
	List<String> perluList;


	public GridTablePOM2(WebDriver  driver) {
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


	@FindBy(xpath ="//tr/td[3]")
	List<WebElement> productnamesElementes;

	public void gridtable2() throws InterruptedException {

		tableElement.click();
		gridclick.click();

		Thread.sleep(2000);
		List<WebElement> productnames3= driver.findElements(By.xpath("//tr/td[3]"));
		perluList= productnames3.stream().map(e->e.getText()).collect(Collectors.toList());
		perluList.forEach(q->System.out.println(q));
		
		List<String> prodNameStrings = new ArrayList<>();
		prodNameStrings.add("Black Watch");
		prodNameStrings.add("Blue Band");
		
		for(int i=0;i<prodNameStrings.size(); i++) {

			String nameString = prodNameStrings.get(i);
			WebElement DName = productnamesElementes.stream().filter(a->a.getText().equalsIgnoreCase(nameString)).findFirst().orElse(null);
			DName.findElement(By.xpath("preceding-sibling::td[2]/div")).click();

		}
		
	}

}
