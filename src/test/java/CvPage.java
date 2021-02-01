import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.localStorage;

public class CvPage {

    private final SelenideElement
            header = $x("//header[@class='tii-header']"),
            firstIntSource = $x("//ul[@class='tii-SidebarMatchAggregateList']/li[1]"),
            excludeButton = $x("//button[@aria-label='Exclude Source'][1]"),
            withoutRissonButton = $x("//button[@data-testid='no-reason']"),
            similarityExclusionButton = $x("//button[@data-testid='tii-ExclusionsOverlayToggleButton']");


    public CvPage() throws InterruptedException {
        localStorage().setItem("flagsTourCompleted", "true");
        localStorage().setItem("similarityTourCompleted", "true");
        WebDriverRunner.getWebDriver().navigate().refresh();
        header.shouldBe(Condition.appear);
    }

    public void sourceExclude() {
        firstIntSource.shouldBe(Condition.appear).click();
        excludeButton.click();
        withoutRissonButton.shouldBe(Condition.appear).click();
        similarityExclusionButton.shouldBe(Condition.appear);
    }

}
