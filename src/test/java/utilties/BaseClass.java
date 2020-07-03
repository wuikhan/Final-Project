package utilties;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
public class BaseClass {
	
	public static WebDriver driver;
	public static void setup(String browserName) {
		String osName = System.getProperty("os.name");
		if (browserName.equalsIgnoreCase("Chrome")) {
			if (osName.equals("Mac OS X")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver");
				driver = new ChromeDriver();
			} else if(osName.equals("Windows 10")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (osName.equals("Linux")) {
				 DesiredCapabilities caps = new DesiredCapabilities();
				 caps.setJavascriptEnabled(true); // not really needed: JS enabled by default
				 caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
				 System.getProperty("user.dir") + "/Drivers/phantomjs");
				 driver = new PhantomJSDriver(caps);
			}
		} else {
			System.out.println("Invalid browser");
		}
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
