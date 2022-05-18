Feature: login
  This feature for login page

  @UAT @All @LoginPage
 Scenario Outline: User send the message and verify the response
    Given user go to Amazon login page
    When user type "<username>" and "<password>"
#    When user type username
#    When user type username as "<username>"
#    When user type password
    Then click on keep me signin
    And   click on login button
#    When user type password as "<password>"
#    And   click on login button
    Then  user should logged in successfully
#    Then  user select the action as test in the dropdown
    Then  user input the "<message1>" and "<message2>" and "<message3>"
    And   user verify response message
#      |testalicealexa@gmail.com|test@SKILLS|hi      |Send a test email|Thank you|
#      |testalicealexa@gmail.com|test@SKILLS|Alexa, open my business      |Alexa, Send a test email|close my business|



    Examples:
 |username|password|message1|message2|message3|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open crypto money|can't make a call|Alexa,  close crypto money|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open my jokes|can't make a call on iphone|Alexa,  close my jokes|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open my class|can't make a call on iphone|Alexa,  close my class|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open chicken nugget|can't make a call on iphone|Alexa,  close chicken nugget|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open squirrel squirrel|can't make a call on iphone|Alexa,  close squirrel squirrel|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open word memory two|can't make a call on iphone|Alexa,  close word memory two|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open pure land|can't make a call on iphone|Alexa,  close pure land|