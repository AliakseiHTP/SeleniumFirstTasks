package run.homework;

import entity.BaseMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.List;

import static entity.BaseMethod.isPresentXpath;

public class TaskSelenium5{
    private static final String CHROME = "webdriver.chrome.driver";
    private static final String CHROME_PATH = "src//main//resources//chromedriver.exe";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty(CHROME, CHROME_PATH);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(Arrays.asList("--incognito", "--start-maximized","--lang=ru"));
        WebDriver driverCH = new ChromeDriver(chromeOptions);
        driverCH.get("http://www.it-academy.by/");

        WebElement studyBtn = driverCH.findElement(By.xpath("//li//a[@href='/specialization/']"));
        BaseMethod bm = new BaseMethod();
        bm.moveMouseOn(driverCH,studyBtn);

        List<WebElement> categoryList = driverCH.findElements(By.xpath("//li[@class='panel-section-list__item']//span[@class='list-item__category-header']"));
        for(int i = 0; i<categoryList.size(); i++){
            WebElement category = driverCH.findElement(By.xpath(String.format("(//li[@class='panel-section-list__item']//span[@class='list-item__category-header'])[%d]",i+1)));
            System.out.println(category.getText().replaceAll("\u00AD",""));
            List<WebElement> subcategoryList = driverCH.findElements(By.xpath(String.format("(//li[@class='panel-section-list__item']//span[@class='list-item__category-header'])[%d]/../..//a[@class='list-subitem__page-link']",i+1)));
            for(int j = 0; j<subcategoryList.size();j++){
                WebElement subcategory = driverCH.findElement(By.xpath(String.format("((//li[@class='panel-section-list__item']//span[@class='list-item__category-header'])[%d]/../..//a[@class='list-subitem__page-link'])[%d]",i+1,j+1)));
                System.out.println(String.format("     %s",subcategory.getText().replaceAll("\u00AD","")));
            }
        }

        WebElement coursesBtn = driverCH.findElement(By.xpath("//li[@class='panel-section-list__item']/a[@href='/specialization/beslpatnye-kursy/']"));
        coursesBtn.click();
        Thread.sleep(2000);

        System.out.println();

        List<WebElement> coursesList = driverCH.findElements(By.xpath("//h2[@class='course-item-block__title']"));
        int iCount = 0;
        for(int i = 0; i < coursesList.size(); i++){
            WebElement course = driverCH.findElement(By.xpath(String.format("(//h2[@class='course-item-block__title'])[%d]",i+1)));
            System.out.println(String.format("Name %d - %s", i+1, course.getText()));
            if(isPresentXpath(driverCH,String.format("(//h2[@class='course-item-block__title'])[%d]/..//div[@class='course-item__date']",i+1))){
                WebElement dateCourse = driverCH.findElement(By.xpath(String.format("(//h2[@class='course-item-block__title'])[%d]/..//div[@class='course-item__date']",i+1)));
                System.out.println(String.format("Date - %s", dateCourse.getText()));
            }
            System.out.println();
            iCount++;
        }

        driverCH.close();
    }
}
