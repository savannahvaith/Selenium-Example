package selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QACommunityPage {
	
	@FindBy(name = "username")
	private WebElement username;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(id = "kc-login")
	private WebElement loginButton; 
	
	@FindBy(className = "alert-error")
	private WebElement errorAlert; 

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getErrorAlert() {
		return errorAlert;
	}
	
	

}
