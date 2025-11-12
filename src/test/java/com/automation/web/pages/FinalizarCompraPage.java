package com.automation.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinalizarCompraPage {

    private WebDriver driver;

    @FindBy(id = "finish")
    private WebElement btnFinish;

    @FindBy(css = ".title")
    private WebElement tituloPagina;

    @FindBy(css = ".complete-header")
    private WebElement mensajeConfirmacion;


    public FinalizarCompraPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void hacerClickEnFinish() {
        btnFinish.click();
    }
    public String obtenerMensajeConfirmacion() {
        return mensajeConfirmacion.getText();
    }

    public String obtenerTituloPagina() {
        return tituloPagina.getText();
    }
    public boolean paginaFinalCompra() {
        return driver.getCurrentUrl().contains("/checkout-complete.html");
    }
}
