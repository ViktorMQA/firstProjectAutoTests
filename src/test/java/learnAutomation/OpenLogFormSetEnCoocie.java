package learnAutomation;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.*;

public class OpenLogFormSetEnCoocie {
    public static void openEnCookie(){
        open("https://unicheck.com/login/education");
        WebDriverRunner.getWebDriver().manage().deleteCookieNamed("language");
        WebDriverRunner.getWebDriver().manage().addCookie(new Cookie("language", "en_US"));
//        Cookie cookie = new Cookie("language", "en_US");
//        WebDriverRunner.getWebDriver().manage().addCookie(cookie);
        open("https://unicheck.com/login/education");

    }
}
