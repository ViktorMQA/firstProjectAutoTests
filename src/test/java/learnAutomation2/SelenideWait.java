package learnAutomation2;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;


public class SelenideWait {

    @Test
    public void learnWait () throws InterruptedException {

// Log in Edu
        open("https://unicheck.com/login/education");

        WebDriverRunner.getWebDriver().manage().window().maximize();

        // Set English cookie
        WebDriverRunner.getWebDriver().manage().deleteCookieNamed("language");
        Cookie cookie = new Cookie("language", "en_US");
        WebDriverRunner.getWebDriver().manage().addCookie(cookie);
        open("https://unicheck.com/login/education");

        $x("//input[@name='email']").setValue("v.muzyka+admin@unicheck.com");
        $x("//input[@name='password']").setValue("uL1y6T7j");
        $x(" //button[text()='Log In']").click();
        $x("//section[@class='cabinet_header__navigation navigation ']").shouldBe(Condition.visible);
        $(byXpath("//input[@name='email_first']")).shouldBe(Condition.visible).sendKeys("vmuzyka");
        Thread.sleep(2000);
        $(byXpath("//input[@name='email_first']")).pressEnter();
        $(byXpath("//li[@class='item-history ']")).click();
        Select select = new Select($(byXpath("//select[@name='country']")));
        select.selectByValue("AD");
        Thread.sleep(10000);


    }
}
