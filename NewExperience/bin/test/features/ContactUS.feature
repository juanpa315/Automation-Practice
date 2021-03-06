Feature: Page contact functionality

Background: Enter the website of the new experience and access the contact us page

Given I access the new experience page
And I login on the system with email and password
And I access the contact us page

@SuccesfulCaseContacUs @ContactUs
Scenario: As user, I need to make a successful request on the contact us page

When I complete all the required input
And I click on the send buttom 
Then The system displays a successful request message 
And I can return to the home page and logout on the website


@AlternateCaseContacUs @ContactUs
Scenario: As an admin, I need clients not to be able to make requests without completing the mandatory information in the contact us form.

When I click on the send buttom
Then The system displays a failed message alert.
