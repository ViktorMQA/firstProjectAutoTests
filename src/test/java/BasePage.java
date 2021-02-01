import static com.codeborne.selenide.Selenide.open;

public class BasePage {

    public LogInPage openUrl(String url) {
        open(url);
        return new LogInPage();
    }



}
