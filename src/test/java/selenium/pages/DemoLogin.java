package selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoLogin {

	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input")
	private WebElement userLogin;
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input")
	private WebElement userPassword; 
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")
	private WebElement message; 
	
	public void loginInfo(String uname, String password) {
		userLogin.sendKeys(uname);
		userPassword.sendKeys(password);
		userPassword.submit();
	}

	public WebElement getUserLogin() {
		return userLogin;
	}

	public WebElement getUserPassword() {
		return userPassword;
	}

	public WebElement getMessage() {
		return message;
	}
	
	
	
}
