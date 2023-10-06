package com.test;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.core.BaseTest;
import com.core.SpreadsheetData;
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
	
	@Test(dataProvider="countriesListExcel")
	public void searchCountryExcel(String searchCountry, String expectedCountry) {	
		mainPage = new MainPage();
		mainPage.open();		
		detailPage = mainPage.search(searchCountry);		
		assertEquals(detailPage.getTextTitle(), expectedCountry);			
	}
	
	@DataProvider(name="countriesListExcel")
	public Object[][] dataProviderExcel(){
		Object[][] testData = SpreadsheetData.readExcelData(
				"Paises", 
				"src" +File.separator + "test" + File.separator + "resources" + File.separator+ "paises.xls", 
				"Dados");
		return testData;
	}

}
