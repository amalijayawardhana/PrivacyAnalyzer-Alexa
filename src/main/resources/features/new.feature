Feature: login
  This feature for login page

  @UAT @All @LoginPage
  Scenario Outline: User send the message and verify the response
    Given user go to Amazon login page
    And user login with valid credentials
    Then click on keep me signin
    And   click on login button
    Then  user should logged in successfully
    Then  user input the "<testId>" and "<sheetName>"
    And   user analyze the response message
    And   user store response message



    Examples:
      | testId | sheetName |
      | 1      | Business & Finance |
      | 2      | Business & Finance |
      | 3      | Business & Finance |
      | 4      | Business & Finance |
      | 5      | Business & Finance |
      | 6      | Business & Finance |
      | 7      | Business & Finance |
      | 8      | Business & Finance |
      | 9      | Business & Finance |
      | 10     | Business & Finance |
      | 11     | Business & Finance |
      | 12     | Business & Finance |
      | 13     | Business & Finance |
      | 14     | Business & Finance |
      | 15     | Business & Finance |
      | 16     | Business & Finance |
      | 17     | Business & Finance |
      | 18     | Business & Finance |
      | 19     | Business & Finance |
      | 20     | Business & Finance |
      | 21     | Business & Finance |
      | 22     | Business & Finance |
      | 23     | Business & Finance |
      | 24     | Business & Finance |
      | 25     | Business & Finance |
      | 26     | Business & Finance |
      | 27     | Business & Finance |
      | 28     | Business & Finance |
      | 29     | Business & Finance |
      | 30     | Business & Finance |
      | 31     | Business & Finance |
      | 32     | Business & Finance |
      | 33     | Business & Finance |
      | 34     | Business & Finance |
      | 35     | Business & Finance |
      | 36     | Business & Finance |
      | 37     | Business & Finance |
      | 38     | Business & Finance |
      | 39     | Business & Finance |
      | 40     | Business & Finance |
      | 41     | Business & Finance |
      | 42     | Business & Finance |
      | 43     | Business & Finance |
      | 44     | Business & Finance |
      | 45     | Business & Finance |
      | 46     | Business & Finance |
      | 47     | Business & Finance |
      | 48     | Business & Finance |
      | 49     | Business & Finance |
      | 50     | Business & Finance |
      | 51     | Business & Finance |
      | 52     | Business & Finance |
      | 53     | Business & Finance |
      | 54     | Business & Finance |
      | 55     | Business & Finance |
      | 56     | Business & Finance |
      | 57     | Business & Finance |
      | 58     | Business & Finance |
      | 59     | Business & Finance |
      | 60     | Business & Finance |
      | 61     | Business & Finance |
      | 62     | Business & Finance |
      | 63     | Business & Finance |
      | 64     | Business & Finance |
      | 65     | Business & Finance |
      | 66     | Business & Finance |
      | 67     | Business & Finance |
      | 68     | Business & Finance |
      | 69     | Business & Finance |
      | 70     | Business & Finance |
      | 71     | Business & Finance |
      | 72     | Business & Finance |
      | 73     | Business & Finance |
      | 74     | Business & Finance |
      | 75     | Business & Finance |
      | 76     | Business & Finance |
      | 77     | Business & Finance |
      | 78     | Business & Finance |
      | 79     | Business & Finance |
      | 80     | Business & Finance |
      | 81     | Business & Finance |
      | 82     | Business & Finance |
      | 83     | Business & Finance |
      | 84     | Business & Finance |
      | 85     | Business & Finance |
      | 86     | Business & Finance |
      | 87     | Business & Finance |
      | 88     | Business & Finance |
      | 89     | Business & Finance |
      | 90     | Business & Finance |
      | 91     | Business & Finance |
      | 92     | Business & Finance |
      | 93     | Business & Finance |
      | 94     | Business & Finance |
      | 95     | Business & Finance |
      | 96     | Business & Finance |
      | 97     | Business & Finance |
      | 98     | Business & Finance |
      | 99     | Business & Finance |
      | 100     | Business & Finance |
