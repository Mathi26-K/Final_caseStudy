package TestBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
	private static  TestBase testBase;
	private static WebDriver driver;
	
	private TestBase(){
		String strBrowser = "chrome";
		if(strBrowser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(strBrowser.equalsIgnoreCase("edge")) {
				driver = new ChromeDriver();
		}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
			driver.manage().deleteAllCookies();
	}
	
	public static void initdriver() {
		if( testBase == null) {
			testBase = new TestBase();
		}
	}
	public static WebDriver getDriver() {
		return driver;
	}
		public static void openURL(String url) {
		 driver.get(url);
	}
	public static void tearDown() {
		if(driver!=null) {
			driver.close();
		//	driver.quit();
		}
	}
}

