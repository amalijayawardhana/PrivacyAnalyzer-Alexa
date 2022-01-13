Feature: login
  This feature for login page

  @UAT @All @LoginPage
 Scenario Outline: User send the message and verify the response
    Given user go to Amazon login page
    When user type "<username>" and "<password>"
#    When user type username
#    When user type username as "<username>"
#    When user type password as "<password>"
#    When user type password
    And   click on login button
    Then  user should logged in successfully
#    Then  user select the action as test in the dropdown
    Then  user input the "<message1>" and "<message2>" and "<message3>"
    And   user verify response message

 Examples:
 |username|password|message1|message2|message3|
#|testalicealexa@gmail.com|test@SKILLS|hi      |good morning|Thank you|
|testalicealexa@gmail.com|test@SKILLS|Alexa, open my business      |Alexa, start my business|close my business|


