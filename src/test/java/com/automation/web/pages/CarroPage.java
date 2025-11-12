package com.automation.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CarroPage {

    private WebDriver driver;

    @FindBy(className = "cart_item")
    private  List<WebElement> itemsCarro;

    @FindBy(id = "checkout")
    private WebElement btnCheckout;


    public CarroPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int obtenerNumeroDeProductosEnCarro() {
        return itemsCarro.size();
    }
    public void clickCheckout() {
        btnCheckout.click();
    }
    public boolean paginaCarroCargada() {
        return driver.getCurrentUrl().contains("cart.html");
    }
}
