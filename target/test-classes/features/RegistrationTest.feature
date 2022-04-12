Feature: Amazon create account page should have verification on all the fields

  Background: Redirect to Create Account page from Sign-in Page
    Given I am on the Sign-in page
    When I click on "createAccountSubmit" button on the Sign-in page
    Then I should be on the Create Account page

  Scenario Outline: All of the fields should display an error when not populated on form submission
    When I enter "test@test.com" into all the fields on the page
    And I clear the "<field>" field on the Create Account page
    And I click on "continue" button on the Create Account page
    Then the "<error>" message on the Create Account page for each "<field>" should be visible

    Examples:
      | field             | error                                   |
      | ap_customer_name  | Enter your name                         |
      | ap_email          | Enter your email or mobile phone number |
      | ap_password       | Minimum 6 characters required           |
      | ap_password_check | Type your password again                |