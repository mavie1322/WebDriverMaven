import org.testng.annotations.Test;

public class OpenAccountTest extends BasicTest {
	@Test
	public void openAccount() {
		click("openAccount_CSS");
		select("customer_CSS", "Harry Potter");
		select("currency_CSS", "Pound" );
		click("processBtn_CSS");
	}

}
