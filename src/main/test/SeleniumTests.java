import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

//import org.testng.annotations.Test;
public class SeleniumTests {
  //  private WebDriver driver;
  //  @BeforeClass
    //    public void initBrowser(){
     //    driver = new ChromeDriver();
   // }
    @Test
   public void correctLogin(){
        System.setProperty("webdriver.chrome.driver","/Users/omali/IdeaProjects/Homework13/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/login");

        WebElement username = driver.findElement(By.id("username"));
        WebElement password=driver.findElement(By.id("password"));
        WebElement login=driver.findElement(By.xpath("//*[contains(@class, 'fa fa-2x fa-sign-in')]"));

        username.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword!");
        login.click();

        //String successMessage = driver.findElement(By.id("flash")).getText();
        String successMessage = driver.findElement(By.xpath("//*[contains(@class, 'flash success')]")).getText();

                Assert.assertEquals(successMessage, "You logged into a secure area!\n" +
                        "×");
        System.out.println("positive login test passed");
                driver.quit();
    }
    @Test
    public void incorrectLogin(){
        System.setProperty("webdriver.chrome.driver","/Users/omali/IdeaProjects/Homework13/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");

        WebElement username = driver.findElement(By.id("username"));
        WebElement password=driver.findElement(By.id("password"));
        WebElement login=driver.findElement(By.xpath("//*[contains(@class, 'fa fa-2x fa-sign-in')]"));

        username.sendKeys("test");
        password.sendKeys("test");
        login.click();

        String successMessage = driver.findElement(By.xpath("//*[contains(@class, 'flash error')]")).getText();
        Assert.assertEquals(successMessage, "Your username is invalid!\n" +
                "×");
        System.out.println("negative test passed");
        driver.quit();
    }
    //@AfterMethod
   // public void quitBrowser(){
     //   driver.quit();
   // }
    }








