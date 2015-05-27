package com.pdxcycle9.repair_lst.selenium;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CreateVehicleTest {

	private WebDriver driver;
	private String baseURL;

	@Before
	public void setUp() throws Exception {
		//driver = new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver", "C:\\Data\\Sivagami\\Catalyst\\Training\\selenium\\chromedriver_win32\\chromedriver.exe");
		//baseURL = "";
		//driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		//System.setProperty("webdriver.chrome.driver","C:\\Data\\Sivagami\\Catalyst\\Training\\selenium\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver","C:\\Data\\Sivagami\\Catalyst\\Training\\repair_lst\\src\\main\\selenium\\selenium\\chromedriver.exe");
	    // To remove message "You are using an unsupported command-line flag: --ignore-certificate-errors.
	    // Stability and security will suffer."
	    // Add an argument 'test-type'
	    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("test-type");
	    //capabilities.setCapability("chrome.binary","C:\\Data\\Sivagami\\Catalyst\\Training\\selenium\\chromedriver_win32\\chromedriver.exe");
	    capabilities.setCapability("chrome.binary","C:\\Data\\Sivagami\\Catalyst\\Training\\repair_lst\\src\\main\\selenium\\selenium\\chromedriver.exe");
	    capabilities.setCapability("webdriver.chrome.args", Arrays.asList("whitelisted-ips=127.0.0.1"));


	capabilities.setCapability(ChromeOptions.CAPABILITY, options);

	    driver = new ChromeDriver(capabilities);
	}
	
	@Test
	public void testVehicleAddSucess() throws Exception {
		driver.get(baseURL + "C:\\Data\\Sivagami\\Catalyst\\Training\\repair_lst\\src\\main\\webapp\\WEB-INF\\views\\html\\vehicles\\create.html");
		new Select(driver.findElement(By.id("makeSelectionBox"))).selectByVisibleText("Honda");
	    new Select(driver.findElement(By.id("modelSelectionBox"))).selectByVisibleText("Civic");
		driver.findElement(By.id("mileageInput")).sendKeys("25000");
		driver.findElement(By.id("vinInput")).sendKeys("1HGEJ1121SL027333");
		driver.findElement(By.id("createVehicleSubmit")).click();
		String bodyText = driver.findElement(By.id("vehicleMessage")).getText();
		assertEquals("You've successfully added a Vehicle to your collection", driver.findElement(By.id("vehicleMessage")).getText());
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	
	

}
