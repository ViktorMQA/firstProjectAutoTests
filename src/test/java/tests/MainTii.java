package tests;

import org.junit.Test;
import pages.*;

public class MainTii {

    // LogIn-upload-check-openCV-exclude source-delete file-restore file

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
        libraryPage.fileDelete();
        libraryPage.emptyingTrash();

        Thread.sleep(5000);


    }
}
