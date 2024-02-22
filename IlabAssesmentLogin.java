import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class IlabAssesmentLogin {

	public static void main(String[] args) throws Exception {

		try {
			System.setProperty("webdriver.gecko.marionette", "C:\\Selenuim webdriver\\FireFoxDriver\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			driver.get("https://adactinhotelapp.com/index.php");

			// UserLogin
			driver.findElement(By.id("username")).sendKeys("AutotestB");
			Thread.sleep(3001);
			driver.findElement(By.id("password")).sendKeys("W858OZ");
			takeScreenShot(driver);
			Thread.sleep(3001);
			driver.findElement(By.id("login")).click();

			Thread.sleep(5001);
			// Search Hotel & Rooms
			takeScreenShot(driver);
			selectDropdownOption("//*[@id=\'location\']", "Paris", driver);
			Thread.sleep(5001);
			selectDropdownOption("//*[@id=\"hotels\"]", "Hotel Sunshine", driver);
			Thread.sleep(5001);
			selectDropdownOption("//*[@id=\"room_type\"]", "Double", driver);
			Thread.sleep(5001);
			selectDropdownOption("//*[@id=\"room_nos\"]", "5 - Five", driver);
			takeScreenShot(driver);

			// populate Dates
			Thread.sleep(3001);
			takeScreenShot(driver);
			driver.findElement(By.id("datepick_in")).clear();
			Thread.sleep(3001);
			takeScreenShot(driver);
			driver.findElement(By.id("datepick_in")).sendKeys("05/06/2024");
			Thread.sleep(3001);
			takeScreenShot(driver);
			driver.findElement(By.id("datepick_out")).clear();
			takeScreenShot(driver);
			Thread.sleep(3001);
			driver.findElement(By.id("datepick_out")).sendKeys("05/07/2024");
			takeScreenShot(driver);

			// populate Occupants
			Thread.sleep(5001);
			selectDropdownOption("//*[@id=\"adult_room\"]", "2 - Two", driver);
			Thread.sleep(5001);
			selectDropdownOption("//*[@id=\"child_room\"]", "2 - Two", driver);
			takeScreenShot(driver);
			// Submit
			driver.findElement(By.id("Submit")).click();

			// select Hotel
			takeScreenShot(driver);
			Thread.sleep(5001);
			driver.findElement(By.id("radiobutton_0")).click();
			takeScreenShot(driver);
			Thread.sleep(5001);

			// Click Continue
			Thread.sleep(5001);
			takeScreenShot(driver);
			Thread.sleep(5001);
			driver.findElement(By.id("continue")).click();

			scrollDown(driver);
			Thread.sleep(5001);
			driver.findElement(By.id("first_name")).sendKeys("Gcinumzi");
			Thread.sleep(3001);
			driver.findElement(By.id("last_name")).sendKeys("Gwiliza");
			Thread.sleep(3001);
			driver.findElement(By.id("address")).sendKeys("1 enterprise Road Randburg");
			Thread.sleep(3001);
			driver.findElement(By.id("cc_num")).sendKeys("1454 5698 5462 5421");
			takeScreenShot(driver);
			Thread.sleep(3001);
			selectDropdownOption("//*[@id=\"cc_type\"]", "VISA", driver);
			Thread.sleep(3001);
			selectDropdownOption("//*[@id=\"cc_exp_month\"]", "October", driver);
			Thread.sleep(3001);
			takeScreenShot(driver);
			selectDropdownOption("//*[@id=\"cc_exp_year\"]", "2028", driver);
			Thread.sleep(3001);
			scrollDown(driver);
			driver.findElement(By.id("cc_cvv")).sendKeys("785");
			takeScreenShot(driver);
			driver.findElement(By.id("book_now")).click();

			Thread.sleep(5001);
			takeScreenShot(driver);
			scrollDown(driver);
			takeScreenShot(driver);
			Thread.sleep(3001);
			driver.findElement(By.id("logout")).click();
			System.out.println("Successful");
		} catch (Exception e) {
			System.out.println("An error has occured please try again");
		}
	}

	public static void selectDropdownOption(String xpath, String option, WebDriver driver) {
		try {
			Thread.sleep(2001);
			WebElement dropdown;
			dropdown = driver.findElement(By.xpath(xpath));
			Select select = new Select(dropdown);
			select.selectByVisibleText(option);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void scrollDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}

	public static void takeScreenShot(WebDriver driver) throws Exception {

		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			System.currentTimeMillis();
			String screenShotName = "c:\\tmp\\" + System.currentTimeMillis() + ".png";
			FileHandler.copy(scrFile, new File(screenShotName));
		} catch (Exception e) {
		}
	}

}
