import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class SelenideFileUpload {
    @Test
    public void fileUpload()  {

        // Log in Edu
        open("https://unicheck.com/login/education");

        WebDriverRunner.getWebDriver().manage().window().maximize();

        // Set English cookie
        WebDriverRunner.getWebDriver().manage().deleteCookieNamed("language");
        Cookie cookie = new Cookie("language", "en_US");
        WebDriverRunner.getWebDriver().manage().addCookie(cookie);
        open("https://unicheck.com/login/education");

        $x("//input[@name='email']").setValue("vmuzyka+auto@turnitin.com");
        $x("//input[@name='password']").setValue("viktor123");
        $x(" //button[text()='Log In']").click();

        //LibraryTutorialBanner
        $x("//button[@class='button_button__PyU3X button_mid__1D5fw button_contained__1p79v button_clever__29t0X button_unshadowed__uD4dB tutorial-init-modal_tutorial-init__btn__2esQZ']")
                .shouldBe(Condition.visible);

        // Set Value to Local Storage
        localStorage().setItem("LibraryTutorialPassed", "true");
        WebDriverRunner.getWebDriver().navigate().refresh();

        // Upload file
        WebElement checkbox = WebDriverRunner.getWebDriver().findElement(By.xpath("//button[@class='button_button__PyU3X button_mid__1D5fw button_contained__1p79v button_blue__3NN5e button_unshadowed__uD4dB library-page-panel_button__16tVs']"));
        checkbox.click();
        // $x("//input[@type='file']").sendKeys("C:/Users/v.muzyka/Desktop/РАБОТА/selenium/Лисенко Я.М..doc");
        $x("//input[@type='file']").uploadFile(new File("C:/Users/v.muzyka/Desktop/РАБОТА/selenium/Лисенко Я.М..doc"));
        checkbox.click();

        // Check File
        $x("//label[@for='checkbox-file-45475503-checkbox-undefined']").click();
        $x("//button[@class='button_button__PyU3X button_mid__1D5fw button_contained__1p79v button_blue__3NN5e button_unshadowed__uD4dB library-page-panel_button__16tVs' and @data-tooltip='check-dropdown-btn']")
                .click();
        $x("//div[@class='dropdown_dropdown__2k5i2']/button[3]")
                .click();
        $x("//button[@class='button_button__PyU3X button_big__2bGTa button_contained__1p79v button_blue__3NN5e button_unshadowed__uD4dB']")
                .click();
    }

}
