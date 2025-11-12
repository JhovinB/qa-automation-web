@Pruebas
Feature: Realizar checkout en SauceDemo

  @Checkout
  Scenario: Realizar checkout exitosamente
    Given que el usuario tiene productos en el carrito
    When navega al carrito y hace clic en Checkout
    Then debe mostrarse el formulario de información del cliente "Checkout: Your Information"