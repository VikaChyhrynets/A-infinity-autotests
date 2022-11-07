package uitests;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import io.qameta.allure.TmsLinks;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.PageWebElements;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


@Epic("E-1. Registration/Authorization/Security")
public class LoginTest extends BaseUITest {


    @Story("US-1.1 Main Page")
    @TmsLinks({@TmsLink("5960672"), @TmsLink("5993211")})
    @Test(description = "Visibility of bank logos")
    public void checkALogoPresence() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginPage.checkBankLogo());
        softAssert.assertTrue(loginPage.checkBankLogoText());
        softAssert.assertAll();
    }

    @Story("US-1.1 Main Page")
    @TmsLink("5973220")
    @Test(description = "Open Main page to check EN button enability")
    public void checkENButtonGoesFirst() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginPage.checkENButtonFirst());
        loginPage.closeWindow().open();
        softAssert.assertTrue(loginPage.checkENButtonFirst());
        softAssert.assertAll();
    }

    @Story("US-1.1 Main Page")
    @TmsLink("5993315")
    @Test(description = "The system switches on EN-button and makes it active")
    public void checkRUandENButtons() {
        loginPage.clickRUButton().checkRULanguageButton();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(loginPage.getSignatureВходOnLoginWindow().getText(), PageWebElements.LOG_IN_RU_SIGNATURE_ON_LOGIN_WINDOW);
        loginPage.closeWindow().open();
        loginPage.checkENLanguageButton();
        softAssert.assertEquals(loginPage.getSignatureLogInOnLoginWindow().getText(), PageWebElements.LOG_IN_EN_SIGNATURE_ON_LOGIN_WINDOW);
        softAssert.assertAll();
    }

    @Story("US-1.1 Main Page")
    @TmsLinks({@TmsLink("5960939"), @TmsLink("5993609"), @TmsLink("5993613")})
    @Test(description = "Check the availability elements of Slider")
    public void checkSliderElementsAvailability() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginPage.checkLearnMoreButton());
        softAssert.assertTrue(loginPage.checkAdvertisementText());
        softAssert.assertTrue(loginPage.checkPaginationElement());
        loginPage.checkPaginationElementFunctionality();
        softAssert.assertTrue(loginPage.checkScrollButton());
        softAssert.assertAll();
    }

    @Story("US-1.1 Main Page")
    @TmsLink("5994972")
    @Test(description = "Presence of authorization block")
    public void checkAuthorizationBlock() {
        assertTrue(loginPage.checkAuthorizationBlock());
    }

    @Story("US-1.1 Main Page")
    @TmsLinks({@TmsLink("5993620"), @TmsLink("5960985"), @TmsLink("5993619")})
    @Test(description = "Links functionality")
    public void checkDownloadElements() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(loginPage.getDownloadSignature().getText(), PageWebElements.DOWNLOAD_SIGNATURE);
        softAssert.assertTrue(loginPage.checkAppStoreButton());
        softAssert.assertTrue(loginPage.checkGooglePlayButton());
        softAssert.assertAll();
    }

    @Story("US-1.1 Main Page")
    @TmsLinks({@TmsLink("5960984"), @TmsLink("5973202")})
    @Test(description = "Click on the download button to verify its functionality")
    public void downloadButtonsFunctionality() {
        loginPage.checkAppStoreDownloadButtonsFunctionality().
                closeWindow().
                open().
                checkGooglePlayDownloadButtonsFunctionality();
    }

    @Story("US-1.2 User authorization")
    @TmsLink("6018721")
    @Test(description = "Verify the functionality of the button 'By ID'")
    public void checkIDButton() {
        loginPage.clickIDButton();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginPage.checkIDButtonFunctionality());
        assertEquals(loginPage.getFieldID().getText(), PageWebElements.ID_FIELD);
        softAssert.assertAll();
    }

    /*
    For the 2 following TC asserts should be added. We need connection to the DB, which doesn't exist at the moment.
    */
    @Story("US-1.2 User authorization")
    @TmsLinks({@TmsLink("5964801"), @TmsLink("5964738")})
    @Test(description = "Successful registration with email, EN version")
    public void registerByEmailSuccessEN() {
        loginPage.enterValidEmail().
                enterValidPassword().
                clickLoginButton();
    }

    @Story("US-1.2 User authorization")
    @TmsLink("5963986")
    @Test(description = "Verify the successful authorization by ID")
    public void registerByPassportIDSuccessRU() {
        loginPage.clickIDButton().
                enterValidPassportID().
                enterValidPassword().
                clickLoginButton();
    }



}
