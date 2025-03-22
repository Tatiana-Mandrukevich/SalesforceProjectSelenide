package elements;

import com.codeborne.selenide.SelenideElement;

public class Button {

    public Button() {
    }

    public void clickOnButton(SelenideElement element) {
        element.click();
    }
}