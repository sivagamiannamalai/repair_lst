package selenium;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateVehicleSuccessTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
  /* 
   * For more VINs run ValidVINRetriever as a JUnit test, copy
   * the VIN number that reaches console output and replace the 
   * .sendKeys String argument with the new VIN on line 37 
   */
  
  @Test
  public void testVehicleAddSuccess() throws Exception {
    driver.get(baseUrl + "file:///H:/code_training/repair_lst/src/main/webapp/WEB-INF/views/html/vehicles/create.html");
    new Select(driver.findElement(By.id("makeSelectionBox"))).selectByVisibleText("BENTLEY");
    new Select(driver.findElement(By.id("modelSelectionBox"))).selectByVisibleText("CONTINENTAL FLYING SPUR");
    driver.findElement(By.id("vinInput")).clear();
    driver.findElement(By.id("vinInput")).sendKeys("1FMZU64W64U535337"); // Add new VIN here
    driver.findElement(By.id("mileageInput")).clear();
    driver.findElement(By.id("mileageInput")).sendKeys("0");
    driver.findElement(By.id("createVehicleSubmit")).click();
    String bodyText = driver.findElement(By.id("vehicleMessage")).getText();
    //Assert.assertTrue("Text not found!", bodyText.contains("You've successfully added a Vehicle to your collection"));
    // AssertEquals is checking for the text BEFORE the text appears -- Thread.sleep(time in MS) is not going to work
    // Find a work-around
    assertEquals("You've successfully added a Vehicle to your collection", driver.findElement(By.id("vehicleMessage")).getText());
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
