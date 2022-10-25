package uitests;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import io.qameta.allure.TmsLinks;
import org.testng.annotations.Test;
import utils.PageWebElements;

import static org.testng.Assert.assertEquals;


@Epic("E-1. Registration/Authorization/Security")
public class LoginTest extends BaseUITest {

    @Story("US-1.1 Main Page")
    @TmsLinks({@TmsLink("C5960672"), @TmsLink("C5993211")})
    @Test(description = "Visibility of bank logos")
    public void checkALogoPresence() {
        loginPage.checkBothBankLogoElements();
    }

    @Story("US-1.1 Main Page")
    @TmsLink("C5973220")
    @Test(description = "Open Main page to check EN button enability")
    public void checkENButtonGoesFirst() {
        loginPage.checkENButtonFirst();
        loginPage.closeWindow().open().checkENButtonFirst();
    }

    @Story("US-1.1 Main Page")
    @TmsLink("C5993315")
    @Test(description = "Functionality of the buttons RU/EN is verified")
    public void checkRUandENButtons() {
        loginPage.checkRULanguageButton();
        loginPage.closeWindow();
        loginPage.open();
        assertEquals(loginPage.getSignatureВходOnLoginWindow().getText(), PageWebElements.LOG_IN_RU_SIGNATURE_ON_LOGIN_WINDOW);
        loginPage.checkENLanguageButton();
    }

    @Story("US-1.1 Main Page")
    @TmsLinks({@TmsLink("C5960939"), @TmsLink("C5993609"), @TmsLink("C5993613")})
    @Test(description = "Check the availability elements of Slider")
    public void checkSliderElementsAvailability() {
        loginPage.checkLearnMoreButton();
        loginPage.checkAdvertisementText();
        loginPage.checkPaginationElement();
        loginPage.checkPaginationElementFunctionality();
        loginPage.checkScrollBlockButton();
    }

    @Story("US-1.1 Main Page")
    @TmsLink("C5994972")
    @Test(description = "Presence of authorization block")
    public void checkAuthorizationBlock() {
        loginPage.checkAuthBlock();
    }

    @Story("US-1.1 Main Page")
    @TmsLinks({@TmsLink("C5993620"), @TmsLink("C5960985"), @TmsLink("C5993619")})
    @Test(description = "Presence of authorization block")
    public void checkDownloadElements() {
        loginPage.checkDownloadElements();
    }

    @Story("US-1.1 Main Page")
    @TmsLinks({@TmsLink("C5960984"), @TmsLink("C5973202")})
    @Test(description = "Click on the download button to verify its functionality")
    public void downloadButtonsFunctionality() {
        loginPage.checkAppStoreDownloadButtonsFunctionality();
        loginPage.closeWindow();
        loginPage.open();
        loginPage.checkGooglePlayDownloadButtonsFunctionality();
    }

}
