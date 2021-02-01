import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;


public class ManagePage {

    public static void maximize(){
        WebDriverRunner.getWebDriver().manage().window().maximize();

    }

    public static LibraryPage switchToLp(){
        Selenide.switchTo().window(1);
        return new LibraryPage();
    }

    public static CvPage switchToCv() throws InterruptedException {
        Selenide.switchTo().window(2);
        return new CvPage();
    }

    public static void setUpTimeout(int timeout) {
        Configuration.timeout = timeout;
    }


}
