import learnAutomation.FileUpload;
import learnAutomation2.CheckFile;
import learnAutomation2.LogInEdu;
import learnAutomation2.OpenLogFormSetEnCoocie;
import org.junit.Test;


public class Main {

    @Test
    public void main() throws InterruptedException {

        // open log form and set English cookie
        OpenLogFormSetEnCoocie.openEnCookie();

        // log in Edu
        LogInEdu logInEdu = new LogInEdu();
        logInEdu.logIn();

        // Closing a tutorial banner
        LibraryTutorialBanner.libr();

        // File upload
        FileUpload fileUpload = new FileUpload();
        fileUpload.upload();

        // Check File
        CheckFile checkFile = new CheckFile();
        checkFile.check();


    }

}




