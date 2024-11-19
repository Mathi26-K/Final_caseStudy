package StepDefs;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Pages.EditArticlePage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.NewArticleEditPage;
import TestBase.TestBase;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ConduitStepDef {
	WebDriver driver;
	LoginPage loginPage;
	NewArticleEditPage newArticle;
	HomePage homepage;
	EditArticlePage editArticle;

	public ConduitStepDef() {
		TestBase.initdriver();
		driver = TestBase.getDriver();
		loginPage = new LoginPage(driver);
		newArticle = new NewArticleEditPage(driver);
		homepage = new HomePage(driver);
		editArticle = new EditArticlePage(driver);
	}

	@Given("User is on login page")
	public void user_is_on_login_page() {
		TestBase.openURL("https://conduit-realworld-example-app.fly.dev/#/");
	}

	@When("User provide {string} and {string}")
	public void user_provide_and(String username, String password) {
		loginPage.validLogin(username, password);
	}

	@Then("User should be on Home page")
	public void user_should_be_on_home_page() {
		// loginPage.pageEquals();
		Assert.assertEquals(driver.getTitle(), "Conduit");
	}

	@Given("User should be on New Article Page")
	public void user_should_be_on_new_article_page() {
		newArticle.NewAtricleButton();
		Assert.assertEquals(driver.getTitle(), "Conduit");
	}

	@When("User enters Article details")
	public void user_enters_article_details(DataTable articleDetails) throws InterruptedException {
		List<Map<String, String>> data = articleDetails.asMaps();

		for (Map<String, String> articleData : data) {
			newArticle.CreatingArticle(articleData.get("title"), articleData.get("Desc"), articleData.get("content"),
					articleData.get("tag"));
		}
		// List<List<String> articleData = data.get(0);

		Thread.sleep(5000);
		newArticle.PublishArticle();
	}

	@Then("Article must be created")
	public void article_must_be_created() throws InterruptedException {
		Thread.sleep(3000);
		newArticle.ArticleTitle();
	}
//	

//	
	@Given("User should be on global feed page")
	public void user_should_be_on_global_feed_page() throws InterruptedException {
		Thread.sleep(3000);
		homepage.HomePageBtnClick();
		Thread.sleep(3000);
		homepage.GlobalFeedClick();

	}

	@When("User select an article {string}")
	public void user_select_an_article(String string) {
		homepage.SelectFirstArticle();
	}

	@Then("Article must be displayed1")
	public void article_must_be_displayed1() {
		editArticle.TitleOfArticle();
	}

	@Given("Article detail page must be displayed1")
	public void article_detail_page_must_be_displayed1() {
		editArticle.TitleOfArticle();
	}

	@When("User update article detail")
	public void user_update_article_detail(DataTable EditarticleDetails) {
		editArticle.EditAtricleButton();
		
		List<Map<String, String>> data = EditarticleDetails.asMaps();

		for (Map<String, String> articleData : data) {
			
			editArticle.EditArticle(articleData.get("title"), articleData.get("Desc"), articleData.get("content"));
		}
		
	}

	@Then("Article detail must be displayed")
	public void article_detail_must_be_displayed() {
		editArticle.UpdateArticle();
		editArticle.TitleOfArticle();
	}

	@Given("Article detail page must be displayed2")
	public void article_detail_page_must_be_displayed2() {
		editArticle.TitleOfArticle();
	}

	@When("User delete aricle")
	public void user_delete_aricle() {
		editArticle.DeleteArticle();
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert 1 :" + alert.getText());
		alert.accept();
	}

	@Then("User must be in your feed tab")
	public void article_must_not_be_displayed_in_feed_tab() {
		editArticle.deletedArticle();
	}

}
