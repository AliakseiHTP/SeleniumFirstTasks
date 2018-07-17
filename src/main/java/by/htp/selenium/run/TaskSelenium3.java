package by.htp.selenium.run;



import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TaskSelenium3 {
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
		driverCH.get("http://www.quizful.net/");
		WebElement regBtn = driverCH.findElement(By.xpath("//li/a[@href='/LoginAction.registration']"));
		regBtn.click();
		Thread.sleep(5000);
		WebElement loginTbx = driverCH.findElement(By.name("registrationForm.login"));
		loginTbx.sendKeys("All");
		WebElement passTbx = driverCH.findElement(By.name("registrationForm.password"));
		passTbx.sendKeys("123456");
		WebElement repassTbx = driverCH.findElement(By.name("registrationForm.repassword"));
		repassTbx.sendKeys("123456");
		WebElement emailTbx = driverCH.findElement(By.name("registrationForm.email"));
		emailTbx.sendKeys("kazakfortesting@gmail.com");
		WebElement corporateTbx = driverCH.findElement(By.name("registrationForm.corporate"));
		corporateTbx.click();
		
		String captchaVal = JOptionPane.showInputDialog("Please enter the captcha value:");
		driverCH.findElement(By.name("registrationForm.captcha")).sendKeys(captchaVal);
		
		WebElement submitTbx = driverCH.findElement(By.name("ok"));
		submitTbx.click();
	}

}
