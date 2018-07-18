package entity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

import static entity.PropertyManager.getProperty;
import static java.lang.Math.random;

public class BaseMethod {
    int iCount = 0;
    private static final String UPLOAD_FOLDER = getProperty("uploadFolder");

    private int getCountOfResultOfSearch(WebDriver driver) {
        List<WebElement> resultList = driver.findElements(By.className("r"));
        int iCount = 0;
        for(WebElement el: resultList) {
            WebElement a = el.findElement(By.xpath("a"));
            String linkName = a.getText();
            //System.out.println(String.format("linkName %d - %s", iCount, linkName));
            iCount++;
        }
        return iCount;
    }

    public static boolean isPresent(WebDriver driver, String id) throws InterruptedException {
        Thread.sleep(1000);
        return driver.findElements(By.id(id)).size() > 0;
    }

    public static boolean isPresentXpath(WebDriver driver, String xpath) throws InterruptedException {
        Thread.sleep(1000);
        return driver.findElements(By.xpath(xpath)).size() > 0;
    }

    public int clickAllPages(WebDriver driver) throws InterruptedException {
        iCount += getCountOfResultOfSearch(driver);
        //System.out.println(iCount);

        if(isPresent(driver,"pnnext")) {
            WebElement nextBtn = driver.findElement(By.id("pnnext"));
            //System.out.println(buttonNext.isDisplayed());
            nextBtn.click();
            clickAllPages(driver);
            Thread.sleep(1000);
        }
        return iCount;
    }

    public static int set_iRandom_number(int iFrom, int iTo) {
        return iFrom + (int) (random() * iTo);
    }

    public static void uploadFile(WebDriver driver, String sNameOfFile){
        WebElement element = driver.findElement(By.xpath("//input[@type='file']"));
        File file = new File(String.format("%s%s",UPLOAD_FOLDER,sNameOfFile));
        try {
            element.sendKeys(file.getAbsolutePath().replaceAll("\\\\target",""));
            Thread.sleep(2000);
            System.out.println(String.format("fileUpload - %s",sNameOfFile));
        }
        catch(Exception e) {
            System.out.println(String.format("loc.fileNotUpload - %s",sNameOfFile));
        }
    }

    public static WebElement element(WebDriver driver, String s){
        return driver.findElement(By.name(s));
    }

    public static WebElement elementXpath(WebDriver driver, String s){
        return driver.findElement(By.xpath(s));
    }

    private static Select getSelect(WebElement element) {
        Select select = new Select(element);
        return select;
    }

    public static void selectValue(WebDriver driver,String s, String sValue) {
        WebElement element = driver.findElement(By.xpath(s));
        Select select = getSelect(element);
        select.selectByValue(sValue);
    }

    public void moveMouseOn(WebDriver driver, WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }
}
