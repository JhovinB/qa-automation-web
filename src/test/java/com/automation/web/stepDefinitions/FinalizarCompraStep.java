package com.automation.web.stepDefinitions;

import com.automation.web.hooks.Hooks;
import com.automation.web.pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.AssertionsForClassTypes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FinalizarCompraStep {

    private WebDriver driver;
    private FinalizarCompraPage finalizarCompraPage;
    private LoginPage loginPage;
    private InventarioPage inventarioPage;
    private CarroPage carroPage;
    private CheckoutPage checkoutPage;

    @Given("que el usuario está en el resumen de compra")
    public void que_el_usuario_esta_en_el_resumen_de_compra() {
        driver = Hooks.getDriver();
        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
        loginPage.ingresarCredenciales("standard_user", "secret_sauce");

        inventarioPage = new InventarioPage(driver);
        inventarioPage.agregarProductosCarro();
        inventarioPage.clickCarroCompras();

        carroPage = new CarroPage(driver);
        carroPage.clickCheckout();

        checkoutPage = new CheckoutPage(driver);
        checkoutPage.completarInformacionCliente("QA", "Automation", "12345");
        checkoutPage.hacerClickContinuar();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        finalizarCompraPage = new FinalizarCompraPage(driver);
    }

    @When("hace clic en Finish")
    public void hace_clic_en_finish() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        finalizarCompraPage.hacerClickEnFinish();
    }

    @Then("debe mostrarse el mensaje de confirmación {string}")
    public void debe_mostrarse_el_mensaje_de_confirmacion(String mensajeEsperado) {
        finalizarCompraPage = new FinalizarCompraPage(driver);

        AssertionsForClassTypes.assertThat(finalizarCompraPage.paginaFinalCompra())
                .as("Verifica que la URL /checkout-complete.html")
                .isTrue();

        String mensajeActual = finalizarCompraPage.obtenerMensajeConfirmacion();
        AssertionsForClassTypes.assertThat(mensajeActual)
                .as("Verificar mensaje de confirmación")
                .isEqualTo(mensajeEsperado);
    }
}
