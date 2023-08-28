package day06_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C03_ActionMoveToElement extends TestBase {
    @Test
    public void test01() {
        // https://amazon.com adresine gidiniz
        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
        // Change country/region butonuna basiniz
        // United States dropdown'undan 'Turkey (Türkiye)' seciniz
        // Go to website butonuna tiklayiniz
        // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz

        // https://amazon.com adresine gidiniz
        driver.get("https://amazon.com");

        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
        Actions actions = new Actions(driver);
        WebElement secenek = driver.findElement(By.xpath("(//span[@class='nav-icon nav-arrow'])[1]"));
        actions.moveToElement(secenek).perform();
        bekle(2);

        // Change country/region butonuna basiniz
        driver.findElement(By.xpath("(//div[@class='icp-mkt-change-lnk'])[1]")).click();
        bekle(2);

        // United States dropdown'undan 'Turkey (Türkiye)' seciniz
        WebElement ddm = driver.findElement(By.xpath("//select[@id='icp-dropdown']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Turkey (Türkiye)");
        bekle(2);

        // Go to website butonuna tiklayiniz

        /*
        dropdown opsiyon listesi 'Go to website' butonuna basmamıza engel oldugu icin
        herhangi bir yere clic yapıp dropdown option listesinin toparlanmasını sagladık.
         */
        driver.findElement(By.xpath("//a[@id='icp-dropdown_18']")).click();
        driver.findElement(By.xpath("//span[@id='icp-save-button']")).click();
        bekle(2);

        // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        String actual = driver.getTitle();
        String expected = "Elektronik";
        Assert.assertTrue(actual.contains(expected));









    }
}
