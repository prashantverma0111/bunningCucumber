Feature: feature to test Add to Basket  functionality

  #Scenario Outline: Validate Add product to Cart
    #Given browser is open
    #And user is on the Bunning landing page
    #When user searches a product
    #Then user is navigated to search results
    #And user click on the product and add it to cart on product page
    #Then product is added to the cart "<confirmation>"
    #And user exits
#
    #Examples: 
      #| confirmation   |
      #| "Total 1 item" |
      #
      #
  #Scenario Outline: Validate increase of items in cart
    #Given browser is open
    #And user is on the Bunning landing page
    #When user searches a product
    #Then user is navigated to search results
    #And user click on the product and add it to cart on product page
    #When user add more items in the cart
    #Then product is added to the cart "<confirmation>"
    #And user exits
   #Examples: 
      #| confirmation   |
      #| "Total 2 item" |    	
#
      #
   #Scenario Outline: Validate removal of an item from cart
    #Given browser is open
    #And user is on the Bunning landing page
    #When user searches a product
    #Then user is navigated to search results
    #And user click on the product and add it to cart on product page
    #When user add more items in the cart
    #Then product is added to the cart "<confirmation>"
    #And user remove an item from cart
    #Then cart count is updated to 1
    #And user exits
   #Examples: 
      #| confirmation   |
      #| "Total 2 item" | 
      
      
       #@BunningsAddToCart     
      #Scenario: logged user add products to cart
      #	Given user has logged in
      #	And user searches an item and adds to cart
      #	Then cart has total 1 item and value "49.98"
      #	And user adds an item 
      #	Then cart has total 2 item and value "99.96"
      #	And user remove an item
      #	Then cart has total 1 item and value "49.98"
      #	And user logs out
      
      
      
      
      
      
      
      
      
      
      
  #Scenario: Guest user add increase decrease products in cart
      #	Given browser is open
      #And user is on the Bunning landing page
      #	And user searches "drill" and adds to cart
      #	Then cart is updated and has total 1 item
      #	And user adds an item 
      #	Then cart count is updated to 2
      #	And user remove an item
      #	Then cart count is updated to 1
      	
      	
   #Scenario: Guest user empty the cart
      #	Given browser is open
        #And user is on the Bunning landing page
       #	And user searches "drill" and adds to cart
      #	Then cart is updated and has total 1 item
      #	And user remove an item
      #	Then the cart is empty
      
      
         	
      	
@BunningsAddToCart     
      Scenario Outline: logged user add products to cart
      	Given user has logged in with <username> and <password>
      	And user searches "hammer" and adds to cart
      	Then cart is updated and has total 1 item
      	And user logs out
      	
      Examples:
      	|	username	|	password	|
      	|	bunnings0111@gmail.com	|	@!Bunnings23	|
      
       
      	
      	
       