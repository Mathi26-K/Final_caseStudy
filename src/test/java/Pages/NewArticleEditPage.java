package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewArticleEditPage {
	@FindBy(linkText = "New Article")
	WebElement newAtricleButton;
	@FindBy(name = "title")
	WebElement TitleTextBox;

	@FindBy(xpath = "//input[@name='description']")
	WebElement descriptionTextBox;

	@FindBy(xpath = "//textarea[@name='body']")
	WebElement bodyTextBox; //tags
	
	@FindBy(name = "tags")
	WebElement tagsTextBox;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement PublishBtn; 
	
	@FindBy(xpath = "//h1")
	WebElement PublishedArticleTitle;
	
	
	public NewArticleEditPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void NewAtricleButton()  {
		//Thread.sleep(4000);
		System.out.println("available : "+ newAtricleButton.isDisplayed());
		newAtricleButton.click();
	}
	public void CreatingArticle() {
		TitleTextBox.sendKeys("SELENIUM e63 SESSION");
		descriptionTextBox.sendKeys("The article is about selenium, git, cucumber, testNG");
		bodyTextBox.sendKeys("Selenium is open-source framework designed for automating web applications across different browsers");
		tagsTextBox.sendKeys("Testing");
	}
	public void PublishArticle() {
		PublishBtn.click();
		
	}
	public void ArticleTitle() {
		String getArticleTitle = PublishedArticleTitle.getText();
		System.out.println("getArticleTitle"+getArticleTitle);
	}
}
