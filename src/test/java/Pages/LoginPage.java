package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
	@FindBy(xpath = "//a[@class='nav-link ']//i")
	WebElement HomePageLoginButton;
	
	@FindBy(name = "email")
	WebElement email;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//button[contains(text(),'Login')]")
	WebElement loginButton;
	
	@FindBy(xpath = "(//a[contains(text(),'conduit')])[1]")
	WebElement Title;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void validLogin(String strUser, String strPwd) {
		HomePageLoginButton.click();
		email.sendKeys(strUser);
		password.sendKeys(strPwd);
		loginButton.click();
	}
	public void pageEquals() {
		String actualText = Title.getText();
		Assert.assertEquals(actualText, "Swag Labs");
	}
}
