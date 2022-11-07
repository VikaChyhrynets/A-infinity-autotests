package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.time.Duration.ofSeconds;

public class Element {

    public Element expectedVisibilityOfWebElements(SelenideElement element, Integer sec) {
        element.shouldBe(Condition.visible, ofSeconds(sec));
        return this;
    }

    public Element checkButtonEnability(SelenideElement element) {
        element.shouldBe(Condition.enabled);
        return this;
    }

    public Element isDisplayed(SelenideElement element) {
        element.isDisplayed();
        return this;
    }

    public Element click(SelenideElement element) {
        element.click();
        return this;
    }

    public Element switchToAnotherWindow() {
        String mainPageWindow = getWebDriver().getWindowHandle();
        for (String windowHandle : webdriver().object().getWindowHandles()) {
            if (!mainPageWindow.contentEquals(windowHandle)) {
                getWebDriver().switchTo().window(windowHandle);
                break;
            }
        }
        return this;
    }

    public Element sendKeys(SelenideElement element, String data) {
        element.sendKeys(data);
        return this;
    }

}
