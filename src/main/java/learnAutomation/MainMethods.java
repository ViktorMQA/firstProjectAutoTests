package learnAutomation;

import com.codeborne.selenide.Selenide;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MainMethods {
    @Test
    public void methods() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

                                        // driver.manage();

        driver.manage(); // позволяет менять настройки драйвера
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // выставляет таймаут

                                        // Действия с окнами и логами

        driver.manage().window().maximize(); // максимальный размер окна
        driver.manage().window().fullscreen(); // максимальный размер окна (аналог miximize();)
        driver.manage().window().setSize(new Dimension(1000, 1000)); // изменить размер окна - размер указывается в пикселях
        driver.manage().window().getSize(); //  получить тикущий размер окна
        driver.manage().window().getPosition(); //  получить тикущию позицию окна по оси Х и У (точка отчета верхний левый угол Экрана)
        driver.manage().window().setPosition(new Point(100, 100)); // задает позицию

                                        // Получение логов

        Set <String> logs = driver.manage().logs().getAvailableLogTypes(); // увидить какие типы логов браузера доступны
        System.out.println(logs);

        driver.manage().logs().get(LogType.BROWSER); // получение логов по типу
        LogEntries logs2 = driver.manage().logs().get(LogType.BROWSER); // нужен цикл чтобы пройтись по всем логам
        for (
            LogEntry entry : logs2
        )
            System.out.println("Logs-> "+logs2);


                                       // Действия со страницей

        driver.get("http://uat.un1.dev/login/education"); // для открытия url адреса, будет ждать загрузки полной странице
        driver.navigate().to("http://uat.un1.dev/login/education"); // не будет ждать загрузки всей сраницы но поддерживает куки и историю браузера
        driver.navigate().back(); // возвращает на предыдущую урлу, аналог кнопки - назад
        driver.navigate().forward(); // аналог кнопки вперед.
        driver.navigate().refresh(); // аналог обновить


        driver.switchTo(); // используется для переключения между окнами браузера
        Selenide.switchTo().window(1); // selenide
        driver.getWindowHandle(); // используется для получения дескриптора окна, который идентифицирует окно
        driver.getWindowHandles();
        driver.getCurrentUrl(); // возвращает текущий УРЛ адресс страницы загруженный в данный момент в браузере

                                     // Проверка с использование ожидаемого и актального результата

        String currentURL = driver.getCurrentUrl();
        System.out.println("URL" + currentURL);
        Assert.assertEquals("https://www.udemy.com/", currentURL); // тут мы сравниваем наш адресс с ожидаемым результатом

        driver.getTitle(); // возращает тайтел страницы
        String currentTitle = driver.getTitle();
        System.out.println("title" + currentTitle);
        Assert.assertEquals("page name", currentTitle); // тут мы сравниваем наш тайтел страницы с ожидаемым результатом


        driver.getPageSource(); // возращает весь хтмл код страницы

        driver.quit();  // закрывает все открытые окна и процессы
        driver.close(); // закрывает тикущее окно

                                                           // COOKIES

        driver.get("https://github.com/account/unverified-email");
        Cookie cookie = new Cookie("user_session", "kqp6I74DpgOq4CV9BJ34CKbgnYvaKRSR"); // зайти, например другим браузером и скопировать куку
        driver.manage().addCookie(cookie); // добавление куки, принимает куку
        Set<Cookie> arrey = driver.manage().getCookies(); // получения всех кук домена
        Cookie cook =  driver.manage().getCookieNamed("user_session"); // получение данных куки по её имени
        driver.manage().deleteCookieNamed("user_session"); // удаление куки по имени
        driver.manage().deleteAllCookies(); // удаление всех кук


                                                   //        localStorage

//        // Очистить всё содержимое:
//        localStorage().clear();
//
//// Добавить значение:
//        localStorage().setItem("username", "john");
//
//// Проверить значение:
//        assertThat(localStorage().getItem("username")).isEqualTo("john");
//
//// Проверить количество элементов:
//        assertThat(localStorage().size()).isEqualTo(1);
//
//// удалить значение:
//        localStorage().removeItem("username");
//        assertThat(localStorage().getItem("username")).isNull();

                                              // установка инглишь куки для сайта

        driver.manage().deleteCookieNamed("language");
        System.out.println("all coocies: " + driver.manage().getCookies());
        Cookie language = new Cookie("language", "en_US");
        driver.manage().addCookie(language);
        driver.navigate().to("https://uat.un1.dev/");

                                                     // Выпадающие списки

        WebElement selectElem = driver.findElement(By.tagName("select"));
        Select select = new Select(selectElem);

        // Получить все пункты выпадающего списка можно с помощью метода getOptions. getAllSelectedOptions — вернет все выбранные пункты списка:
        List options = select.getOptions();
        List selectedOptions = select.getAllSelectedOptions();
        select.getFirstSelectedOption(); // возвращает первый выбранный пункт для списка со множественным выбором, или текущий выбранный пункт для обычного списка.

        WebElement selectedOption = select.getFirstSelectedOption();
        // Чтобы проверить поддерживает ли список множественный выбор, можно использовать метод — isMultiple().
        // Он возвращает boolean значение, основанное на атрибуте "multiple" тега SELECT.

        //Класс содержит методы для выбора и снятия выбора с пунктов списка по различным критериям: по порядковому номеру, по значению и по тексту.

        select.selectByVisibleText("String text"); // выбирает все пункты списка, текст которых соответствует параметру text.
        select.selectByIndex(2); // выбирает пункт по заданному индексу. Индекс определяется по атрибуту index пункта, а не просто путем подсчета.
        select.selectByValue("22505"); // выбирает опции, атрибут value которых соответствует параметру.

                                                    // WEB ELEMENTS

        WebElement button = driver.findElement(By.xpath("//button[@type='jfgjfg']"));

        button.click(); // используется для всех кнопок без исключения
        button.submit(); // используется только для кнопок которые расположены в теге form и которые имеют type = submit

                                // Получение свойства елементов getAttribute("attribute name") с проверкой;

        WebElement addButton = driver.findElement(By.xpath("//h1[text()='Plagiarism Checker that Prefers Results over Numbers']"));
        String attribute =  addButton.getAttribute("textContent");
        System.out.println("This is attribute: " + attribute);
        Assert.assertEquals("Plagiarism Checker that Prefers Results over Numbers", attribute);

                                           // Определение состояния елементов

        WebElement element = driver.findElement(By.xpath("hhh"));
        element.isDisplayed(); // вернет true если елемент виден человеку (исключения 1. прозрачность <= 98 - селениум обозначит как видимый
        // 2. елемент такого же цвета как фон страницы - селениум обозначит как видимый 3. когда елемент перекрыт другим елементом - селениум обозначит как видимый)
        element.isEnabled(); // редко проверяет свойство дизейблед если данный елемент или свойство утановлен, метод возвращает falce и наоборот (можно использовать getAttribute("attribute name"))
        element.isSelected(); // проверяет свойство елемента selected выбран ли данный елемент (можно использовать getAttribute("attribute name"))

                                                 // Виды ожидания Елементов
        Thread.sleep(1500); // Задержка в коде

        // Неявное ожидание

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        // Явное ожидание

        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement anyElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("Locator"))); // присутствие елемента на странице
        Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("Locator")))); // отсутствие елемента на странице (проверка что елемента больше нету)
        WebElement anyElement3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("Locator"))); // пример кнопка вход на сайте привата
        Assert.assertTrue(wait.until(ExpectedConditions.stalenessOf(anyElement))); // проверка отсутствия какого либо елемента после какихто действий

        WebElement buttonOk = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("locator"))); // проверка видимости кнопки в доме или текста


        // Действия с Алертами  (Модалки - окна которые блокирует работу сайта пока пользователь не нажмет кнопку) и Попапами (не блокирует сайт при появлении)

        // Alert (Информационное сообщение) по сути есть только кнопка "ОК"
        driver.navigate().to("https://javascript.info/alert-prompt-confirm");
        WebElement alertRun = driver.findElement(By.xpath("(//a[@title='run'])[1]")); // открытие информационного окна
        alertRun.click();

        Alert alert = driver.switchTo().alert(); // переход на диалоговое окно
        alert.accept(); // нажатия кнопки ок на диалоговом окне

        alertRun.click();
        System.out.println(alert.getText()); // получение текста аллерта
        Assert.assertEquals("Hello", alert.getText());
        alert.accept();

        // Confirm (Диалоговое окно) есть кнопка "ОК" и "CANSElL"

        WebElement confirmRun = driver.findElement(By.xpath("(//a[@title='run'])[5]")); // открытие диалогового окна
        confirmRun.click();

        Alert confirm = driver.switchTo().alert(); // переход на диалоговое окно
        confirm.dismiss(); // нажатия кнопки cansel на диалоговом окне
        confirm.accept();

        // Promt (диалоговое окно с вводом данных) есть кнопка "ОК" и "СCANSEL" а также поле для ввода

        WebElement promtRun = driver.findElement(By.xpath("(//a[@title='run'])[2]"));
        promtRun.click();

        Alert promt = driver.switchTo().alert();
        promt.sendKeys("200"); // ввод текста в поле для ввода
        promt.accept();
        System.out.println(promt.getText());
        promt.accept();
        promt.accept();

        // Действия с фреймами (отдельный законченый елемент, содержащий свою модель страницы ДОМ) может встраиваться в любое место страницы

        driver.navigate().to("https://next.privat24.ua/?lang=en");

        WebElement signIn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-qa-node='login']")));
        signIn.click();

        WebElement frame = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@src='https://login-widget.privat24.ua/']")));

        driver.switchTo().frame(frame); // переключаемся на фрейм

        WebElement continueButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(), 'Continue')]")));
        continueButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Incorrect value was entered')]"))); // проверяе отображение текста после нажатия на континуе




    }

}
