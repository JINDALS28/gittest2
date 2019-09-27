package guru99.gittest2;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AppTest {
	WebDriver driver;

	@BeforeMethod
	public void setUp() throws Exception {
		String execPath = "C:\\Users\\jindals\\Documents\\selenium\\drivers\\chromedriver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", execPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Launch the Online Store Website
		String testsiteurl="https://ssotst.xchanging.com/portal/xchanging/homepage.jsp";
		driver.get(testsiteurl);
	}

	@Test
	public void test() {
		driver.findElement(By.id("IDToken1")).sendKeys("EX01349A");
		driver.findElement(By.id("IDToken2")).sendKeys("Noida@1234");
		driver.findElement(By.xpath("//input[@name='Login.Submit']")).click();
		System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
		driver.findElement(By.xpath("//a[@href=\"/portal/UI/Logout\"]")).click();
		System.out.println("Logout Successfully");
	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	}

}
