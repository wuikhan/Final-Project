package utilties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseClass {

	public static WebDriver driver;
	public static Properties readProperty;

	public static void setup(String browserName) {
		String osName = System.getProperty("os.name");
		if (osName.equalsIgnoreCase("Mac OS X")) {
			if (browserName.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver");
				driver = new ChromeDriver();
			}
		} else if (osName.equals("Windows 10")) {
			if (browserName.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}
		} else if (osName.equals("Linux")) {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setJavascriptEnabled(true); // not really needed: JS enabled by default
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
					System.getProperty("user.dir") + "/Drivers/phantomjs");
			driver = new PhantomJSDriver(caps);
		} else {
			System.out.println("Driver is not configured for this Operating System.");
		}
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public Properties initProperty(String filePath) throws IOException {
		// Create an object of Properties class to access getProperty method
		readProperty = new Properties();
		// Create an object of FileInputStream class to read the data
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + filePath);
			readProperty.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return readProperty;
	}

	public Object[][] readDataFromExcel(String filePath, int sheetNumber) throws IOException {
		String datafile = System.getProperty("user.dir") + filePath;
		FileInputStream fis = new FileInputStream(datafile);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(sheetNumber);
		int totalRows = sheet.getLastRowNum();
		int totalCol = sheet.getRow(0).getLastCellNum();
		Object[][] setData = new Object[totalRows][totalCol];
		for (int i = 1; i <= totalRows; i++) {
			for (int j = 0; j < totalCol; j++) {
				setData[i - 1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return setData;
	}
	
	
}
