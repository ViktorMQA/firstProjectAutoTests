import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;

import java.io.File;

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
