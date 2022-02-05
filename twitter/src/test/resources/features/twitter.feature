@twitter
Feature: In order to verify twitter website

  @Login @Regression
  Scenario Outline: verify happy path login functionality on twitter
    When I navigate to twitter webiste homepage
    Then I click on signin on homepage
    Then I will enter "<mobile>" on login page
    Then I will click on next button on login
    Then I will enter password "<userpassword>" on login page
    Then I will click on login button on login page
    Then I verify home page heading on user home page

    Examples:
      | mobile     |  userpassword |
      | 9826425010 |  Pallu$123    |


  @Smoke @Regression @upload_old
  Scenario Outline: Upload profile picture -> Update bio, Location,Website.
    When I navigate to twitter webiste homepage
    Then I click on signin on homepage
    Then I will enter "<mobile>" on login page
    Then I will click on next button on login
    Then I will enter password "<userpassword>" on login page
    Then I will click on login button on login page
    Then I verify home page heading on user home page
    Then I click on profile link on user home page
    Then I verify profile home page open for "<username>"
    Then I click on Edit profile on profile page
    Then I upload new profile pic on profile page
    Then I click on Apply button on profile page
    Then I wait to Edit Profile on profile page
    Then I will update bio "<bio>" on profile page
    Then I will update location "<location>" on profile page
    Then I will update website "<website>" on profile page
    Then I will click on save button on profile page
    Then I verify details "<bio>", "<location>", "<website>" updated are stored correctly on profile page

    Examples:
      | mobile     | username  | userpassword | bio                | location | website     |
      | 9826425010 | PalashJ71 | Pallu$123    | selenium test user | indore   | twitter.com |

  @Smoke @fetchFeed
  Scenario Outline: Upload profile picture -> Update bio, Location,Website.
    When I navigate to twitter webiste homepage
    Then I click on signin on homepage
    Then I will enter "<mobile>" on login page
    Then I will click on next button on login
    Then I will enter password "<userpassword>" on login page
    Then I will click on login button on login page
    Then I verify home page heading on user home page
    Then I search for account "<account>" on user home page
    Then I click on latest feed on user home page
    Then I print latest feed from home page


    Examples:
      | mobile     |  userpassword | account       |
      | 9826425010 |  Pallu$123    | @timesofindia |
