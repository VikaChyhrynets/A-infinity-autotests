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
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
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
    private SelenideElement learnMoreButton = $(By.xpath("//button[@class= 'sc-iBYQkv bUJhjl']"));
    private SelenideElement advertisementText = $(By.xpath("//h2[@class= 'sc-gKPRtg dgZqlG']"));
    private SelenideElement paginationElement = $(By.xpath("//div[@class= 'sc-gswNZR dHlgSu']"));
    private SelenideElement paginationButton1 = $(By.xpath("//div[@class= 'sc-gswNZR dHlgSu']//div[@class= 'sc-dkrFOg efXKez'][1]"));
    private SelenideElement paginationButton2 = $(By.xpath("//div[@class= 'sc-gswNZR dHlgSu']//div[@class= 'sc-dkrFOg efXKez'][2]"));
    private SelenideElement scrollBlockButton = $(By.xpath("//div[@class= 'sc-ftTHYK dsVtTr']"));
    private SelenideElement authorizationBlock = $(By.xpath("//div[@class= 'sc-eDWCr iJWEXl']"));
    private SelenideElement downloadSignature = $(By.xpath("//p[@class= 'sc-csuSiG iOOaX']"));
    private SelenideElement downloadAppStoreButton = $(By.xpath("//a[contains(@href, 'https://www.apple.com/app-store/')]"));
    private SelenideElement downloadGooglePlayButton = $(By.xpath("//a[@class= 'sc-iJnaPW iqrwfH'][2]"));

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

    @Step("Check the button 'Learn more'")
    public boolean checkLearnMoreButton() {
        assertTrue(this.getLearnMoreButton().shouldBe(Condition.visible, ofSeconds(10)).isDisplayed());
        return true;
    }

    @Step("Check the advertisement text")
    public boolean checkAdvertisementText() {
        assertTrue(this.getAdvertisementText().shouldBe(Condition.visible, ofSeconds(10)).isDisplayed());
        return true;
    }

    @Step("Check pagination element")
    public boolean checkPaginationElement() {
        assertTrue(this.getPaginationElement().shouldBe(Condition.visible, ofSeconds(10)).isDisplayed());
        return true;
    }

    @Step("Check pagination element")
    public LoginPage checkPaginationElementFunctionality() {
        this.getPaginationButton1().shouldBe(Condition.visible, ofSeconds(10)).click();
        sleep(5000);
        this.getPaginationButton2().shouldBe(Condition.visible, ofSeconds(10)).click();
        return this;
    }

    @Step("Check button 'Scroll block'")
    public boolean checkScrollBlockButton() {
        assertTrue(this.getScrollBlockButton().shouldBe(Condition.visible, ofSeconds(10)).isDisplayed());
        return true;
    }

    @Step("Visibility of authorization block")
    public boolean checkAuthBlock() {
        assertTrue(this.getAuthorizationBlock().shouldBe(Condition.visible, ofSeconds(10)).isDisplayed());
        return true;
    }

    @Step("Check download possibility")
    public boolean checkDownloadElements() {
        assertEquals(this.getDownloadSignature().getText(), PageWebElements.DOWNLOAD_SIGNATURE);
        assertTrue(this.getDownloadAppStoreButton().shouldBe(Condition.visible, ofSeconds(10)).isDisplayed());
        assertTrue(this.getDownloadGooglePlayButton().shouldBe(Condition.visible, ofSeconds(10)).isDisplayed());
        return true;
    }

    @Step("Check APPStore download button functionality")
    public LoginPage checkAppStoreDownloadButtonsFunctionality() {
        this.getDownloadAppStoreButton().click();
        String mainPageWindow = getWebDriver().getWindowHandle();
        for (String windowHandle : webdriver().object().getWindowHandles()) {
            if (!mainPageWindow.contentEquals(windowHandle)) {
                getWebDriver().switchTo().window(windowHandle);
                break;
            }
        }
        return this;
    }

    @Step("Check APPStore download button functionality")
    public LoginPage checkGooglePlayDownloadButtonsFunctionality() {
        this.getDownloadGooglePlayButton().click();
        String mainPageWindow = getWebDriver().getWindowHandle();
        for (String windowHandle : webdriver().object().getWindowHandles()) {
            if (!mainPageWindow.contentEquals(windowHandle)) {
                getWebDriver().switchTo().window(windowHandle);
                break;
            }
        }
        return this;
    }


}

