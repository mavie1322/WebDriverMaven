package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;

	public void doLogin(String email, String password) {
		driver.findElement(By.cssSelector("input#email")).sendKeys(email);
		driver.findElement(By.cssSelector("input#pass")).sendKeys(password);
		driver.findElement(By.cssSelector("button#u_0_d_oR")).click();
	}
	
	public void createNewAccount() {
		driver.findElement(By.linkText("Create New Account")).click();
	}
	
	public void forgottenPassword() {
		driver.findElement(By.linkText("Forgotten password?")).click();
	}
}
