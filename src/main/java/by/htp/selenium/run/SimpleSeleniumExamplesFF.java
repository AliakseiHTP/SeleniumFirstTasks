package by.htp.selenium.run;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class SimpleSeleniumExamplesFF {
	
	private static final String FF = "webdriver.gecko.driver";
	private static final String FF_PATH = "src//main//resources//geckodriver.exe";
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty(FF, FF_PATH);
		FirefoxProfile firefoxProfile = new FirefoxProfile();    
		firefoxProfile.setPreference("browser.privatebrowsing.autostart", true);
		
		WebDriver driverFF = new FirefoxDriver();
		driverFF.get("https://google.com");
		
		WebElement searchTbx = driverFF.findElement(By.name("q"));
		searchTbx.sendKeys("web driver 3 new features java 8 htp tat 9");
		searchTbx.submit();
		
		List<WebElement> resultList = driverFF.findElements(By.className("r"));
		int iCount = 1;
		for(WebElement el: resultList) {
			//String tagName = el.getTagName();
			//System.out.println(String.format("tagName %d - %s", iCount, tagName));
		
			//String aTag = el.findElement(By.xpath("a")).getTagName();
			//System.out.println(String.format("aTag %d - %s", iCount, tagName));
			
			WebElement a = el.findElement(By.xpath("a"));
			String linkName = a.getText();
			System.out.println(String.format("linkName %d - %s", iCount, linkName));
			iCount++;
		}
		
		Thread.sleep(5000);
		
		driverFF.close();
	}

}
