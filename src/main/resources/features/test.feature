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
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open the walking challenge|My email is testalicealexa@gmail.com|Alexa,  close the walking challenge|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open bills fan|My email is testalicealexa@gmail.com|Alexa,  close bills fan|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open indian cricket team|My email is testalicealexa@gmail.com|Alexa,  close indian cricket team|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open cricket genie|My email is testalicealexa@gmail.com|Alexa,  close cricket genie|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open nfl|My email is testalicealexa@gmail.com|Alexa,  close nfl|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open schalke facts|My email is testalicealexa@gmail.com|Alexa,  close schalke facts|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open a. t. p. rankings|My email is testalicealexa@gmail.com|Alexa,  close a. t. p. rankings|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open broncos fan|My email is testalicealexa@gmail.com|Alexa,  close broncos fan|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open a. f. l. fantasy podcast|My email is testalicealexa@gmail.com|Alexa,  close a. f. l. fantasy podcast|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open race base|My email is testalicealexa@gmail.com|Alexa,  close race base|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open visual basic glossary|My email is testalicealexa@gmail.com|Alexa,  close visual basic glossary|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open drone facts|My email is testalicealexa@gmail.com|Alexa,  close drone facts|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open square roots|My email is testalicealexa@gmail.com|Alexa,  close square roots|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open look above|My email is testalicealexa@gmail.com|Alexa,  close look above|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open nitrox calculator|My email is testalicealexa@gmail.com|Alexa,  close nitrox calculator|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open isaac newton facts|My email is testalicealexa@gmail.com|Alexa,  close isaac newton facts|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open plato quotes|My email is testalicealexa@gmail.com|Alexa,  close plato quotes|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open washington state facts|My email is testalicealexa@gmail.com|Alexa,  close washington state facts|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open surprising facts|My email is testalicealexa@gmail.com|Alexa,  close surprising facts|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open bitcoin mining facts|My email is testalicealexa@gmail.com|Alexa,  close bitcoin mining facts|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open used car dealer|My email is testalicealexa@gmail.com|Alexa,  close used car dealer|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open current bitcoin|My email is testalicealexa@gmail.com|Alexa,  close current bitcoin|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open my advisor|My email is testalicealexa@gmail.com|Alexa,  close my advisor|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open fool|My email is testalicealexa@gmail.com|Alexa,  close fool|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open crypto money|My email is testalicealexa@gmail.com|Alexa,  close crypto money|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open tesla facts|My email is testalicealexa@gmail.com|Alexa,  close tesla facts|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open scrum facts|My email is testalicealexa@gmail.com|Alexa,  close scrum facts|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open edmonton family law|My email is testalicealexa@gmail.com|Alexa,  close edmonton family law|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open skolix website|My email is testalicealexa@gmail.com|Alexa,  close skolix website|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open national tariff|My email is testalicealexa@gmail.com|Alexa,  close national tariff|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open flavor forecast|My email is testalicealexa@gmail.com|Alexa,  close flavor forecast|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open taco fancy|My email is testalicealexa@gmail.com|Alexa,  close taco fancy|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open dallas ramen|My email is testalicealexa@gmail.com|Alexa,  close dallas ramen|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open famous dishes|My email is testalicealexa@gmail.com|Alexa,  close famous dishes|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open recipe finder|My email is testalicealexa@gmail.com|Alexa,  close recipe finder|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open dinner time|My email is testalicealexa@gmail.com|Alexa,  close dinner time|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open cooking lobster|My email is testalicealexa@gmail.com|Alexa,  close cooking lobster|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open pizza types|My email is testalicealexa@gmail.com|Alexa,  close pizza types|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open sully's steamers|My email is testalicealexa@gmail.com|Alexa,  close sully's steamers|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open steak cooking times|My email is testalicealexa@gmail.com|Alexa,  close steak cooking times|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open dwight trivia|My email is testalicealexa@gmail.com|Alexa,  close dwight trivia|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open professional baseball facts|My email is testalicealexa@gmail.com|Alexa,  close professional baseball facts|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open master mind|My email is testalicealexa@gmail.com|Alexa,  close master mind|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open reindeer games|My email is testalicealexa@gmail.com|Alexa,  close reindeer games|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open seinfeld quotes|My email is testalicealexa@gmail.com|Alexa,  close seinfeld quotes|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open popcorn quiz|My email is testalicealexa@gmail.com|Alexa,  close popcorn quiz|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open ferrari facts|My email is testalicealexa@gmail.com|Alexa,  close ferrari facts|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open body twister|My email is testalicealexa@gmail.com|Alexa,  close body twister|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open weird science facts|My email is testalicealexa@gmail.com|Alexa,  close weird science facts|
 |testalicealexa@gmail.com|test@SKILLS|Alexa, open loot goblin|My email is testalicealexa@gmail.com|Alexa,  close loot goblin|
