package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.testPage;
import utilities.ConfigReader;
import utilities.Driver;

public class test1 {
    String paraninDegeri;


    testPage test= new testPage();

    @Given("Kullanici google sayfasina gider")
    public void kullanici_google_sayfasina_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @Then("Arama Kutusuna karsilastirma yapmak istedigi para birimlerini girer")
    public void arama_kutusuna_karsilastirma_yapmak_istedigi_para_birimlerini_girer() {
    test.googleAramaKutusu.sendKeys("Euro to Dollar"+ Keys.ENTER);
    }
    @Then("Para birimlerinin karsilastirmasini alir")
    public void para_birimlerinin_karsilastirmasini_alir() {
      paraninDegeri=test.karsilastirilanDeger.getText();
        String paraDegis=paraninDegeri.replaceAll(",", ".");
        System.out.println(paraDegis);

    }

    @And("Verilen degerlerin iki den kucuk oldugunu dogrular")
    public void verilenDegerlerinIkiDenKucukOldugunuDogrular() {

        String paraDegis=paraninDegeri.replaceAll(",", ".");
        Assert.assertTrue(Double.parseDouble(paraDegis)<20.0);
    }
    @Then("Kullanici sayfayi kapatir")
    public void kullanici_sayfayi_kapatir() {
      Driver.closeDriver();
    }

    @Then("Arama Kutusuna Dollar to Euro karsilastirma yapmak istedigi para birimlerini girer")
    public void aramaKutusunaDollarToEuroKarsilastirmaYapmakIstedigiParaBirimleriniGirer() {
        test.googleAramaKutusu.sendKeys("Dollar to Euro"+ Keys.ENTER);
    }
}
