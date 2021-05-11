
import org.testng.annotations.Test;

public class AddCustomerTest extends BasicTest {
	@Test
	public void addCustomer() {
		click("addCustBtn_CSS");
		type("firstName_CSS", "Gladys");
		type("lastName_CSS", "Bahel");
		type("postCode_CSS", "M11 4DG");
		click("addCustomer_CSS");
		driver.switchTo().alert().accept();
		
		
	}
	
}
