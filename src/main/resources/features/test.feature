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
|testalicealexa@gmail.com|test@SKILLS|hi      |Search my email|Thank you|
|testalicealexa@gmail.com|test@SKILLS|Alexa, open my business      |Alexa, Search my email|close my business|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open charleston facts|Alexa, Search my email|Close charleston facts|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open liberty mountain|Search my email|Close liberty mountain|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open b. y. l. u. campaign|Search my email|Close b. y. l. u. campaign|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open skymee feeder|Search my email|Close skymee feeder|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open digital two h. d.|Search my email|Close digital two h. d.|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open guitar facts|Search my email|Close guitar facts|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open picture pandey podcast|Search my email|Close picture pandey podcast|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open work quotes|send a test email|Close work quotes|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open k. country|send a test email|Close k. country|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open guinness world record facts|send a test email|Close guinness world record facts|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open ark d. b.|send a test email|Close ark d. b.|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open missing letter|send a test email|Close missing letter|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open mix ninety four point one|send a test email|Close mix ninety four point one|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open beaus brewery|send a test email|Close beaus brewery|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open g. r. e.|send a test email|Close g. r. e.|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open jai mata dee|send a test email|Close jai mata dee|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open my house radio|send a test email|Close my house radio|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open my backpack|send a test email|Close my backpack|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open girls gone wod|send a test email|Close girls gone wod|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open the ducks latest tweet|send a test email|Close the ducks latest tweet|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open marvel facts unofficial|send a test email|Close marvel facts unofficial|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open cuisine facts|send a test email|Close cuisine facts|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open rover buggy|send a test email|Close rover buggy|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open renewing spirit|send a test email|Close renewing spirit|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open the daily|send a test email|Close the daily|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open a. f. l. exchange|send a test email|Close a. f. l. exchange|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open smite assistant|send a test email|Close smite assistant|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open schrodinger's cat|send a test email|Close schrodinger's cat|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open qantas|send a test email|Close qantas|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open baton rouge guide|send a test email|Close baton rouge guide|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open design pattern flash cards|send a test email|Close design pattern flash cards|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open square the number quiz|send a test email|Close square the number quiz|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open radio cloak dagger|send a test email|Close radio cloak dagger|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open what did mahatma say|send a test email|Close what did mahatma say|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open billings guide|send a test email|Close billings guide|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open the san diego union tribune|send a test email|Close the san diego union tribune|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open houston radio platinum|send a test email|Close houston radio platinum|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open egg alarm|send a test email|Close egg alarm|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open the young escape's latest tweet|send a test email|Close the young escape's latest tweet|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open ninety six point one s. o. x.|send a test email|Close ninety six point one s. o. x.|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open resistor codes|send a test email|Close resistor codes|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open tech showcase|send a test email|Close tech showcase|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open computer science facts|send a test email|Close computer science facts|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open amusing facts|send a test email|Close amusing facts|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open copyright facts|send a test email|Close copyright facts|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open seaside sounds|send a test email|Close seaside sounds|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open grammar teacher|send a test email|Close grammar teacher|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open baby sleep sounds|send a test email|Close baby sleep sounds|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open mauritius national anthem|send a test email|Close mauritius national anthem|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open abdul kalam facts|send a test email|Close abdul kalam facts|
# |testalicealexa@gmail.com|test@SKILLS|Alexa, open c. b. s. sports rajson.jsondio harrisburg|send a test email|Close c. b. s. sports radio harrisburg|


