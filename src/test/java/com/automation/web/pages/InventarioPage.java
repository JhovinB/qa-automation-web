package com.automation.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InventarioPage {

    private WebDriver driver;

    @FindBy(className = "inventory_item")
    private List<WebElement> productos;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menu;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement primerProducto;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement segundoProducto;

    @FindBy(className = "shopping_cart_badge")
    private WebElement carroComprasIcono;

    @FindBy(className = "shopping_cart_link")
    private WebElement carroComprasLink;


    public InventarioPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean paginaDeInventarioCargada() {
        return driver.getCurrentUrl().contains("inventory.html") && menu.isDisplayed();
    }

    public boolean productosDisponibles() {
        return productos != null && !productos.isEmpty() && productos.get(0).isDisplayed();
    }

    public void agregarProductosCarro() {
        primerProducto.click();
       segundoProducto.click();
    }

    public String obtenerNumeroCarroCompras() {
        return carroComprasIcono.getText();
    }

    public void clickCarroCompras() {
      carroComprasLink.click();
    }
}
