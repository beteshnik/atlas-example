package service;

import common.Application;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import org.apache.commons.io.FileUtils;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import static common.Browser.getDriver;


public class ServicePage {
    private static final int periodElementWait = Integer.parseInt(Application.getProperty("periodElementWait"));
    private static final int periodLoadWait = Integer.parseInt(Application.getProperty("periodElementWait"));
    private static final int periodFrameWait = Integer.parseInt(Application.getProperty("periodElementWait"));
    private static final int periodInvisibleWait = Integer.parseInt(Application.getProperty("periodInvisibleWait"));

    public static void waitForLoad() {
        new WebDriverWait(getDriver(), periodLoadWait).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    public static boolean pageIsLoaded() {
        return ((JavascriptExecutor) getDriver()).executeScript("return document.readyState").equals("complete");
    }

    public static void waitWhileElemIsVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), periodElementWait);
        wait.until(
                ExpectedConditions.visibilityOf(element));
    }

    public static void waitWhileElemIsPresent(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), periodElementWait);
        wait.until(
                ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void waitWhileElemIsClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), periodElementWait);
        wait.until(
                ExpectedConditions.elementToBeClickable(element));
    }

    public static void clickAndMakeScreenshot(WebElement element, String message) throws IOException {
        makeScreenShot("До нажатия на: " + message);
        Application.log(String.format("Кликаю на '%s'", message));
        element.click();
    }

    public static void makeScreenShot(String message) throws IOException {
        File scrFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(getAbsolutePath("/screenshots/"+currentUnixTime()+message+".png")));
    }

    public static void type(WebElement element, String value) {
        element.sendKeys(value);
    }

    public static void waitSeconds(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //принудительное удаление
    public static void clearByDell(WebElement element) {
        //очистка вручную
        element.sendKeys(Keys.HOME);
        element.sendKeys(Keys.chord(Keys.SHIFT, Keys.END));
        element.sendKeys(Keys.DELETE);
    }

    //выделить текст
    public static void selectByKeys(WebElement element) {
        //очистка вручную
        element.sendKeys(Keys.HOME);
        element.sendKeys(Keys.chord(Keys.SHIFT, Keys.END));
    }

    public static String getValueText(WebElement field) {
        try {
            if (field.getAttribute("value").equals("")) {
                return null;
            } else
                return field.getAttribute("value");
        } catch (NoSuchElementException | NullPointerException e) {
            return null;
        }
    }

    public static String getText(WebElement field) {
        try {
            if (field.getText().equals("") || field.getText().equals("-") || field.getText().contains("Не определено")) {
                return null;
            } else
                return field.getText();
        } catch (NoSuchElementException | NullPointerException e) {
            return null;
        }
    }

    //получаем абсолютный путь к файлу
    public static String getAbsolutePath(String path) throws IOException {
        System.out.println(new File("src/test/resources/data/" + path).getCanonicalPath());
        return new File("src/test/resources/data/" + path).getCanonicalPath();
    }

    public static void setCheckBox(WebElement element, String message) throws IOException {
        if (!element.isSelected()) clickAndMakeScreenshot(element, message);
    }

    public static void unSetCheckBox(WebElement element, String message) throws IOException {
        if (element.isSelected()) clickAndMakeScreenshot(element, message);
    }

    //ожидаем исчезновение элемента
    public static void waitUntilElementInvisibile(WebElement webElement) {
        int counter = 0, second = 1; // интервал проверки

        getDriver().manage().timeouts().implicitlyWait(periodInvisibleWait, TimeUnit.SECONDS);
        try {
            while (webElement.isDisplayed()) {
                waitSeconds(second);
                counter += second;
                System.out.println(counter);

                if (counter > periodElementWait)
                    throw new RuntimeException("Элемент не исчез спустя (sec): " + periodElementWait);
            }
        } catch (Exception e) {
        }
    }

    public static void acceptAlert() {
        getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        getDriver().navigate().refresh();
        try {
            Alert alert = getDriver().switchTo().alert();
            alert.accept();

        } catch (NoAlertPresentException ex) {
        }
    }

    //определяем текущую дату
    public static String currentDate() {
        DateTimeFormatter date = (DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        LocalDateTime now = LocalDateTime.now();
        return date.format(now);
    }
    //определяем текущую дату
    public static long currentUnixTime() {
        return System.currentTimeMillis() / 1000L;
    }


}



