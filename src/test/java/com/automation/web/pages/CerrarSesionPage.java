package com.automation.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CerrarSesionPage {

    private WebDriver driver;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement btnMenu;

    @FindBy(id = "logout_sidebar_link")
    private WebElement opcionCerrarSesion;


    public CerrarSesionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void abrirMenuLateral() {
        btnMenu.click();
    }

    public void seleccionarLogout() {
        opcionCerrarSesion.click();
    }

    public boolean estaEnPaginaLogin() {
        return driver.getCurrentUrl().equals("https://www.saucedemo.com/");
    }
}
