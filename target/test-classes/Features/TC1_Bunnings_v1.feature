Feature: feature to test Add to Basket  functionality

  @BunningsAddToCart
  Scenario: Guest user add increase decrease products in cart
    Given browser is open
    And user is on the Bunning landing page
    And user searches "drill" and adds to cart
    Then cart is updated and has total 1 item
    And user adds an item
    Then cart count is updated to 2
    And user remove an item
    Then cart count is updated to 1
    And user exits

  Scenario: Guest user empty the cart
    Given browser is open
    And user is on the Bunning landing page
    And user searches "drill" and adds to cart
    Then cart is updated and has total 1 item
    And user remove an item
    Then the cart is empty
    And user exits

  Scenario Outline: logged user add products to cart
    Given user has logged in with <username> and <password>
    And user searches "hammer" and adds to cart
    Then cart is updated and has total 1 item
    And user logs out
    And user exits

    Examples: 
      | username               | password     |
      | enterYourUsername | enterYourPassword |
      
  Scenario Outline: cart persist when user logs back
    Given user has logged in with <username> and <password>
    And user click on the cart icon
    Then cart count is updated to 1
    And user remove an item
    Then the cart is empty
    Then user logs out
    And user exits

    Examples: 
      | username               | password     |
      | enterYourUsername | enterYourPassword |
      
      
      
      
