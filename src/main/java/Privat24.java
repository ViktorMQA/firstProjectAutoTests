import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Privat24 {

    @Test
    public void logIn () throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver,5);

        driver.manage().window().maximize();

        driver.get("https://next.privat24.ua/money-transfer/card?lang=en");

        WebElement addComment = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@data-qa-node='toggle-comment']")));
        addComment.click();

        WebElement inputField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//textarea[@name='comment']")));

        WebElement close = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@title='Close']")));
        close.click();

        Assert.assertTrue(wait.until(ExpectedConditions.stalenessOf(inputField)));

    }

}
