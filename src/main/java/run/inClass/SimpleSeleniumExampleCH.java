package run.inClass;

import entity.BaseMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.List;

public class SimpleSeleniumExampleCH {
    private static final String CHROME = "webdriver.chrome.driver";
    private static final String CHROME_PATH = "src//main//resources//chromedriver.exe";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty(CHROME, CHROME_PATH);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(Arrays.asList("--incognito", "--start-maximized"));
        WebDriver driverCH = new ChromeDriver(chromeOptions);
        driverCH.get("https://google.com");
        String searchPhrase = "web driver 3 new features java 8 htp tat 9";

        WebElement searchTbx = driverCH.findElement(By.name("q"));
        searchTbx.sendKeys(searchPhrase);
        searchTbx.submit();

		List<WebElement> resultList = driverCH.findElements(By.className("r"));
		int iCount = 0;
		for(WebElement el: resultList) {
			//String tagName = el.getTagName();
			//System.out.println(String.format("tagName %d - %s", iCount, tagName));

			//String aTag = el.findElement(By.xpath("a")).getTagName();
			//System.out.println(String.format("aTag %d - %s", iCount, tagName));

			WebElement a = el.findElement(By.xpath("a"));
			String linkName = a.getText();
			System.out.println(String.format("linkName %d - %s", iCount+1, linkName));
			iCount++;
			}

        Thread.sleep(5000);

        driverCH.close();
    }
}
