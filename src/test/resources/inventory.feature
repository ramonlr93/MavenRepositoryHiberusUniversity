@inventory
Feature: Validate Inventory test suite

  Background: Navigate to the home page
    Given the user is on the home page

  @testcase03
  Scenario Outline: validate inventory list size
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    When the user clicks the login button
    Then the user see the inventory list with "<items>" size list
    Examples:
      | username      | password     | items |
      | standard_user | secret_sauce | 6     |

  @testcase04
  Scenario Outline: validate exist "<item>" product in inventory list
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    When the user clicks the login button
    Then the user see the "<item>" in the inventory list
    Examples:
      | username      | password     | item                    |
      | standard_user | secret_sauce | Sauce Labs Bolt T-Shirt |

  @testcase05
  Scenario Outline: Add a single item in the shopping cart
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    When the user adds a "<item>" by clicking Add To Cart
    And the user clicks on the shopping cart
    Then there should be 1 items in the shopping cart
    Examples:
      | username      | password     | item                |
      | standard_user | secret_sauce | Sauce Labs Backpack |

  @testcase06
    @smoke
  Scenario Outline: Delete an item in the shopping cart
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    And the user adds a "<item>" by clicking Add To Cart
    When the user remove a "<item>" by clicking Remove
    And the user clicks on the shopping cart
    Then there should be 0 items in the shopping cart
    Examples:
      | username      | password     | item                    |
      | standard_user | secret_sauce | Sauce Labs Bolt T-Shirt |

  @testcase07
    @smoke
  Scenario Outline: Place multiple items in the shopping cart
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    When the user selects
      | Sauce Labs Backpack     |
      | Sauce Labs Bolt T-Shirt |
      | Sauce Labs Onesie       |
    And the user clicks on the shopping cart
    Then there should be 3 items in the shopping cart
    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  @testcase08
    @sort
  Scenario Outline: sort inventory by alphabetical desc order
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    When the user clicks select "<optionSort>"
    Then the user see the list by alphabetical desc order
    Examples:
      | username      | password     | optionSort |
      | standard_user | secret_sauce | za         |

  @testcase09
    @sort
  Scenario Outline: sort inventory by price desc order
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    When the user clicks select "<optionSort>"
    Then the user see the list by price desc order
    Examples:
      | username      | password     | optionSort |
      | standard_user | secret_sauce | hilo       |

  @testcase10
    @sort
  Scenario Outline: sort inventory by price ascend order
    And the user provides the username "<username>"
    And the user provides the password "<password>"
    And the user clicks the login button
    When the user clicks select "<optionSort>"
    Then the user see the list by price ascend order
    Examples:
      | username      | password     | optionSort |
      | standard_user | secret_sauce | lohi       |