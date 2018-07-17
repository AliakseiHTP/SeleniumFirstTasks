package by.htp.selenium.run;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskSelenium2 {
	private static final String CHROME = "webdriver.chrome.driver";
	private static final String CHROME_PATH = "src//main//resources//chromedriver.exe";
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty(CHROME, CHROME_PATH);
		WebDriver driverCH = new ChromeDriver();
		driverCH.manage().window().maximize();
		driverCH.get("https://www.tut.by/");
		WebElement headerLink = driverCH.findElement(By.xpath("//a[@class='header_link io-block-link']"));
		headerLink.click();
		Thread.sleep(5000);
		List<WebElement> listOfParagraph = driverCH.findElements(By.xpath("//div[@id='article_body']/p"));
		System.out.println(String.format("Paragraphes are %d", listOfParagraph.size()));
		
		driverCH.close();
	}
}
