package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class WomenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyTheSortByProductNameFilter() {

//* Mouse Hover on Women Menu
mouseHoverToElement(By.xpath("//span[normalize-space()='Women']"));
//* Mouse Hover on Tops
mouseHoverToElement(By.xpath("//a[@id='ui-id-9']//span[contains(text(),'Tops')]"));
//* Click on Jackets
mouseHoverAndClick(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));
// Select Sort By filter “Product Name”
selectByValueFromDropDown(By.xpath("//div[@class='page-wrapper']//div[2]//div[3]//select[1]"), "name");
//* Verify the products name display in alphabetical order
verifyTheListIsAscedingOrder(By.xpath("//strong[@class = 'product name product-item-name']"));

}
// 2. verifyTheSortByPriceFilter
@Test
public void verifyTheSortByPriceFilter() throws InterruptedException {
//* Mouse Hover on Women Menu
Thread.sleep(200);
mouseHoverToElement(By.xpath("//span[normalize-space()='Women']"));
//* Mouse Hover on Tops
    Thread.sleep(20);
mouseHoverToElement(By.xpath("//a[@id='ui-id-9']//span[contains(text(),'Tops')]"));
//* Click on Jackets
mouseHoverAndClick(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));
//* Select Sort By filter “Price”
selectByValueFromDropDown(By.xpath("//div[@class='page-wrapper']//div[2]//div[3]//select[1]"), "price");
//* Verify the products price display in Low to High
verifyTheListIsAscedingOrder(By.xpath("//span[@class = 'normal-price']//span[@class = 'price']"));
}
    @After
    public void tearDown(){
        closedBrowser();
    }
}
