@aiOla
Feature: main

  Scenario: Shop Validations
  Given a Web Page is opened with the following URL "https://www.saucedemo.com/inventory.html"
  When Set Login Username to "standard_user"
  When Set Login Password to "secret_sauce"
  When Click Login
  When Populate StoreItems
  Then Validate Shop Item with Title "Sauce Labs Backpack" to Have Description that Contains "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection."
  And Validate Shop Item with Title "Sauce Labs Bolt T-Shirt" to Have Description that Contains "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt."
  And Validate Shop Item with Title "Sauce Labs Onesie" to Have Description that Contains "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel."
  And Validate Shop Item with Title "Sauce Labs Bike Light" to Have Description that Contains "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included."
  And Validate Shop Item with Title "Sauce Labs Fleece Jacket" to Have Description that Contains "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office."
  And Validate Shop Item with Title "Test.allTheThings() T-Shirt (Red)" to Have Description that Contains "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton."
  And Validate Shop Item count "6"