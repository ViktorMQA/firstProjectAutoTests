import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class LogInPage  {


   private final SelenideElement
            crossrefImage = $x("//img[@src='../../../assets/images/crossref-color-logo.svg']"),
            inputFieldUserName = $x("//input[@name='username']"),
            inputFieldPass = $x("//input[@name='password']"),
            signInButton = $x("//button[text()='Sign in']");

    public LogInPage() {
        crossrefImage.shouldBe(Condition.appear); // разобраться почему нельзя выстовить таймаут
    }


    public void logIn() {
        inputFieldUserName.sendKeys("vmuzyka@turnitin.com");
        inputFieldPass.sendKeys("viktor123");
        signInButton.click();
    }

}
