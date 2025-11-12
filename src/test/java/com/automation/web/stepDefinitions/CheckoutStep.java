package com.automation.web.stepDefinitions;

import com.automation.web.hooks.Hooks;
import com.automation.web.pages.CarroPage;
import com.automation.web.pages.CheckoutPage;
import com.automation.web.pages.InventarioPage;
import com.automation.web.pages.LoginPage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.AssertionsForClassTypes;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CheckoutStep {

    private WebDriver driver;
    private LoginPage loginPage;
    private InventarioPage inventarioPage;
    private CarroPage carroPage;
    private CheckoutPage checkoutPage;

    @Given("que el usuario tiene productos en el carrito")
    public void que_el_usuario_tiene_productos_en_el_carrito() {
        driver = Hooks.getDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        loginPage.ingresarCredenciales("standard_user", "secret_sauce");
        inventarioPage = new InventarioPage(driver);
        inventarioPage.agregarProductosCarro();
        inventarioPage.clickCarroCompras();
        carroPage = new CarroPage(driver);
        assertThat(carroPage.obtenerNumeroDeProductosEnCarro()).isGreaterThan(0);
    }

    @When("navega al carrito y hace clic en Checkout")
    public void navega_al_carrito_y_hace_clic_en_checkout() {
        carroPage.clickCheckout();
    }


    @Then("debe mostrarse el formulario de información del cliente {string}")
    public void debeMostrarseElFormularioDeInformaciónDelCliente(String tituloEsperado) {
        checkoutPage = new CheckoutPage(driver);
        AssertionsForClassTypes.assertThat(checkoutPage.paginaCheckoutInformacion()).isTrue();
        String tituloActual = checkoutPage.obtenerTituloCheckoutInformacion();
        AssertionsForClassTypes.assertThat(tituloActual).isEqualTo(tituloEsperado);
    }
}
