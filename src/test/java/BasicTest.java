import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BasicTest {

	public static WebDriver driver;
	public static Properties OR = new Properties();
	public static Properties Config = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger(BasicTest.class);
	public static WebDriverWait wait;
	public static String fileName;
	public static WebElement dropdown;

	@BeforeSuite
	public static void setUp() {
		if (driver == null) {
			PropertyConfigurator
					.configure(System.getProperty("user.dir") + "\\src\\test\\resources\\Properties\\loj4g.properties");

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\Properties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Config.load(fis);
				log.info("Config file loaded!!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\Properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
				log.info("OR file Loaded!!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (Config.getProperty("browser").equals("firefox")) {
				driver = new FirefoxDriver();
				log.info("Firefox launched!!");
			} else if (Config.getProperty("browser").equals("chrome")) {
				driver = new ChromeDriver();
				log.info("Chrome launched!!");
			} else if (Config.getProperty("browser").equals("ie")) {
				driver = new InternetExplorerDriver();
				log.info("Internet Explorer launched!!");
			}

			driver.get(Config.getProperty("siteurl"));
			log.info("Navigation to :" + Config.getProperty("siteurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, Integer.parseInt(Config.getProperty("explicit.wait")));
		}
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
			log.error("error while clicking on an Element : " + locatorKey);
			Assert.fail("Error while clicking an Element : " + locatorKey);
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
			log.info("Typing in an Element : " + locatorKey + " entered the value: " + value);
		} catch (Throwable e) {

			log.info("Error while Typing in an Element: " + locatorKey);
			log.error(e.getMessage());
		}
	}
	
	public static void select(String locatorKey, String value) {
		
			if (locatorKey.endsWith("_XPATH")) {
				dropdown = driver.findElement(By.xpath(OR.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_CSS")) {
				dropdown = driver.findElement(By.cssSelector(OR.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_ID")) {
				dropdown = driver.findElement(By.id(OR.getProperty(locatorKey)));
			}
			Select select = new Select(dropdown);
			select.selectByVisibleText(value);
			log.info("Selecting in an Element : " + locatorKey + " the value: " + value);
		
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
			log.info("Error while finding an element: " + locatorKey + " exception message is: " + e.getMessage());
			return false;
		}
	}

	public static void captureScreenshot() throws IOException {
		Date d = new Date();
		fileName = d.toString().replace(" ", "_").replace(":", "_") + ".jpg";
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(".\\screenshots\\"+ fileName));
//		File destination = new File(path);
//		FileUtils.copyFile(source, destination);
		
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
		log.info("Test execution completed");
	}
}
