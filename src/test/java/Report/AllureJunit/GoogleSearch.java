package Report.AllureJunit;

import static org.junit.Assert.assertTrue;
import java.io.ByteArrayInputStream;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GoogleSearch {
	public static WebDriver driver;

	@Test
	@Epic("EPIC - Google Search Epic")
	@Feature("FEATURE - Doing Google Search")
	@Story("STORY - Google")
	@Step("Step - Launching Browser")
	@Link("https://www.bing.com")
	@Description("Description of the Method - Launching Browser")
	public void test1startUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
	}

	@Test
	@Epic("EPIC - Google Search Epic")
	@Feature("FEATURE - Doing Google Search")
	@Story("STORY - Google")
	@Step("Step - Doing Some Google Search")
	@Description("Description of the Method - Doing Gogole Search")
	public void test2googleSearch() throws InterruptedException {
		driver.findElement(By.name("q")).sendKeys("Allure Report" + Keys.ENTER);
		Thread.sleep(2000);
		driver.navigate().back();
	}

	@Test
	@Epic("EPIC - Google Search Epic")
	@Feature("FEATURE - Doing Google Search")
	@Story("STORY - Google")
	@Step("Step - Validating Title of Google Page")
	@Description("Description of the Method - Validating Title of The Page")
	public void test3validatingTitleOfThePage() {
		junit.framework.Assert.assertEquals("Google", driver.getTitle());
		Allure.addAttachment("Google Image",
				new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
		assertTrue(false);
	}

	@Test
	@Epic("EPIC - Google Search Epic")
	@Feature("FEATURE - Doing Google Search")
	@Story("STORY - Google")
	@Step("Step - Closing Browser")
	@Description("Description of the Method - Closing Browser")
	public void test4tearDown() {
		driver.close();
	}

}
