Feature: login
  This feature for login page '

  @UAT @All @LoginPage
  Scenario: User send the message and verify the response
    Given user go to Amazon login page
    When user type username as username
    When user type password for password
    And   click on login button
#    When  user type password for password
#    And   click on login button
    Then  user should logged in successfully
    Then  user select the action as test in the dropdown
    Then  user input the message
    Then  user input the message2
    And   user verify response message
