
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCases {

	public static Logger log = Logger.getLogger(TestCases.class);

	public static void main(String[] args) {

		PropertyConfigurator
				.configure(System.getProperty("user.dir") + "\\src\\test\\resources\\Properties\\loj4g.properties");

		log.info("first message");
	}

	@Test(dataProvider = "getData")
	public void login(String username, String password) {
		System.out.println(username + "------" + password);
	}

	@DataProvider
	public Object[][] getData() {
		return null;

	}
}