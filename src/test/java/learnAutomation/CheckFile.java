package learnAutomation;

import static com.codeborne.selenide.Selenide.$x;

public class CheckFile {
    public void check () throws InterruptedException {
        $x("//label[@for='checkbox-file-45475503-checkbox-undefined']").click();
        $x("//button[@class='button_button__PyU3X button_mid__1D5fw button_contained__1p79v button_blue__3NN5e button_unshadowed__uD4dB library-page-panel_button__16tVs' and @data-tooltip='check-dropdown-btn']")
                .click();
        $x("//div[@class='dropdown_dropdown__2k5i2']/button[3]")
                .click();
        $x("//button[@class='button_button__PyU3X button_big__2bGTa button_contained__1p79v button_blue__3NN5e button_unshadowed__uD4dB']")
                .click();
        Thread.sleep(10000);
    }
}
