package uitests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import ui.LoginPage;


public class BaseUITest {

    protected LoginPage loginPage = new LoginPage();


    @BeforeMethod
    public void setUp() {
        loginPage.open();
    }

    @BeforeClass
    public void navigateToLoginPage() {
        Configuration.startMaximized = true;
        SelenideLogger.addListener("allure", new AllureSelenide());
    }


}
