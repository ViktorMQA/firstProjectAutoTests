package learnAutomation;

import static com.codeborne.selenide.Selenide.*;

public class LogInEdu {

    public void logIn() {
        // Log in Edu
        $x("//input[@name='email']").setValue("vmuzyka+auto@turnitin.com");
        $x("//input[@name='password']").setValue("viktor123");
        $x(" //button[text()='Log In']").click();

    }

}
