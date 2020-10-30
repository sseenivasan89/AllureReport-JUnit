package Report.AllureJunit;

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
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BingSearch {
	public static WebDriver driver;

	@Test
	@Epic("EPIC - Bing Search Epic")
	@Feature("FEATURE - Doing Bing Search")
	@Story("STORY - Bing")
	@Step("Step - Launching Browser")
	@Link("https://www.bing.com")
	@Description("Description of the Method - Launching Browser")
	public void test1startUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.bing.com");
	}

	@Test
	@Epic("EPIC - Bing Search Epic")
	@Feature("FEATURE - Doing Bing Search")
	@Story("STORY - Bing")
	@Step("Step - Doing Some Bing Search")
	@Description("Description of the Method - Doing Bing Search")
	@Severity(SeverityLevel.CRITICAL)
	public void test2bingSearch() throws InterruptedException {
		driver.findElement(By.name("q")).sendKeys("Allure Report" + Keys.ENTER);
		Thread.sleep(2000);
		driver.navigate().back();
	}

	@Test
	@Epic("EPIC - Bing Search Epic")
	@Feature("FEATURE - Doing Bing Search")
	@Story("STORY - Bing")
	@Step("Step - Validating Title of Bing Page")
	@Description("Description of the Method - Validating Title of The Page")
	public void test3validatingTitleOfThePage() {
		junit.framework.Assert.assertEquals("Bing", driver.getTitle());
		Allure.addAttachment("Bing Image",
				new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
	}

	@Test
	@Epic("EPIC - Bing Search Epic")
	@Feature("FEATURE - Doing Bing Search")
	@Story("STORY - Bing")
	@Step("Step - Closing Browser")
	@Description("Description of the Method - Closing Browser")
	public void test4tearDown() {
		driver.close();
	}

}
