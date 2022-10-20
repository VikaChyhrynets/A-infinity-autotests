package uitests;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


@Epic("E-1. Registration/Authorization/Security")
public class LoginTest extends BaseUITest {

    @Story("US-1.1 Main Page")
    @TmsLink("C5960672")
    @Test(description = "visibility of bank logo")
    public void checkALogoPresence() {
        assertTrue(loginPage.checkBankLogos());
    }


}
