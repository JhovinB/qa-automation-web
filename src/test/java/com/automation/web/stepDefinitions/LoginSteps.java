package com.automation.web.stepDefinitions;

import com.automation.web.hooks.Hooks;
import com.automation.web.pages.InventarioPage;
import com.automation.web.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private InventarioPage inventoryPage;

    @Given("que el usuario está en la pagina de inicio de sesion")
    public void abrirPaginaLogin() {
        driver = Hooks.getDriver();
        loginPage = new LoginPage(driver);
        loginPage.abrirPaginaLogin();
        Assert.assertTrue("Login no cargo",
                loginPage.paginaLoginCargada());
    }

    @When("ingresa credenciales validas")
    public void ingresarCredencialesValidas() {
        loginPage.ingresarCredenciales("standard_user", "secret_sauce");
    }

    @Then("es redirigido a la pagina de inventario")
    public void validarPaginaInventario() {
        inventoryPage = new InventarioPage(driver);
        inventoryPage.paginaDeInventarioCargada();
    }

    @Then("visualiza la lista de productos disponibles")
    public void validarListaProductos() {
        inventoryPage.productosDisponibles();
    }
}
