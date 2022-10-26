package uitests;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import io.qameta.allure.TmsLinks;
import org.testng.annotations.Test;
import utils.PageWebElements;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


@Epic("E-1. Registration/Authorization/Security")
public class LoginTest extends BaseUITest {

    @Story("US-1.1 Main Page")
    @TmsLinks({@TmsLink("5960672"), @TmsLink("5993211")})
    @Test(description = "Visibility of bank logos")
    public void checkALogoPresence() {
        assertTrue(loginPage.checkBankLogo());
        assertTrue(loginPage.checkBankLogoText());
    }

    @Story("US-1.1 Main Page")
    @TmsLink("5973220")
    @Test(description = "Open Main page to check EN button enability")
    public void checkENButtonGoesFirst() {
        loginPage.checkENButtonFirst();
        loginPage.closeWindow().open().checkENButtonFirst();
    }

    @Story("US-1.1 Main Page")
    @TmsLink("5993315")
    @Test(description = "The system switches on EN-button and makes it active")
    public void checkRUandENButtons() {
        loginPage.checkRULanguageButton();
        loginPage.closeWindow();
        loginPage.open();
        assertEquals(loginPage.getSignatureВходOnLoginWindow().getText(), PageWebElements.LOG_IN_RU_SIGNATURE_ON_LOGIN_WINDOW);
        loginPage.checkENLanguageButton();
        assertEquals(loginPage.getSignatureLogInOnLoginWindow().getText(), PageWebElements.LOG_IN_EN_SIGNATURE_ON_LOGIN_WINDOW);
    }

    @Story("US-1.1 Main Page")
    @TmsLinks({@TmsLink("5960939"), @TmsLink("5993609"), @TmsLink("5993613")})
    @Test(description = "Check the availability elements of Slider")
    public void checkSliderElementsAvailability() {
        assertTrue(loginPage.checkLearnMoreButton());
        assertTrue(loginPage.checkAdvertisementText());
        assertTrue(loginPage.checkPaginationElement());
        loginPage.checkPaginationElementFunctionality();
        assertTrue(loginPage.checkScrollButton());
    }

    @Story("US-1.1 Main Page")
    @TmsLink("5994972")
    @Test(description = "Presence of authorization block")
    public void checkAuthorizationBlock() {
        assertTrue(loginPage.checkAuthorizationBlock());
    }

    @Story("US-1.1 Main Page")
    @TmsLinks({@TmsLink("5993620"), @TmsLink("5960985"), @TmsLink("5993619")})
    @Test(description = "Presence of authorization block")
    public void checkDownloadElements() {
        assertEquals(loginPage.getDownloadSignature().getText(), PageWebElements.DOWNLOAD_SIGNATURE);
        assertTrue(loginPage.checkAppStoreButton());
        assertTrue(loginPage.checkGooglePlayButton());
    }

    @Story("US-1.1 Main Page")
    @TmsLinks({@TmsLink("5960984"), @TmsLink("5973202")})
    @Test(description = "Click on the download button to verify its functionality")
    public void downloadButtonsFunctionality() {
        loginPage.checkAppStoreDownloadButtonsFunctionality();
        loginPage.closeWindow();
        loginPage.open();
        loginPage.checkGooglePlayDownloadButtonsFunctionality();
    }

}
