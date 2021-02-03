package learnAutomation;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class FirstTest {

    @Test
    public void testSearch() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver,10);

        driver.navigate().to("https://next.privat24.ua/?lang=en");

        WebElement signIn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-qa-node='login']")));
        signIn.click();

        WebElement frame = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@src='https://login-widget.privat24.ua/']")));

        driver.switchTo().frame(frame); // переключаемся на фрейм

        WebElement continueButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(), 'Continue')]")));
        continueButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Incorrect value was entered')]"))); // проверяе отображение текста после нажатия на континуе

    }

}
