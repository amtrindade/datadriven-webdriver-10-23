package com.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.core.BaseTest;
import com.page.DetailPage;
import com.page.MainPage;

public class SearchCountriesTest extends BaseTest{
	
	private MainPage mainPage;
	private DetailPage detailPage;
	
	
	@Test(dataProvider="countriesList")
	public void searchCountry(String searchCountry, String expectedCountry) throws InterruptedException {	
		mainPage = new MainPage();
		mainPage.open();		
		detailPage = mainPage.search(searchCountry);		
		assertEquals(detailPage.getTextTitle(), expectedCountry);			
	}
	
	@DataProvider(name = "countriesList")
	public Object[][] dataProviderCountries(){
		return new Object[][] {
			{ "India", "India"},
			{ "Argentina", "Argentina"},
			{ "Brazil", "Brazil" }, 
			{ "Italy", "Italy" }, 
			{ "Venezuela", "Venezuela" },
			{ "United States", "United States"},
			{ "Spain", "Spain" }
		};				
	}
	

}
