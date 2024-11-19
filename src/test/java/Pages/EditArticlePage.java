
package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditArticlePage {
	
	@FindBy(xpath = "//a[contains(text(),'Edit Article')]")
	WebElement editArticleBtn;
	
	@FindBy(xpath = "//button[contains(text(),' Delete Article')]")
	WebElement DelArticleBtn;
	
	@FindBy(name = "title")
	WebElement TitleTextBox;

	@FindBy(xpath = "//input[@name='description']")
	WebElement descriptionTextBox;

	@FindBy(xpath = "//textarea[@name='body']")
	WebElement bodyTextBox; //tags
	
	@FindBy(name = "tags")
	WebElement tagsTextBox;
	
	@FindBy(xpath = "//button[contains(text(),'Update Article')]")
	WebElement UpdateBtn; 
	@FindBy(xpath = "//h1")
	WebElement articleTitle;
	@FindBy(xpath ="//div[contains(text(),'Articles not available.')]")
	WebElement DelArticle;

	
	public EditArticlePage(WebDriver driver){
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void EditAtricleButton()   {

		System.out.println("available : "+ editArticleBtn.isDisplayed());
		editArticleBtn.click();
	}
	public void EditArticle(String title, String desc, String content) {
		TitleTextBox.clear();
		TitleTextBox.sendKeys(title);
		descriptionTextBox.clear();
		descriptionTextBox.sendKeys(desc);
		bodyTextBox.clear();
		bodyTextBox.sendKeys(content);
		//tagsTextBox.sendKeys("Testing");
	}
	public void UpdateArticle() {
		UpdateBtn.click();
	}
	public void TitleOfArticle()   {

		System.out.println("articleTitle : "+ articleTitle.getText());
	}
	public void DeleteArticle() {
	DelArticleBtn.click();
	}
	public void deletedArticle() {
		String delArticle = DelArticle.getText();
		System.out.println("delArticle"+delArticle);
	}
	
	
}