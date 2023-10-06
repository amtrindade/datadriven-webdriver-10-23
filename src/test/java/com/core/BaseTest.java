package com.core;

import static com.core.DriverFactory.getDriver;
import static com.core.DriverFactory.killDriver;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public abstract class BaseTest {
	
	 
	@AfterMethod
	public void tearDown(ITestResult testResult) throws Exception {
		Date date = new Date();
		
		//screenshot da tela
		File screen = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		//salva o arquivo de screenshot na pasta
		FileUtils.copyFile(screen, new File("target" + File.separator + testResult.getName()+"_"+date+".jpg"));
		
		killDriver();
	}	
}
