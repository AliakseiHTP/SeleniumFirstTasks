package run.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;

import static entity.BaseMethod.*;
import static entity.PropertyManager.getProperty;

public class TaskSelenium4 {
    private static final String CHROME = "webdriver.chrome.driver";
    private static final String CHROME_PATH = "src//main//resources//chromedriver.exe";
    private static final String LOGIN = getProperty("login");
    private static final String PASSWORD = getProperty("password");
    private static final String NAME = getProperty("name");
    private static final String SURNAME = getProperty("surname");
    private static final String BIRTHYEAR = getProperty("birthyear");
    private static final String SITE = getProperty("site");
    private static final String COMPANY = getProperty("company");
    private static final String ABOUT_MY_SELF = getProperty("about_my_self");

    public static void main(String[] args) throws InterruptedException {
        System.setProperty(CHROME, CHROME_PATH);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(Arrays.asList("--incognito", "--start-maximized","--lang=ru"));
        WebDriver driverCH = new ChromeDriver(chromeOptions);
        driverCH.get("http://www.quizful.net/");

        WebElement loginFormBtn = driverCH.findElement(By.xpath("//li/a[@href='/LoginAction.loginForm']"));
        loginFormBtn.click();
        Thread.sleep(2000);
        WebElement loginTbx = driverCH.findElement(By.name("loginForm.login"));
        loginTbx.sendKeys(LOGIN);
        WebElement passTbx = driverCH.findElement(By.name("loginForm.password"));
        passTbx.sendKeys(PASSWORD);
        WebElement submitTbx = driverCH.findElement(By.name("ok"));
        submitTbx.click();
        Thread.sleep(2000);

        WebElement loginBtn = driverCH.findElement(By.xpath(String.format("//b/a[@href='/user/%s']",LOGIN)));
        loginBtn.click();
        Thread.sleep(1000);
        WebElement settingsBtn = driverCH.findElement(By.xpath("//a[@href='/ProfileAction.settings']"));
        settingsBtn.click();
        Thread.sleep(1000);
        ////////
        WebElement personalDataBtn = driverCH.findElement(By.xpath("//div[@id='profile-personal-form']//div[@class='title']"));
        personalDataBtn.click();
        Thread.sleep(1000);

        WebElement nameTxb = element(driverCH,"personalForm.name");
        nameTxb.clear();
        nameTxb.sendKeys(NAME);
        WebElement surnameTxb = element(driverCH,"personalForm.surname");
        surnameTxb.clear();
        surnameTxb.sendKeys(SURNAME);
        WebElement birthdayTxb = element(driverCH,"personalForm.birthyear");
        birthdayTxb.clear();
        birthdayTxb.sendKeys(BIRTHYEAR);
        WebElement siteTxb = element(driverCH,"personalForm.site");
        siteTxb.clear();
        siteTxb.sendKeys(SITE);
        WebElement companyTxb = element(driverCH,"personalForm.company");
        companyTxb.clear();
        companyTxb.sendKeys(COMPANY);

        selectValue(driverCH,"//select[@name='personalForm.countryId']","XisgEe4sJp28");
        Thread.sleep(1000);
        selectValue(driverCH,"//select[@name='personalForm.cityId']","j2qeW9Vqj3cB");
        Thread.sleep(1000);
        selectValue(driverCH,"//select[@name='personalForm.zone']","Europe/Minsk");
        Thread.sleep(1000);

        uploadFile(driverCH,"photo.jpg");

        WebElement aboutMySelfTxb = element(driverCH,"personalForm.about");
        aboutMySelfTxb.clear();
        aboutMySelfTxb.sendKeys(ABOUT_MY_SELF);

        WebElement saveDataBtn = element(driverCH,"personalForm.save");
        saveDataBtn.click();
        Thread.sleep(1000);
        ////////
        settingsBtn = driverCH.findElement(By.xpath("//a[@href='/ProfileAction.settings']"));
        settingsBtn.click();
        Thread.sleep(1000);
        WebElement notificationBtn = driverCH.findElement(By.xpath("//div[@id='profile-notifications-form']//div[@class='title']"));
        notificationBtn.click();
        Thread.sleep(1000);

        if(isPresentXpath(driverCH,"//input[@name='notificationsForm.notificationsEnabled'][@checked='checked']")){
            WebElement turnOnNotificationTxb = element(driverCH,"notificationsForm.notificationsEnabled");
            turnOnNotificationTxb.click();
        } else {
            WebElement turnOnNotificationTxb = element(driverCH,"notificationsForm.notificationsEnabled");
            turnOnNotificationTxb.click();
            turnOnNotificationTxb.click();
        }

        if(isPresentXpath(driverCH,"//input[@name='notificationsForm.deliveryEnabled'][@checked='checked']")){
            WebElement turnOnDispatchTxb = element(driverCH,"notificationsForm.deliveryEnabled");
            turnOnDispatchTxb.click();
        } else {
            WebElement turnOnDispatchTxb = element(driverCH,"notificationsForm.deliveryEnabled");
            turnOnDispatchTxb.click();
            turnOnDispatchTxb.click();
        }
        Thread.sleep(1000);
        WebElement saveNotificationsBtn = element(driverCH,"notificationsForm.save");
        saveNotificationsBtn.click();
        Thread.sleep(1000);
        //////
        settingsBtn = driverCH.findElement(By.xpath("//a[@href='/ProfileAction.settings']"));
        settingsBtn.click();
        Thread.sleep(1000);
        WebElement privacyBtn = driverCH.findElement(By.xpath("//div[@id='profile-privacy-form']//div[@class='title']"));
        privacyBtn.click();
        Thread.sleep(1000);
        WebElement justMeTxb = elementXpath(driverCH,"//input[@name='privacyForm.profileVisibility'][@value='closed']");
        justMeTxb.click();
        WebElement savePrivacyBtn = element(driverCH,"privacyForm.save");
        savePrivacyBtn.click();
        Thread.sleep(1000);

        driverCH.close();
    }
}
