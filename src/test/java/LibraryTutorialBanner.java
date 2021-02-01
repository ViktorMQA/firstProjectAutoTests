import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;




public class LibraryTutorialBanner {
    public static void libr () {
        $x("//button[@class='button_button__PyU3X button_mid__1D5fw button_contained__1p79v button_clever__29t0X button_unshadowed__uD4dB tutorial-init-modal_tutorial-init__btn__2esQZ']")
                .shouldBe(Condition.visible);
        // Set Value to Local Storage
        localStorage().setItem("LibraryTutorialPassed", "true");
        WebDriverRunner.getWebDriver().navigate().refresh();
    }
}
