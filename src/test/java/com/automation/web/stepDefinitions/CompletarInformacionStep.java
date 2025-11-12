package com.automation.web.stepDefinitions;

import com.automation.web.hooks.Hooks;
import com.automation.web.pages.CarroPage;
import com.automation.web.pages.CheckoutPage;
import com.automation.web.pages.InventarioPage;
import com.automation.web.pages.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.AssertionsForClassTypes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CompletarInformacionStep {

    private WebDriver driver = Hooks.getDriver();
    private CheckoutPage checkoutPage;
    private LoginPage loginPage;
    private InventarioPage inventarioPage;
    private CarroPage carroPage;

    @Given("que el usuario está en el formulario de checkout")
    public void que_el_usuario_esta_en_el_formulario_de_checkout() {
        driver = Hooks.getDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        loginPage.ingresarCredenciales("standard_user", "secret_sauce");
        inventarioPage = new InventarioPage(driver);
        inventarioPage.agregarProductosCarro();
        inventarioPage.clickCarroCompras();
        carroPage = new CarroPage(driver);
        assertThat(carroPage.obtenerNumeroDeProductosEnCarro()).isGreaterThan(0);
        carroPage.clickCheckout();
        checkoutPage = new CheckoutPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        assertThat(checkoutPage.paginaCheckoutInformacion()).isTrue();
    }

    @When("completa los campos obligatorios")
    public void completaLosCamposObligatorios() {
        checkoutPage.completarInformacionCliente("QA", "Automation", "12345");
    }

    @And("hacer click en Continuar")
    public void hace_clic_en_continuar() {
        checkoutPage.hacerClickContinuar();
    }

    @Then("debe visualizar el resumen del pedido {string}")
    public void debeVisualizarElResumenDelPedido(String tituloEsperado) {
        checkoutPage = new CheckoutPage(driver);
        AssertionsForClassTypes.assertThat(checkoutPage.paginaCheckoutDescripcionGeneral()).isTrue();
    }

}
