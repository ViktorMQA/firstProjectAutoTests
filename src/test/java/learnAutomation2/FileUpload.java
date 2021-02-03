package learnAutomation2;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;

import static com.codeborne.selenide.Selenide.$x;

public class FileUpload {
    public void upload() {
        // Upload file
        WebElement checkbox = WebDriverRunner.getWebDriver().findElement(By.xpath("//button[@class='button_button__PyU3X button_mid__1D5fw button_contained__1p79v button_blue__3NN5e button_unshadowed__uD4dB library-page-panel_button__16tVs']"));
        checkbox.click();
        // $x("//input[@type='file']").sendKeys("C:/Users/v.muzyka/Desktop/РАБОТА/selenium/Лисенко Я.М..doc");
        $x("//input[@type='file']").uploadFile(new File("C:/Users/v.muzyka/Desktop/РАБОТА/selenium/Лисенко Я.М..doc"));
        checkbox.click();
    }
}
