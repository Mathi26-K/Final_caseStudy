package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy (xpath = "//a[@class='nav-link ']")
	WebElement HomePage;
	@FindBy (xpath = "//button[@class='nav-link ']")
	WebElement globalFeed;
	@FindBy (xpath = "(//h1)[1]")
	WebElement FirstArticle;
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void HomePageBtnClick() {
		HomePage.click();
		
	}
	public void GlobalFeedClick() {
		globalFeed.click();
		//(//h1)[1]
	}
	public void SelectFirstArticle() {
		FirstArticle.click();
		//(//h1)[1]
	}
}
