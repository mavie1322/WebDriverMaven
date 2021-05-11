import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class TestProperties {
	public static WebDriver driver;
	public static Properties OR = new Properties();
	public static Logger log = Logger.getLogger(TestProperties.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void captureScreenshot() throws IOException {
		Date d = new Date();
		String filename = d.toString().replace(" ", "_") + ".jpg";
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(".//screenshots//" + filename));

	}

	public static void click(String locatorKey) {

		try {
			if (locatorKey.endsWith("_XPATH")) {
				driver.findElement(By.xpath(OR.getProperty(locatorKey))).click();
			} else if (locatorKey.endsWith("_CSS")) {
				driver.findElement(By.cssSelector(OR.getProperty(locatorKey))).click();
			} else if (locatorKey.endsWith("_ID")) {
				driver.findElement(By.id(OR.getProperty(locatorKey))).click();
			}
			log.info("Clicking on an Element: " + locatorKey);
		} catch (Throwable e) {

		}
	}

	public static void type(String locatorKey, String value) {
		try {
			if (locatorKey.endsWith("_XPATH")) {
				driver.findElement(By.xpath(OR.getProperty(locatorKey))).sendKeys(value);
			} else if (locatorKey.endsWith("_CSS")) {
				driver.findElement(By.cssSelector(OR.getProperty(locatorKey))).sendKeys(value);
			} else if (locatorKey.endsWith("_ID")) {
				driver.findElement(By.id(OR.getProperty(locatorKey))).sendKeys(value);
			}
			log.info("Typing in an Element : " + value + " entered the value: " + value);
		} catch (Throwable e) {

			log.info("Error while Typing in an Element: " + locatorKey);
			log.error(e.getMessage());
		}
	}

	public static boolean isElementPresent(String locatorKey) {
		try {
			if (locatorKey.endsWith("_XPATH")) {
				driver.findElement(By.xpath(OR.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_CSS")) {
				driver.findElement(By.cssSelector(OR.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_ID")) {
				driver.findElement(By.id(OR.getProperty(locatorKey)));
			}
			log.info("Finding the ELement : " + locatorKey);
			return true;
		} catch (Throwable e) {
			return false;
		}
	}

}
