package TestLeaf.prasanna.testleafPlayground;

import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

import prasanna.TestComponents.BaseTest;



public class AuthTest extends BaseTest{

	String peru = "Stephen Shaw";
	
	@Test(priority = 1)
	public void authtest() throws InterruptedException {
		
		AuthPOM auth = new AuthPOM(driver);
		auth.authentication();
		auth.newWindow();
	}
	
	@Test(priority = 2)
	public void iframestest() {
		
		IFramesPOM iframes = new IFramesPOM(driver);
		iframes.iframe();
		iframes.nestedIFrame();
	}

	
	@Test(priority = 4)
	public void windows() throws InterruptedException {
		
		windowsHandeling w = new windowsHandeling(driver);
		w.window();
		w.newtab();
		w.newSeperateWindow();
	}

	
	@Test(priority = 3)
	public void tables() throws InterruptedException {
		
		TablePOM taPom =  new TablePOM(driver);
		taPom.table(peru);
	}
	
	
	
	@Test(priority = 5)
	public void gridt() throws InterruptedException  {
	
		
		GridTablePOM grid =  new GridTablePOM(driver);
		grid.gridtable();
		grid.gettingPrice();
		grid.gettingpriceOnNextPage();
		
	}
	
	@Test
	public void gridt2() throws InterruptedException {
		
		GridTablePOM2 gridtablepom2 = new GridTablePOM2(driver);
		gridtablepom2.gridtable2();
	}
	
	
	@Test
	public void calender() throws InterruptedException {
		
		CalenderPOM cal = new CalenderPOM(driver);
		cal.calenderPage();
	}
	
}



