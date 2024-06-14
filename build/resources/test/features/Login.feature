@allLoginPage
Feature: Test login functionality 


Background: Enter the website of the new experience and access the login form
Given I access the new experience website
And I click SignIn option

@loginSuccessful
Scenario: Login successful on the New Experience website
When I enter my email
And I enter my Password
And I click on the SignIn button
Then The website load my user account 
And I can log out 


@loginFailed
Scenario: login Failed on the New Experience website
When I enter a invalid email
And I enter a password
And I click on the signin button
Then The system does not allow to login successfully