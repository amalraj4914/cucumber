package com.cucumber.Cucumber;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Base {
	public static WebDriver driver;

	public static void browserLaunch(String values) { // 1
	if(values.equalsIgnoreCase("chrome")) {	
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\amalr\\amal\\Maven\\webdriver\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	}

	public static void maximize() { // 2
		driver.manage().window().maximize();
	}

	public static void get_Url(String values) { // 3
		driver.get(values);
	}

	public static void get_Title() { // 4
		String title = driver.getTitle();
		System.out.println(title);
	}

	public static void close() { // 5
		driver.close();
	}

	public static void quit() { // 6
		driver.quit();
	}

	public static void navigate_To(String url) { // 7
		driver.navigate().to(url);
	}

	public static void navigate_Back() { // 8
		driver.navigate().back();
	}

	public static void navigate_Forward() { // 9
		driver.navigate().forward();
	}

	public static void navigate_Refresh() { // 10
		driver.navigate().refresh();
	}

	public static WebElement elementId(String element) { // 11
		return driver.findElement(By.id(element));

	}

	public static WebElement elementName(String element) { // 12
		return driver.findElement(By.name(element));

	}

	public static WebElement css_Selector(String element) { // 13
		return driver.findElement(By.cssSelector(element));

	}

	public static WebElement linkText(String element) { // 14
		return driver.findElement(By.linkText(element));

	}

	public static WebElement partial_LinkText(String element) { // 15
		return driver.findElement(By.partialLinkText(element));

	}

	
	public static WebElement xpath(String element) {// 16
		return driver.findElement(By.xpath(element));
	}

	public static void simple_Alert() {// 17
		driver.switchTo().alert().accept();
	}

	public static void confirm_Alert(String value) {// 18
		if (value.equalsIgnoreCase("ok")) {
			driver.switchTo().alert().accept();
		} else if (value.equalsIgnoreCase("notok")) {
			driver.switchTo().alert().dismiss();
		}

	}

	public static void prompt_Alert(String keysToSend, String value) {// 19
		driver.switchTo().alert().sendKeys(keysToSend);
		if (value.equalsIgnoreCase("ok")) {
			driver.switchTo().alert().accept();
		} else if (value.equalsIgnoreCase("notok")) {
			driver.switchTo().alert().dismiss();

		}
	}

	public static void select(String xpath, String selectionMethod, String value2) {// 20
		WebElement element = driver.findElement(By.xpath(xpath));
		Select sel = new Select(element);
		if (selectionMethod.equalsIgnoreCase("selectbytext")) {
			sel.selectByVisibleText(value2);
		} else if (selectionMethod.equalsIgnoreCase("selectbyvalue")) {
			sel.selectByValue(value2);
		} else if (selectionMethod.equalsIgnoreCase("selectbyindex")) {
			int parseInt = Integer.parseInt(value2);
			sel.selectByIndex(parseInt);
		} else if (selectionMethod.equalsIgnoreCase("deselectbytext")) {
			sel.deselectByVisibleText(value2);
		} else if (selectionMethod.equalsIgnoreCase("deselectbyvalue")) {
			sel.deselectByValue(value2);
		} else if (selectionMethod.equalsIgnoreCase("deselectbyindex")) {
			int parseInt = Integer.parseInt(value2);
			sel.deselectByIndex(parseInt);
		} else if (selectionMethod.equalsIgnoreCase("deselectbyall")) {
			sel.deselectAll();
		} else if (selectionMethod.equalsIgnoreCase("multiple")) {
			boolean multiple = sel.isMultiple();
			System.out.println(multiple);
	
		}

	}
	public static void get_Options(String xpath,String optiontypes) {
		WebElement element = driver.findElement(By.xpath(xpath));
Select sel =new Select(element);
sel.getAllSelectedOptions();
List<WebElement> options = sel.getAllSelectedOptions();

if (optiontypes.equalsIgnoreCase("allselectedoptions")) {
	

for (WebElement alloptions : options) {
	System.out.println("allselectedoptions"+alloptions.getText());
}
}else if (optiontypes.equalsIgnoreCase("alloptions")) {
	for (WebElement webElement : options) {
		System.out.println("alloptions"+webElement.getText());
	}
}

	}
	
	

	public static void screenShot(String name) {// 21
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\amalr\\eclipse-workspace\\MavenProject\\screenshot\\" + name + ".png");
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void mouseActionElement(String xpath,String actionmethod) {//22
		WebElement element = driver.findElement(By.xpath(xpath));
Actions act = new Actions(driver);
if (actionmethod.equalsIgnoreCase("clickelement")) {
	act.click(element).perform();
}else if (actionmethod.equalsIgnoreCase("rightclickwebelement")) {
	act.contextClick(element).perform();
}else if (actionmethod.equalsIgnoreCase("doubleclickelement")) {
	act.doubleClick(element).perform();
}else if (actionmethod.equalsIgnoreCase("movetoelement")) {
	act.moveToElement(element).perform();
}
	}
	public static void mouseAction(String mouseactions) {//23
Actions act=new Actions(driver);
if (mouseactions.equalsIgnoreCase("click")) {
	act.click().perform();;
}else if (mouseactions.equalsIgnoreCase("clickandhold")) {
	act.clickAndHold().perform();;
}else if (mouseactions.equalsIgnoreCase("rightclick")) {
	act.contextClick().perform();;
}else if (mouseactions.equalsIgnoreCase("doubleclick")) {
	act.doubleClick().perform();;
}

	}
	public static void dragAndDrop(String drag,String drop) {//24
Actions act= new Actions(driver);
WebElement source = driver.findElement(By.xpath(drag));
WebElement target = driver.findElement(By.xpath(drop));

 act.dragAndDrop(source,target ).perform();
		
}
	public static void implicitlyWait(int seconds) {
driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	
	
	
	}
	
	
	
