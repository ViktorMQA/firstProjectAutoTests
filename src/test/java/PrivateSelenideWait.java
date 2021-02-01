import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;


public class PrivateSelenideWait {
    @Test
    public void selwait () throws InterruptedException {

        open("https://next.privat24.ua/");
        $(byXpath("//button[@data-qa-node='login']")).click();
        WebDriverRunner.getWebDriver().switchTo().frame($(byXpath("//iframe[@src='https://login-widget.privat24.ua/']")));
        $(byXpath("//button[@type='submit' and text()='Далі' ]")).click();
        Thread.sleep(5000);


    }
}
