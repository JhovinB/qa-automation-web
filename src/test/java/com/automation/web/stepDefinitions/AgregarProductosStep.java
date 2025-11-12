package com.automation.web.stepDefinitions;

import com.automation.web.hooks.Hooks;
import com.automation.web.pages.CarroPage;
import com.automation.web.pages.InventarioPage;
import com.automation.web.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AgregarProductosStep {
    private WebDriver driver;
    private InventarioPage inventarioPage;
    private CarroPage carroPage;
    private LoginPage loginPage;

    @Given("que el usuario ha iniciado sesion correctamente")
    public void que_el_usuario_ha_iniciado_sesion_correctamente() {
        driver = Hooks.getDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        loginPage.ingresarCredenciales("standard_user", "secret_sauce");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        inventarioPage = new InventarioPage(driver);
    }

    @When("agrega dos productos al carrito")
    public void agrega_dos_productos_al_carrito() {
        inventarioPage.agregarProductosCarro();
    }

    @Then("el icono del carrito debe mostrar el número {string}")
    public void el_ícono_del_carrito_debe_mostrar_el_numero(String numero) {
        String actualNumero = inventarioPage.obtenerNumeroCarroCompras();
        assertThat(actualNumero).isEqualTo(numero);
    }

    @Then("los productos seleccionados deben mostrarse correctamente al abrir el carrito")
    public void los_productos_seleccionados_deben_mostrarse_correctamente_al_abrir_el_carrito() {
        inventarioPage.clickCarroCompras();
        carroPage = new CarroPage(driver);
        assertThat(carroPage.obtenerNumeroDeProductosEnCarro()).isEqualTo(2);
    }
}
