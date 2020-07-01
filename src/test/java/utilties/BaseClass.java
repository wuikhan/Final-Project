package utilties;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class BaseClass {
	public static WebDriver driver;
	public static void setup(String browserName) {
		String osName = System.getProperty("os.name");
		if (browserName.equalsIgnoreCase("Chrome")) {
			if (osName.equals("Mac OS X")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver");
				driver = new ChromeDriver();
				
			} else {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}
		} else {
			System.out.println("Invalid browser");
		}
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
