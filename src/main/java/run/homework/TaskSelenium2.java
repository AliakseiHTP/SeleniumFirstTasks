package run.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.List;

public class TaskSelenium2 {
    private static final String CHROME = "webdriver.chrome.driver";
    private static final String CHROME_PATH = "src//main//resources//chromedriver.exe";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty(CHROME, CHROME_PATH);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(Arrays.asList("--incognito", "--start-maximized","--lang=ru"));
        WebDriver driverCH = new ChromeDriver(chromeOptions);
        driverCH.get("https://www.tut.by/");

        WebElement headerLink = driverCH.findElement(By.xpath("//a[@class='header_link io-block-link']"));
        headerLink.click();
        Thread.sleep(5000);
        List<WebElement> listOfParagraph = driverCH.findElements(By.xpath("//div[@id='article_body']/p"));
        System.out.println(String.format("Paragraphs are %d", listOfParagraph.size()));

        driverCH.close();
    }
}
