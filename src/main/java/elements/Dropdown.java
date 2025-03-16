package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dropdown {
    WebDriver driver;
    String label;
    private static final String SIMPLE_DROPDOWN_XPATH = "//*[contains(text(), '%s')]/ancestor::*[contains(@slot, 'inputField')]//button";
    private static final String EXTENDED_DROPDOWN_XPATH = "//*[contains(text(), '%s')]/ancestor::*[contains(@slot, 'inputField')]//input";
    private static final String DROPDOWN_OPTION_XPATH = "//*[contains(@title, '%s')]";

    public Dropdown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void selectOptionForSimpleDropdown(String option) {
        driver.findElement(By.xpath(String.format(SIMPLE_DROPDOWN_XPATH, label))).click();
        driver.findElement(By.xpath(String.format(DROPDOWN_OPTION_XPATH, option))).click();
    }

    public void selectOptionForExtendedDropdown(String option) {
        driver.findElement(By.xpath(String.format(EXTENDED_DROPDOWN_XPATH, label))).click();
        driver.findElement(By.xpath(String.format(DROPDOWN_OPTION_XPATH, option))).click();
    }
}
