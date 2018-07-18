package run.homework;

import entity.BaseMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;

public class TaskSelenium1 {
    private static final String CHROME = "webdriver.chrome.driver";
    private static final String CHROME_PATH = "src//main//resources//chromedriver.exe";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty(CHROME, CHROME_PATH);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(Arrays.asList("--incognito", "--start-maximized","--lang=ru"));
        WebDriver driverCH = new ChromeDriver(chromeOptions);
        driverCH.get("https://google.com");
        String searchPhrase = "web driver 3 new features java 8 htp tat 9";
        String sResultStats = "";
        BaseMethod use = new BaseMethod();
        int iCountFinal = 0;

        WebElement searchTbx = driverCH.findElement(By.name("q"));
        searchTbx.sendKeys(searchPhrase);
        searchTbx.submit();

        WebElement searchResultsLb = driverCH.findElement(By.id("resultStats"));
        //String sResultStats = searchResultsLb.getText().replaceAll("(^[^ ]* [^ ]* )|[ ]+\\((.*)\\)", "").replaceAll(" ", "");
        //System.out.println(sResultStats);

        if(searchResultsLb.isDisplayed()) {
            Thread.sleep(3000);
            String sTitle = driverCH.getTitle();
            if((sTitle.replaceAll(" - Поиск в Google", "")).equals(searchPhrase)) {
                System.out.println("True title");
            } else System.out.println("False title");
            System.out.println();
        }


        iCountFinal = use.clickAllPages(driverCH);
        searchResultsLb = driverCH.findElement(By.id("resultStats"));
        sResultStats = searchResultsLb.getText().replaceAll("^[\\D]+", "").replaceAll("\\,.*$", "").replaceAll(" ","");
        if(sResultStats.equals(Integer.toString(iCountFinal))) {
            System.out.println(String.format("results compare %s = %d",sResultStats,iCountFinal));
        } else System.out.println(String.format("results do not compare %s != %d",sResultStats,iCountFinal));

        driverCH.close();
    }
}
