import com.codeborne.selenide.Selenide;
import org.junit.Test;

public class MainTii {

    @Test
    public void main() throws InterruptedException {


        BasePage basePage = new BasePage();
        basePage.openUrl("https://tii-qavm2.turnitin.org/");

        ManagePage.maximize();

        LogInPage logInPage = new LogInPage();
        logInPage.logIn();

        HomePage homePage = new HomePage();
        homePage.enterLibrary();

        ManagePage.switchToLp();

        LibraryPage libraryPage = new LibraryPage();
        libraryPage.uploadFile();

        libraryPage.openCV();

        ManagePage.switchToCv();

        CvPage cvPage = new CvPage();
        cvPage.sourceExclude();

        ManagePage.switchToLp();

        libraryPage.fileDelete();
        libraryPage.restoreFile();
        libraryPage.fileDeleteFromTrash();

        Thread.sleep(5000);



    }
}
