package selenium.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import selenium.pages.QACommunityPage;

public class QACommunityPageTest {
	
	private WebDriver driver;
	
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().setSize(new Dimension(1378, 690));
	}
	
	@After
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void test() {
		driver.get("https://qa-community.co.uk/");
		assertEquals("Log in to QA Community" , driver.getTitle());
	}
	
	@Test
	public void loginFail() {
		driver.get("https://qa-community.co.uk/");
		QACommunityPage page = PageFactory.initElements(driver, QACommunityPage.class);
		page.getUsername().sendKeys("sav.vaith");
		page.getPassword().sendKeys("hello");
		page.getLoginButton().click();
		assertTrue(page.getErrorAlert().getText().contains("Invalid"));
	}

}
