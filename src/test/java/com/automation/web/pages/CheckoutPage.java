package com.automation.web.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    private WebDriver driver;

    @FindBy(className = "title")
    private WebElement tituloCheckoutInformacion;

    @FindBy(className = "title")
    private WebElement tituloCheckoutGeneral;

    @FindBy(id = "first-name")
    private WebElement txtNombre;

    @FindBy(id = "last-name")
    private WebElement txtaApellido;

    @FindBy(id = "postal-code")
    private WebElement txtCodigoPostal;

    @FindBy(id = "continue")
    private WebElement btnContinuar;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean paginaCheckoutInformacion() {
        return driver.getCurrentUrl().contains("checkout-step-one.html");
    }
    public String obtenerTituloCheckoutInformacion() {
        return tituloCheckoutInformacion.getText();
    }
    public void completarInformacionCliente(String nombres, String apellidos, String codigoPostal) {
        txtNombre.sendKeys(nombres);
        txtaApellido.sendKeys(apellidos);
        txtCodigoPostal.sendKeys(codigoPostal);
    }

    public void hacerClickContinuar() {
        btnContinuar.click();
    }
    public String obtenerTituloCheckoutDescripcionGeneral() {
        return tituloCheckoutGeneral.getText();
    }
    public boolean paginaCheckoutDescripcionGeneral() {
        return driver.getCurrentUrl().contains("checkout-step-two.html");
    }
}
