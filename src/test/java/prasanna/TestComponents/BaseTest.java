package prasanna.TestComponents;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	public WebDriver driver;

	@BeforeMethod
	public void startDriver() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		//i am writing the website url her itself because. If we want to automate this website then we have to go into this url every time
		driver.get("https://www.leafground.com/dashboard.xhtml");
		
	}
}
