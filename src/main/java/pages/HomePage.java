package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class HomePage {

    private final SelenideElement
    launchButton = $x("//button[text()='Launch']");

    public HomePage (){
        launchButton.shouldBe(Condition.appear);
    }

    public void enterLibrary(){
        launchButton.click();
    }

}
