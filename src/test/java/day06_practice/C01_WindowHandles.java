package day06_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C01_WindowHandles extends TestBase {
    @Test
    public void test01() {
        // 'https://www.n11.com' adresine gidin
        // arama motoruna 'Oppo' yazıp aratın
        // ilk ürüne tıklayın
        // ikinci sayfa Title'ının 'Türkiye' icerdigini test edin.
        // ilk sayfaya donun ve Title'ını yazdırın


        // 'https://www.n11.com' adresine gidin
        driver.get("https://www.n11.com");
        bekle(2);

        // arama motoruna 'Oppo' yazıp aratın
        WebElement searchBox = driver.findElement(By.xpath("//*[@*='searchData']"));
        searchBox.sendKeys("Oppo"+ Keys.ENTER);
        bekle(2);


        // ilk ürüne tıklayın
        WebElement firstProduct = driver.findElement(By.xpath("//div[@id='p-546000141']"));
        firstProduct.click();
        bekle(2);

        // ikinci sayfa Title'ının 'Türkiye' icerdigini test edin.
        List<String> pencereler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pencereler.get(1));
        //driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());  List olusturmadan böyle de yapabilirsin
        bekle(3);
        String firstProductTitle = driver.getTitle();
        Assert.assertTrue(firstProductTitle.contains("Türkiye"));
        driver.switchTo().window(pencereler.get(0));
        bekle(2);

        // ilk sayfaya donun ve Title'ını yazdırın
        System.out.println(driver.getTitle());


    }
}
