import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SecondTest {

   @Test
   public void secTest() {
      System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

      WebDriver driver = new ChromeDriver();

      driver.manage().window().maximize();

      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

      driver.get("http://unicheck.com");

      //  WebElement button = driver.findElement(By.xpath("//button[@class='_3TPErr _1HQDPo rx4SKJ _2VG3Hk']"));

      //  WebElement button = driver.findElement(By.xpath("//button[.='Log In']"));

      //button[text()='Log In']

      //button[contains(., 'Log In')]

      WebElement logIn = driver.findElement(By.xpath("//button[text()='Log In']"));

      logIn.click();

      WebElement k12 = driver.findElement(By.xpath("//div/a[@title='K-12 & Higher Education']"));

      k12.click();

      driver.quit();

   }

   @Test
   public void secTest2() {
      System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

      WebDriver driver = new ChromeDriver();

      driver.manage().window().maximize();

      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

      driver.get("http://unicheck.com");

      WebElement button2 = driver.findElement(By.xpath("//a[.='Create Account']"));

      button2.click();

      driver.quit();
   }
}