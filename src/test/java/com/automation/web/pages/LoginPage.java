package com.automation.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement txtUsername;

    @FindBy(id = "password")
    private WebElement txtPassword;

    @FindBy(id = "login-button")
    private WebElement btnLogin;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void abrirPaginaLogin() {
        driver.get("https://www.saucedemo.com/");
    }

    public void ingresarCredenciales(String usuario, String contrasena) {
        txtUsername.sendKeys(usuario);
        txtPassword.sendKeys(contrasena);
        btnLogin.click();
    }

    public boolean paginaLoginCargada() {
        return txtUsername.isDisplayed() && btnLogin.isDisplayed();
    }
}
