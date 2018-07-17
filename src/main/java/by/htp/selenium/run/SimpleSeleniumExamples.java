package by.htp.selenium.run;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import by.htp.selenium.entity.Use;

public class SimpleSeleniumExamples {
	private static final String CHROME = "webdriver.chrome.driver";
	private static final String CHROME_PATH = "src//main//resources//chromedriver.exe";
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty(CHROME, CHROME_PATH);
		WebDriver driverCH = new ChromeDriver();
		driverCH.manage().window().maximize();
		driverCH.get("https://google.com");
		String searchPhrase = "web driver 3 new features java 8 htp tat 9";
		String resultOfSearch = "";
		
		WebElement searchTbx = driverCH.findElement(By.name("q"));
		searchTbx.sendKeys(searchPhrase);
		searchTbx.submit();
		
		WebElement searchResultsLb = driverCH.findElement(By.id("resultStats"));
		String sResultStats = searchResultsLb.getText().replaceAll("(^[^ ]* [^ ]* )|[ ]+\\((.*)\\)", "").replaceAll(" ", "");
		
		
		if(searchResultsLb.isDisplayed()) {
			Thread.sleep(3000);
			String sTitle = driverCH.getTitle();
			if((sTitle.replaceAll(" - Поиск в Google", "")).equals(searchPhrase)) {
				System.out.println("True title");
			} else System.out.println("False title");
			System.out.println("");
		}
		
//		List<WebElement> resultList = driverCH.findElements(By.className("r"));
//		int iCount = 1;
//		for(WebElement el: resultList) {
//			//String tagName = el.getTagName();
//			//System.out.println(String.format("tagName %d - %s", iCount, tagName));
//		
//			//String aTag = el.findElement(By.xpath("a")).getTagName();
//			//System.out.println(String.format("aTag %d - %s", iCount, tagName));
//			
//			WebElement a = el.findElement(By.xpath("a"));
//			String linkName = a.getText();
//			System.out.println(String.format("linkName %d - %s", iCount, linkName));
//			iCount++;
//			}
	
		Use use = new Use();
		int iCount = 0, iCountFinal = 0;
		
		WebElement nextPageBtn = driverCH.findElement(By.id("pnnext"));
		WebElement logoLb = null;
		List<WebElement> pageList = driverCH.findElements(By.xpath("//a[contains(@aria-label,'Page')]"));
		
//		for (int i = 0; i < pageList.size(); i++) {
//			iCount = use.getCountOfResultOfSearch(driverCH);
//			iCountFinal = iCountFinal + iCount;
//			System.out.println(iCountFinal);
//			nextPageBtn = driverCH.findElement(By.id("pnnext"));;
//			nextPageBtn.isDisplayed();
//			nextPageBtn.click();
//			Thread.sleep(2000);
//			if ()
//			pageList = driverCH.findElements(By.xpath("//a[contains(@aria-label,'Page')]"));
//		}
		
		
		do {
			iCount = use.getCountOfResultOfSearch(driverCH);
			iCountFinal = iCountFinal + iCount;
			System.out.println(iCountFinal);
			nextPageBtn = driverCH.findElement(By.id("pnnext"));
			nextPageBtn.click();
			Thread.sleep(5000);
			logoLb = driverCH.findElement(By.name("btnG"));
		} while (driverCH.findElement(By.id("pnnext")) != null);
		
		System.out.println(iCountFinal);
		searchResultsLb = driverCH.findElement(By.id("resultStats"));
		sResultStats = searchResultsLb.getText().replaceAll("^[\\D]+", "").replaceAll("\\,.*$", "").replaceAll(" ","");
		System.out.println(sResultStats);
		if(sResultStats.equals(Integer.toString(iCountFinal))) {
			System.out.println("results compare");
		} else System.out.println("results do not compare");
		
		Thread.sleep(5000);
		
		driverCH.close();
	}

}
