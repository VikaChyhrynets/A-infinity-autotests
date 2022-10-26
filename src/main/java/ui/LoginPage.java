package ui;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Data;
import org.openqa.selenium.By;
import utils.PropertyHelper;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.sleep;

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
        element.expectedVisibilityOfWebElements(getALogo(), 5).isDisplayed(getALogo());
        return true;
    }

    @Step("Visibility of bank logo text")
    public boolean checkBankLogoText() {
        actions().moveToElement(logoAnimation).build().perform();
        return true;
    }

    @Step("Check EN button")
    public boolean checkENButtonFirst() {
        element.checkButtonEnability(getButtonEnglishLanguage()).expectedVisibilityOfWebElements(getButtonEnglishLanguage(),5);
        return true;
    }

    @Step("Check EN button")
    public LoginPage closeWindow() {
        Selenide.closeWindow();
        return this;
    }

    @Step("Check RU/EN buttons functionality. Step 1")
    public LoginPage checkRULanguageButton() {
        element.expectedVisibilityOfWebElements(getButtonRussianLanguage(), 5).isDisplayed(getButtonRussianLanguage());
        return this;
    }

    @Step("Check RU/EN buttons functionality. Step 2")
    public LoginPage checkENLanguageButton() {
        element.expectedVisibilityOfWebElements(getButtonEnglishLanguage(), 5).click(getButtonEnglishLanguage());
        return this;
    }

    @Step("Check pagination element")
    public LoginPage checkPaginationElementFunctionality() {
        element.expectedVisibilityOfWebElements(getPaginationButton1(), 5).click(getPaginationButton1());
        sleep(5000);
        element.expectedVisibilityOfWebElements(getPaginationButton2(), 5).click(getPaginationButton2());
        return this;
    }

    @Step("Check button 'Learn more'")
    public boolean checkLearnMoreButton() {
        element.expectedVisibilityOfWebElements(getLearnMoreButton(), 5).isDisplayed(getLearnMoreButton());
        return true;
    }

    @Step("Check advertisement text")
    public boolean checkAdvertisementText() {
        element.expectedVisibilityOfWebElements(getAdvertisementText(), 5).isDisplayed(getAdvertisementText());
        return true;
    }

    @Step("Check if pagination element is present")
    public boolean checkPaginationElement() {
        element.expectedVisibilityOfWebElements(getPaginationElement(), 5).isDisplayed(getPaginationElement());
        return true;
    }

    @Step("Check scroll button presence")
    public boolean checkScrollButton() {
        element.expectedVisibilityOfWebElements(getScrollBlockButton(), 5).isDisplayed(getScrollBlockButton());
        return true;
    }

    @Step("Check if Log in block is present")
    public boolean checkAuthorizationBlock() {
        element.expectedVisibilityOfWebElements(getAuthorizationBlock(), 5).isDisplayed(getAuthorizationBlock());
        return true;
    }

    @Step("Check if 'Download on the AppStore' button is present")
    public boolean checkAppStoreButton() {
        element.expectedVisibilityOfWebElements(getDownloadAppStoreButton(), 5).isDisplayed(getDownloadAppStoreButton());
        return true;
    }

    @Step("Check if 'Get it on GooglePlay' button is present")
    public boolean checkGooglePlayButton() {
        element.expectedVisibilityOfWebElements(getDownloadGooglePlayButton(), 5).isDisplayed(getDownloadGooglePlayButton());
        return true;
    }

    @Step("Check APPStore download button functionality")
    public LoginPage checkAppStoreDownloadButtonsFunctionality() {
        element.click(getDownloadAppStoreButton());
        element.switchToAnotherWindow();
        return this;
    }

    @Step("Check APPStore download button functionality")
    public LoginPage checkGooglePlayDownloadButtonsFunctionality() {
        element.click(getDownloadGooglePlayButton());
        element.switchToAnotherWindow();
        return this;
    }


}

