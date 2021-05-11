package Rough;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.opera.OperaDriver;

import Pages.HomePage;

public class TestLogin {

	public static void main(String[] args) {
		//System.setProperty("webdriver.msedge.driver", "C:\\Users\\mavie\\Documents\\Application\\Java\\Drivers\\msedgedriver.exe");
		WebDriver driver = new OperaDriver();
		driver.get("https://www.facebook.com/");
		HomePage home = new HomePage();
		home.doLogin("mavie1322@yahoo.fr","Markalek2015" );

	}

}
