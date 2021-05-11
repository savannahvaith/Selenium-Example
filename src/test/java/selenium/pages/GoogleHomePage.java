package selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleHomePage {
	
	public static final String URL = "https://google.com"; 
	
	// Grab the search bar element
	@FindBy(name = "q")
	private WebElement searchBar; 
	
	@FindBy(name = "btnK")
	private WebElement searchButton;
	
	@FindBy(className = "Eq0J8 LrzXr kno-fv")
	private WebElement foundedDate;

	@FindBy(id ="zV9nZe")
	private WebElement agreeButton;
	
	public WebElement getSearchBar() {
		return searchBar;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public static String getUrl() {
		return URL;
	}

	public WebElement getFoundedDate() {
		return foundedDate;
	}

	public WebElement getAgreeButton() {
		return agreeButton;
	}
	
	
	
	
}
