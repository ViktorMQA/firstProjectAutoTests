package learnAutomation;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FileUpload {

    @Test
    public void upload() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://unicheck.com/login/education");

        WebElement log = driver.findElement(By.xpath("//input[@name='email']"));
        log.sendKeys("vmuzyka+auto@turnitin.com");

        WebElement pass = driver.findElement(By.xpath("//input[@name='password']"));
        pass.sendKeys("viktor123");

        WebElement enter = driver.findElement(By.xpath("//button[@type='submit']"));
        enter.click();

        WebElement letsGo = driver.findElement(By.xpath("//button[@class='button_button__PyU3X button_mid__1D5fw button_contained__1p79v button_clever__29t0X button_unshadowed__uD4dB tutorial-init-modal_tutorial-init__btn__2esQZ']"));
        letsGo.click();

        WebElement closetoot = driver.findElement(By.xpath("//button[@class='tutorial-tooltip-body_tutorial-tooltip-body__close-button__3zskt']"));
        closetoot.click();


        WebElement add = driver.findElement(By.xpath("//button[@class='button_button__PyU3X button_mid__1D5fw button_contained__1p79v button_blue__3NN5e button_unshadowed__uD4dB library-page-panel_button__16tVs']"));
        add.click();

        // загрузка файла
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:/Users/v.muzyka/Desktop/РАБОТА/selenium/Лисенко Я.М..doc");

        WebElement checkbox = driver.findElement(By.xpath("//label[@for='checkbox-file-45475503-checkbox-undefined']"));
        checkbox.click();

        WebElement check = driver.findElement(By.xpath("//button[@class='button_button__PyU3X button_mid__1D5fw button_contained__1p79v button_blue__3NN5e button_unshadowed__uD4dB library-page-panel_button__16tVs' and @data-tooltip='check-dropdown-btn']"));
        check.click();

        // узнать почему не работает
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        WebElement inter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='dropdown_dropdown__2k5i2']/button[1]")));
       // visibilityOfElementLocated - меняет состояние (дизейбл - енейбл)
        Thread.sleep(1500);
        WebElement inter = driver.findElement(By.xpath("//div[@class='dropdown_dropdown__2k5i2']/button[3]"));
        inter.click();

        WebElement finalClick = driver.findElement(By.xpath("//button[@class='button_button__PyU3X button_big__2bGTa button_contained__1p79v button_blue__3NN5e button_unshadowed__uD4dB']"));
        finalClick.click();


    }

}
