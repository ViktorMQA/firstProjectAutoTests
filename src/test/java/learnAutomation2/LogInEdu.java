package learnAutomation2;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class LogInEdu {

    public void logIn() {
        // Log in Edu
        $x("//input[@name='email']").setValue("vmuzyka+auto@turnitin.com");
        $x("//input[@name='password']").setValue("viktor123");
        $x(" //button[text()='Log In']").click();

    }

}
