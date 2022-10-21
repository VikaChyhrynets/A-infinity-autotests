package ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Data;
import org.openqa.selenium.By;
import utils.PageWebElements;
import utils.PropertyHelper;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.sleep;
import static java.time.Duration.ofSeconds;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Data
public class LoginPage extends BasePage {

    private SelenideElement aLogo = $(By.xpath("//div[contains(@class, 'sc-cabOPr ikNyeA')]"));
    private SelenideElement logoAnimation = $(By.xpath("//span[@class= 'sc-iTFTee cdTuVt']"));
    private SelenideElement buttonRussianLanguage = $(By.xpath("//div[@class= 'sc-cjibBx jUObuW']"));
    private SelenideElement buttonEnglishLanguage = $(By.xpath("//div[@class= 'sc-cjibBx eERZfZ']"));
    private SelenideElement signatureВходOnLoginWindow = $(By.xpath("//h3[@class= 'sc-bqWxrE jMnyrV' and text()= 'Вход']"));
    private SelenideElement signatureLogInOnLoginWindow = $(By.xpath("//h3[@class= 'sc-bqWxrE jMnyrV' and text()= 'Log in']"));

    final static String START_URL = PropertyHelper.getProperty("start.url");

    public LoginPage open() {
        Selenide.open(START_URL);
        return new LoginPage();
    }

    @Step("Visibility of bank logo")
    public boolean checkBankLogo() {
        this.getALogo().shouldBe(Condition.visible, ofSeconds(10)).isDisplayed();
        return true;
    }

    @Step("Visibility of bank logo text")
    public boolean checkBankLogoText() {
        actions().moveToElement(logoAnimation).build().perform();
        return true;
    }

    @Step("Check visibility of both bank logo elements")
    public boolean checkBothBankLogoElements() {
        assertTrue(this.checkBankLogo());
        assertTrue(this.checkBankLogoText());
        return true;
    }

    @Step("Check EN button")
    public boolean checkENButtonFirst() {
        this.getButtonEnglishLanguage().shouldBe(Condition.enabled).shouldBe(Condition.visible, ofSeconds(10));
        return true;
    }

    @Step("Check EN button")
    public LoginPage closeWindow() {
        Selenide.closeWindow();
        return this;
    }

    @Step("Check RU/EN buttons functionality. Step 1")
    public LoginPage checkRULanguageButton() {
        this.getButtonRussianLanguage().shouldBe(Condition.visible, ofSeconds(10)).click();
        assertEquals(this.getSignatureВходOnLoginWindow().getText(), PageWebElements.LOG_IN_RU_SIGNATURE_ON_LOGIN_WINDOW);
        return this;
    }

    @Step("Check RU/EN buttons functionality. Step 2")
    public LoginPage checkENLanguageButton() {
        this.getButtonEnglishLanguage().shouldBe(Condition.visible, ofSeconds(10)).click();
        assertEquals(this.getSignatureLogInOnLoginWindow().getText(), PageWebElements.LOG_IN_EN_SIGNATURE_ON_LOGIN_WINDOW);
        return this;
    }




}

