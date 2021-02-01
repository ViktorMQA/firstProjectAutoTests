import org.hamcrest.Condition;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Locators {
    @Test
    public void secTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://uat.un1.dev/login/education");

        WebElement login = driver.findElement(By.name("email"));
        login.sendKeys("test@test.com");

        WebElement pass = driver.findElement(By.name("password"));
        pass.sendKeys("Ab12345!");

        WebElement log_in = driver.findElement(By.xpath("//button[@class='_3TPErr _2a0HXz rx4SKJ _17AUbL']"));
        log_in.click();

        WebElement accId = driver.findElement(By.name("user_id"));
        accId.sendKeys("100000351");

        WebElement filter = driver.findElement(By.xpath("//button[contains(text(), 'Filter')]"));
        //нужно разобраться как выставить таймаут по элементу
        Thread.sleep(2000);
        filter.click();

        WebElement logInUser = driver.findElement(By.xpath("//a[@href='/admin/users/100000351/edit']"));
        logInUser.click();

        WebElement switcher = driver.findElement(By.xpath("//span[@class='i_checkbox_trigger__custom']"));
        //нужно разобраться как выставить таймаут по элементу
        Thread.sleep(2000);
        switcher.click();

        WebElement editEmail = driver.findElement(By.id("change-email__button__edit"));
        editEmail.click();

        WebElement inputEmail = driver.findElement(By.id("change-email-input"));
        inputEmail.clear();
        Thread.sleep(2000); // для наглядности
        inputEmail.sendKeys("testaqa@test.com");

        WebElement changeEmail = driver.findElement(By.id("change-email__button__edit"));
        changeEmail.click();

        WebElement discardEmail = driver.findElement(By.id("change-email__button__discard"));
        discardEmail.click();

        WebElement firstName = driver.findElement(By.xpath("//input[@class='input-text__field' and @name='first_name']"));
        firstName.clear();
        Thread.sleep(2000); // для наглядности
        firstName.sendKeys("aqa");

        WebElement lastName = driver.findElement(By.name("last_name"));
        lastName.clear();
        Thread.sleep(2000); // для наглядности
        lastName.sendKeys("test");

        WebElement companyName = driver.findElement(By.name("company_name"));
        companyName.clear();
        Thread.sleep(2000); // для наглядности
        companyName.sendKeys("AQA");

        WebElement country = driver.findElement(By.id("country-select"));
        Select select = new Select(country);
        select.selectByValue("UG");

        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement state = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("country-state-select")));
        Select select2 = new Select(state);
        select2.selectByVisibleText("Western Region");

        WebElement typeCostomer = driver.findElement(By.xpath("//select[@id='type_of_customer-select']"));
        typeCostomer.click();
        Thread.sleep(3000); // для наглядности
        Select sel = new Select(typeCostomer);
        sel.selectByVisibleText("HigherEd");

        WebElement typeOrganization = driver.findElement(By.id("type_of_organization-select"));
        typeOrganization.click();
        Thread.sleep(3000); // для наглядности
        Select sel2 = new Select(typeOrganization);
        sel2.selectByValue("Community college");

        WebElement typeCustomerFunding = driver.findElement(By.id("funding-select"));
        typeCustomerFunding.click();
        Thread.sleep(3000);
        Select sel3 = new Select(typeCustomerFunding);
        sel3.selectByIndex(2);


        WebElement accManager = driver.findElement(By.id("manager-select"));
        accManager.click();
        Thread.sleep(3000);
        Select sel4 = new Select(accManager);
        sel4.selectByValue("22505");

        WebElement noSpam = driver.findElement(By.xpath("//input[@name='no_spam']"));
        noSpam.click();

        WebElement comment = driver.findElement(By.xpath("//textarea[@name='comment']"));
        comment.sendKeys("The End");

//        WebElement save = driver.findElement(By.xpath("//button[@class='save-form__button i_button i_button--green __circle_button']"));
//        save.click();
//        Thread.sleep(3000);
//        driver.quit();


    }
}