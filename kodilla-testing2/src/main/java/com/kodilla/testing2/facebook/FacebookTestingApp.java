package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class FacebookTestingApp {
    public static final String XPATH_ACCEPT_COOKIES = "//button[@data-cookiebanner=\"accept_button\"]";
    public static final String XPATH_REGISTER = "//a[@data-testid=\"open-registration-form-button\"]";
    public static final String XPATH_BIRTH_DAY = "//select[@name=\"birthday_day\"]";
    public static final String XPATH_BIRTH_MONTH = "//select[@name=\"birthday_month\"]";
    public static final String XPATH_BIRTH_YEAR = "//select[@name=\"birthday_year\"]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(By.xpath(XPATH_ACCEPT_COOKIES)).click();
        driver.findElement(By.xpath(XPATH_REGISTER)).click();

        while (!driver.findElement(By.xpath(XPATH_BIRTH_DAY)).isDisplayed());

        WebElement selectBirthDay = driver.findElement(By.xpath(XPATH_BIRTH_DAY));
        Select selectBDay = new Select(selectBirthDay);
        selectBDay.selectByValue("12");
        WebElement selectBirthMonth = driver.findElement(By.xpath(XPATH_BIRTH_MONTH));
        Select selectBMonth = new Select(selectBirthMonth);
        selectBMonth.selectByValue("1");
        WebElement selectBirthYear = driver.findElement(By.xpath(XPATH_BIRTH_YEAR));
        Select selectBYear = new Select(selectBirthYear);
        selectBYear.selectByValue("1978");
    }
}
