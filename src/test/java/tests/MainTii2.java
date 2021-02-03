package tests;

import org.junit.Test;
import pages.*;


public class MainTii2 {

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
        libraryPage.createAndRenameFolder();
        libraryPage.emptyingTrash();

        Thread.sleep(5000);
    }
}
