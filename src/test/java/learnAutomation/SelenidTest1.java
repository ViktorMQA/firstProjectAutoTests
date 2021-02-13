package learnAutomation2;

import com.codeborne.selenide.Condition;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class SelenidTest1 {
    @Test
    public void test1() {
        open("https://www.google.com.ua/?hl=en");
        $x("//input[@name='q']").setValue("hello!").pressEnter();
      //  $x("//div[@id='result-stats']").shouldBe(Condition.visible);
        element(By.xpath("//div[@id='result-stats']")).shouldBe(Condition.visible);

    }
}
