import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class LibraryPage {

    private final SelenideElement
            uploadButton = $x("//button[@class='tool-upload']"),
            uploadType = $x("//input[@type='file']"),
            confirmButton = $x("//button[text()=' Confirm ']"),
            file = $x("//span[@title='Cit&Ref&Cheat.docx']"),
            librarySelectAllCheckbox = $x("//label[@for='select-all']"),
            trashButton = $x("(//button[@aria-label='Trash'])[1]"),
            trashMenuButton = $x("//a[@id='trash-button']"),
            myFilesMenuButton = $x("//a[@id='root-folder-button']"),
            checkSimilarityFinish = $x("//span[contains(text(), '%') and @class='doc-similarity']"),
            trashSelectAllCheckbox = $x("//label[@for='select-all']"),
            emptyTrashButton = $x("//button[contains(text(), 'Empty Trash')]"),
            emptyTrashConfirmButton = $x("//button[contains(text(), ' Empty Trash ') and @class='primary']"),
            emptyTrashSentence = $x("//div[contains(text(), 'The Trash is empty')]"),
            restoreButton = $x("//button[contains(text(), 'Restore')]"),
            thereIssNothingHereSentence = $x("//div[contains(text(), 'There')]");

    public LibraryPage() {
        uploadButton.shouldBe(Condition.appear);
    }

    public void uploadFile() throws InterruptedException {
        uploadButton.click();
        Thread.sleep(2000);
        uploadType.uploadFile(new File("C:/Users/v.muzyka/Desktop/РАБОТА/selenium/Cit&Ref&Cheat.docx"));
        Thread.sleep(2000);
        confirmButton.click();
        // ManagePage.setUpTimeout(25000);
        file.should(Condition.appear, Duration.ofMillis(25000l));
        checkSimilarityFinish.should(Condition.appear, Duration.ofMillis(25000l));
    }

    public void openCV() {
        file.shouldBe(Condition.appear).click();
    }

    public void fileDelete() {
        librarySelectAllCheckbox.click();
        trashButton.shouldBe(Condition.appear).click();
        thereIssNothingHereSentence.shouldBe(Condition.appear);
    }

    public void restoreFile() {
        trashMenuButton.click();
        trashSelectAllCheckbox.shouldBe(Condition.appear).click();
        restoreButton.shouldBe(Condition.appear).click();
        emptyTrashSentence.shouldBe(Condition.appear);
        myFilesMenuButton.click();
        file.shouldBe(Condition.appear);

    }

    public void fileDeleteFromTrash() throws InterruptedException {
        librarySelectAllCheckbox.click();
        trashButton.shouldBe(Condition.appear).click();
        thereIssNothingHereSentence.shouldBe(Condition.appear);
        trashMenuButton.click();
        emptyTrashButton.shouldBe(Condition.appear).click();
        // Selenide.switchTo().alert().accept();
        emptyTrashConfirmButton.shouldBe(Condition.appear).click();
        emptyTrashSentence.shouldBe(Condition.appear);
    }

}
