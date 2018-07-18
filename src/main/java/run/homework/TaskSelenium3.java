package run.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.util.Arrays;

import static entity.BaseMethod.set_iRandom_number;
import static entity.PropertyManager.getProperty;

public class TaskSelenium3 {
    private static final String CHROME = "webdriver.chrome.driver";
    private static final String CHROME_PATH = "src//main//resources//chromedriver.exe";
    private static final String LOGIN = getProperty("login");
    private static final String PASSWORD = getProperty("password");
    private static final String EMAIL = getProperty("email");

    public static void main(String[] args) throws InterruptedException {
        System.setProperty(CHROME, CHROME_PATH);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(Arrays.asList("--incognito", "--start-maximized","--lang=ru"));
        WebDriver driverCH = new ChromeDriver(chromeOptions);
        driverCH.get("http://www.quizful.net/");

        WebElement regBtn = driverCH.findElement(By.xpath("//li/a[@href='/LoginAction.registration']"));
        regBtn.click();
        Thread.sleep(5000);
        WebElement loginTbx = driverCH.findElement(By.name("registrationForm.login"));
        loginTbx.sendKeys(String.format("%s%d",LOGIN,set_iRandom_number(1,100000)));
        WebElement passTbx = driverCH.findElement(By.name("registrationForm.password"));
        passTbx.sendKeys(PASSWORD);
        WebElement repassTbx = driverCH.findElement(By.name("registrationForm.repassword"));
        repassTbx.sendKeys(PASSWORD);
        WebElement emailTbx = driverCH.findElement(By.name("registrationForm.email"));
        emailTbx.sendKeys(String.format("%d%s",set_iRandom_number(1,100000),EMAIL));
        WebElement corporateTbx = driverCH.findElement(By.name("registrationForm.corporate"));
        corporateTbx.click();

        String captchaVal = JOptionPane.showInputDialog("Please enter the captcha value:");
        driverCH.findElement(By.name("registrationForm.captcha")).sendKeys(captchaVal);

        WebElement submitTbx = driverCH.findElement(By.name("ok"));
        submitTbx.click();
        
        driverCH.close();
    }
}
