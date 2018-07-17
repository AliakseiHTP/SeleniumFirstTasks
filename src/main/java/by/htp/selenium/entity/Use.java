package by.htp.selenium.entity;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Use {
	public int getCountOfResultOfSearch(WebDriver driverCH) {
		List<WebElement> resultList = driverCH.findElements(By.className("r"));
		int iCount = 0;
		for(WebElement el: resultList) {
			//String tagName = el.getTagName();
			//System.out.println(String.format("tagName %d - %s", iCount, tagName));
		
			//String aTag = el.findElement(By.xpath("a")).getTagName();
			//System.out.println(String.format("aTag %d - %s", iCount, tagName));
			
			WebElement a = el.findElement(By.xpath("a"));
			String linkName = a.getText();
			//System.out.println(String.format("linkName %d - %s", iCount, linkName));
			iCount++;
			}
		return iCount;
		}
}
