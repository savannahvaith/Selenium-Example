package selenium.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import selenium.pages.GoogleHomePage;

public class GooglePageTest {
	
	private WebDriver driver; 
	
	@Before
	public void init() {
		//set the chromedriver
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		
		// initialise the above variable
		driver = new ChromeDriver();
		
		// set the windowsize of our chrome window
		driver.manage().window().setSize(new Dimension(1366,763));
	}
	
	@After
	public void shutDown() {
		driver.close();
	}
	
	@Test
	public void getGoogle() {
		driver.get(GoogleHomePage.URL);
		assertEquals("Google", driver.getTitle());
	}
	
	@Test
	public void searchGoogle() {
		driver.get(GoogleHomePage.URL);
		GoogleHomePage page  = PageFactory.initElements(driver, GoogleHomePage.class);
		page.getAgreeButton().click();
		page.getSearchBar().sendKeys("disney");
		page.getSearchButton().click();
		assertTrue(page.getFoundedDate().getText().contains("16 October"));
	}
	
}
