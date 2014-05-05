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
  
  /* Additional, valid VINs for testing:
   * YS3CK48D1L1150907
   * 1YVHP85C285334023
   * 4S3BL696973100519
   * 1FMBU01B51K204577
   * 2HGFG1B81AH294439
   *
   * For more randomly generated VINs, visit: http://randomvin.com/
   * Be sure to verify the VIN on the same site before replacing the value
   * in 'vinInput'.
   */
  
  @Test
  public void testVehicleAddSuccess() throws Exception {
    driver.get(baseUrl + "file:///H:/code_training/repair_lst/src/main/webapp/WEB-INF/views/html/vehicles/create.html");
    new Select(driver.findElement(By.id("makeSelectionBox"))).selectByVisibleText("BENTLEY");
    new Select(driver.findElement(By.id("modelSelectionBox"))).selectByVisibleText("CONTINENTAL FLYING SPUR");
    driver.findElement(By.id("vinInput")).clear();
    driver.findElement(By.id("vinInput")).sendKeys("KMHVD34N4XU600231");
    driver.findElement(By.id("mileageInput")).clear();
    driver.findElement(By.id("mileageInput")).sendKeys("0");
    driver.findElement(By.id("createVehicleSubmit")).click();
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
