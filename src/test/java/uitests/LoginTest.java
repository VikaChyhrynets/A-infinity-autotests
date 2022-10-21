package uitests;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import io.qameta.allure.TmsLinks;
import org.testng.annotations.Test;
import ui.LoginPage;


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
        loginPage.checkRULanguageButton().
                closeWindow().
                open().
                checkRULanguageButton().
                checkENLanguageButton();

    }



}
