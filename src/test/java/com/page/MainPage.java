package com.page;

import static com.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.core.GlobalProperty;

public class MainPage {
	
	public MainPage open() {		
		getDriver().get(GlobalProperty.getProperty("webdriver.test.url"));		
		return this;
	}
	
	public DetailPage search(String country) {
		
		WebElement tfSearch = getDriver().findElement(By.name("search"));
		tfSearch.sendKeys(country);
				
		WebElement btnSearch = getDriver().findElement(By.xpath("//button[.='Search']"));
		btnSearch.click();
		
		return new DetailPage();
	}

}
