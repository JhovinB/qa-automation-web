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

public class CerrarSesionStep {
    private WebDriver driver;
    private LoginPage loginPage;
    private InventarioPage inventarioPage;
    private CarroPage carroPage;
    private CheckoutPage checkoutPage;
    private FinalizarCompraPage finalizarCompraPage;
    private CerrarSesionPage cerrarSesionPage;

    @Given("que el usuario completo la compra")
    public void que_el_usuario_completo_la_compra() {
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

        finalizarCompraPage = new FinalizarCompraPage(driver);
        finalizarCompraPage.hacerClickEnFinish();

        new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @When("abre el menu lateral y selecciona Logout")
    public void abre_el_menu_lateral_y_selecciona_logout() {
        cerrarSesionPage = new CerrarSesionPage(driver);
        cerrarSesionPage.abrirMenuLateral();
        cerrarSesionPage.seleccionarLogout();
    }

    @Then("debe ser redirigido nuevamente a la pagina de login")
    public void debe_ser_redirigido_nuevamente_a_la_pagina_de_login() {
        AssertionsForClassTypes.assertThat(cerrarSesionPage.estaEnPaginaLogin())
                .as("Verifica redirección a la página de login")
                .isTrue();
    }
}
