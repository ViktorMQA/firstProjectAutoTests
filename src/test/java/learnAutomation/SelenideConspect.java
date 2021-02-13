package learnAutomation;

import com.codeborne.selenide.Condition;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;

public class SelenideConspect {
    @Test
    public void conspect() {
        open("https://www.google.com.ua/?hl=en"); // переход на ресурс
        $x("//input[@name='q']").setValue("hello!").pressEnter(); // $x() - Xpath, .setValue - ввести значение, .pressEnter() - нажать Ентер
        $x("//div[@id='result-stats']").shouldBe(Condition.visible); // .shouldBe(Condition.visible) - проверяем наличие елемента


    }
}
