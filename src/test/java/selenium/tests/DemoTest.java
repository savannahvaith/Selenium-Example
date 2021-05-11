package selenium.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium.pages.DemoHome;
import selenium.pages.DemoLogin;
import selenium.pages.DemoUser;

public class DemoTest {
	
	public static final String URL = "http://thedemosite.co.uk";
	
	private WebDriver driver; 
	
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true); // Turns off the chrome window! ( tests are finished )
		driver = new ChromeDriver(options);
		//set window size
		driver.manage().window().setSize(new Dimension(1360, 789));
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	}
	
	
	@After
	public void shutdown() {
		driver.close();
	}
	
	@Test
	public void testUserPage() {
		driver.get(URL + "/index.php");
		DemoHome homePage = PageFactory.initElements(driver, DemoHome.class);
		// grab the User link element, and click it
		homePage.getUserLink().click();
//		assertEquals("Add a user - FREE PHP code and SQL", driver.getTitle());
		assertTrue(driver.getTitle().contains("Add a user"));
	}
	
	// Create a new user
	@Test
	public void testAddUser() {
		driver.get(URL + "/addauser.php");
		DemoUser userPage = PageFactory.initElements(driver, DemoUser.class);
		userPage.createUser("Test", "Test1");
		assertEquals(URL+"/savedata.php", driver.getCurrentUrl());
	}
	
	@Test
	public void testLoginUser() {
		driver.get(URL + "/index.php");
		DemoHome homePage = PageFactory.initElements(driver, DemoHome.class);
		DemoUser userPage = PageFactory.initElements(driver, DemoUser.class);
		DemoLogin loginPage = PageFactory.initElements(driver, DemoLogin.class);
		
		String username = "Test";
		String password = "test1";
		
		// Go to user page
		homePage.getUserLink().click();
		
		// Create a user
		userPage.createUser(username, password);
		
		
		// move from user page to login page..
		homePage.getLoginLink().click();
		
		// Login
		loginPage.loginInfo(username, password);
		
		// Explicit = when we depend on a element 
		WebDriverWait wait = new WebDriverWait(driver, 7);
		wait.until(ExpectedConditions.textToBePresentInElement(loginPage.getMessage(), "ohno"));
		
		assertTrue(driver.getPageSource().contains("**Successful Login**"));
		
	}
	

}
