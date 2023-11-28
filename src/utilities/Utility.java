package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class Utility extends BaseTest {
    public void clickOnElement(By by)                                             //Method to click on Element
    {
        driver.findElement(by).click();
    }

    public void sendTextToElement(By by, String text)                           //Method to send text to Element
    {
        driver.findElement(by).sendKeys(text);
    }

    public String getTextFromElement(By by)                                      //Method to get text from Element
    {
        return driver.findElement(by).getText();
    }

    //************************* Alert Methods *****************************************************

    public void switchToAlert() {
        driver.switchTo().alert();                                              //Method will switch to alert
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();                                    //Method to accept alert
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();                                  //Method to dismiss alert
    }

    public String getTextFromAlert()                                         //Method to get text from alert
    {
        return driver.switchTo().alert().getText();
    }

    //*************************** Select Class Methods ***************************************//

    public void selectByValueFromDropDown(By by, String value)                    //Method to select value from Dropdown
    {
        WebElement dropDown = driver.findElement(by);
        Select s1 = new Select(dropDown);
        s1.selectByValue(value);
    }

    public void selectByVisibleTextFromDropDown(By by, String text)               //Method to select by visible text from Drop down
    {
        WebElement dropDown = driver.findElement(by);
        Select s1 = new Select(dropDown);
        s1.selectByVisibleText(text);
    }

    public void selectByIndexFromDropDown(By by, int index)                      //Method to select index from drop down
    {
        WebElement dropDown = driver.findElement(by);
        Select s1 = new Select(dropDown);
        s1.selectByIndex(index);
    }

    //*************************** Action Methods ***************************************//
    public void mouseHoverToElement(By by)                                   //Method to mouse hover on element
    {
        WebElement mouseHover = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(mouseHover).build().perform();
    }
    public void mouseHoverAndClick(By by){
        Actions actions = new Actions(driver);
        WebElement mouseHover2 = driver.findElement(by);
        actions.moveToElement(mouseHover2).click().build().perform();
    }
    public void verifyText(By by, String actualMessage) {
        String expected = getTextFromElement(by);
        String expectedString = expected.substring(0, actualMessage.length());
        Assert.assertEquals(expectedString, actualMessage);
    }

    //***************************Ascending order method**************************************************
    public boolean verifyTheListIsAscedingOrder(By by) {
        List<WebElement> list = driver.findElements(by);

        boolean isAsceding = false;

        for (int i = 0; i < list.size() - 1; i++) {
            // System.out.println(list.get(i).getText());
            if (list.get(i).getText().compareTo(list.get(i + 1).getText()) > 0) {
                isAsceding = true;
            }
        }
        return isAsceding;
    }
    /**
     * This method will verify the two text from the elements
     */
    public void verifyTheStringMessage(By by, String actualMessage) {
        String expected = getTextFromElement(by);
        String expectedString = expected.substring(0, actualMessage.length());
        Assert.assertEquals(expectedString, actualMessage);
    }

    }

