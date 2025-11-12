@Pruebas
Feature: Finalizar compra en la tienda

  @FinalizarCompra
  Scenario: Finalizar compra correctamente
    Given que el usuario está en el resumen de compra
    When hace clic en Finish
    Then debe mostrarse el mensaje de confirmación "Thank you for your order!"