package ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Data;
import org.openqa.selenium.By;
import utils.PropertyHelper;

import static com.codeborne.selenide.Selenide.$;
import static java.time.Duration.ofSeconds;

@Data
public class LoginPage extends BasePage {

    private SelenideElement aLogo = $(By.xpath("//div[contains(@class, 'sc-cabOPr ikNyeA')]"));
    private SelenideElement logoAnimation = $(By.xpath("//span[@class= 'sc-iTFTee cdTuVt']"));

    final static String START_URL = PropertyHelper.getProperty("start.url");

    public LoginPage open() {
        Selenide.open(START_URL);
        return new LoginPage();
    }

    @Step("Visibility of bank logos")
    public boolean checkBankLogos() {
        this.getALogo().shouldBe(Condition.visible, ofSeconds(10)).isDisplayed();
        this.getLogoAnimation(); //mistake
        return true;
    }

}
