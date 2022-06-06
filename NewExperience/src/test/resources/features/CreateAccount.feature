@Regresion
Feature: Create user account
    User login functionality for the new experience site

Background: Enter the website of the new experience and access the registration form
Given I get into the new experience web site
And I select SignIn option

@SuccesfulCase
Scenario: Como cliente de la tienda, requiero crear una cuenta en la pagina para realizar la compra de un producto 

When Digito mi correo eléctronico
And hago clic en el botón Create an acount
And Completo la información solicitada por el sistema  
Then El sistema crea mi cuenta de usuario  
And I close my session on the website 

@AlternateCase
Scenario: As a store owner, I want to make sure that customers cannot register without completing the required fields on the registration form.

When I type my email
And I click on the create account button 
And I click on the register button 
Then The system does not allow to create the user account