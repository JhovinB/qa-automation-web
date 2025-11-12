@Pruebas
Feature: Completar información del cliente en el checkout

  @CompletarInformacion
  Scenario: Completar información del cliente correctamente
  Given que el usuario está en el formulario de checkout
  When completa los campos obligatorios
  And hacer click en Continuar
  Then debe visualizar el resumen del pedido "Checkout: Overview"