package selenium.tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import selenium.pages.PaintPage;

public class PaintTest {

	public static final String URL = "https://www.youidraw.com/apps/painter/";

	private WebDriver driver;
	

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
//		options.setHeadless(true); // Turns off the chrome window! ( tests are finished )
		driver = new ChromeDriver(options);
		// set window size
		driver.manage().window().setSize(new Dimension(1360, 789));
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	}
	
	@After
	public void shutdown() {
		driver.close();
	}
	
	@Test
	public void squiggle() {
		Actions action = new Actions(driver);
		driver.get(URL);
		PaintPage canvas = PageFactory.initElements(driver, PaintPage.class);
		canvas.paint(); // selects the pen 
		
		action.moveToElement(canvas.getDrawingSpace())
			.clickAndHold().moveByOffset(0,-200).moveByOffset(300, 0).release().build().perform();
	}

}
