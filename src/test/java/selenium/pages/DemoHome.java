package selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoHome {
	
	@FindBy(linkText = "3. Add a User")
	private WebElement userLink; 

//	driver.findElement(By.linkTest("4. Login"))
	@FindBy(linkText = "4. Login")
	private WebElement loginLink;

	public WebElement getUserLink() {
		return userLink;
	}

	public WebElement getLoginLink() {
		return loginLink;
	}

}
