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
    @Test(description = "visibility of bank logos")
    public void checkALogoPresence() {
        loginPage.checkBothBankLogoElements();
    }

    @Story("US-1.1 Main Page")
    @TmsLink("C5973220")
    @Test(description = "open Main page to check EN button enability")
    public void checkENButtonGoesFirst() {
        loginPage.checkENButtonFirst();
        loginPage.closeWindow().open().checkENButtonFirst();
    }

    @Story("US-1.1 Main Page")
    @TmsLink("C5993315")
    @Test(description = "functionality of the buttons RU/EN is verified")
    public void checkRUandENButtons() {
        loginPage.checkRULanguageButton();
        loginPage.closeWindow();
        loginPage.open();
        assertEquals(loginPage.getSignatureВходOnLoginWindow().getText(), PageWebElements.LOG_IN_RU_SIGNATURE_ON_LOGIN_WINDOW);
        loginPage.checkENLanguageButton();
    }

    @Story("US-1.1 Main Page")
    @TmsLink("C5960939")
    @Test(description = "check the availability elements of Slider")
    public void checkSliderElementsAvailability() {
        loginPage.checkLearnMoreButton();
        loginPage.checkAdvertisementText();
        loginPage.checkPaginationElement();
        loginPage.checkPaginationElementFunctionality();
        loginPage.checkScrollBlockButton();
    }


}
