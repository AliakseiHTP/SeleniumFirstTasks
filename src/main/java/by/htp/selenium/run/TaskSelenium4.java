package by.htp.selenium.run;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TaskSelenium4 {

	private static final String CHROME = "webdriver.chrome.driver";
	private static final String CHROME_PATH = "src//main//resources//chromedriver.exe";
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty(CHROME, CHROME_PATH);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		WebDriver driverCH = new ChromeDriver(capabilities);
		driverCH.manage().window().maximize();
		driverCH.get("http://www.it-academy.by/");
		WebElement studyBtn = driverCH.findElement(By.xpath("//li//a[@href='/specialization/']"));
		studyBtn.click(); //move mouse on
	}
	
}
