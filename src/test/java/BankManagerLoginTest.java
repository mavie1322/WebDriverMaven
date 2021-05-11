import org.testng.Assert;
import org.testng.annotations.Test;

public class BankManagerLoginTest extends BasicTest {

	@Test
	public void loginAsBankManager() {
		click("bmlBtn_CSS");
		Assert.assertTrue(isElementPresent("addCustBtn_CSS"), "Add customer button doesn't exist");

	}
}
