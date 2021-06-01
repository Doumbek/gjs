import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import driver.CustomChromeDriverFactory;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AmazonSearchTests {

    //Is not related to Allure. Selenide just do or not screenshots
    //build/reports/tests
    @RegisterExtension
    static ScreenShooterExtension screenshotEmAll = new ScreenShooterExtension(true);

    @BeforeAll
    public static void setUp() {
        Configuration.browser = CustomChromeDriverFactory.class.getName();

        //build/allure-results
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @Test
    @Tag("search")
    public void verifySearchResultContainsItem() {
        open("https://www.amazon.com/");
        $("#twotabsearchtextbox")
                .setValue("Apple")
                .pressEnter().shouldBe(Condition.visible);
    }

    @Test
    @Tag("search")
    public void verifyFailedBySelenide() {
        open("https://www.amazon.com/");
        $("#twotabsearchtextbox").shouldBe(Condition.disappear);
    }

    @Test
    @Tag("search")
//    @ExtendWith({ScreenShooterExtension.class})
    public void verifyFailedByJUnit() {
        open("https://www.amazon.com/");
        Assertions.assertTrue(false);
    }

    @Test
    @Tag("search")
    public void verifyPassedByJUnit() {
        open("https://www.amazon.com/");
        Assertions.assertTrue(true);
    }

}
