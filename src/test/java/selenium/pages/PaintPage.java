package selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaintPage {
	
	@FindBy(id = "brush")
	private WebElement pen;
	
	@FindBy(id = "catch")
	private WebElement drawingSpace; 
	
	public void paint() {
		pen.click();
	}

	public WebElement getDrawingSpace() {
		return drawingSpace;
	}
	
	
	
}
