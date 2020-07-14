Feature: First feature

  Background: Simple background
    Given system print 'Background was run' line to console

  @first @smoke
  Scenario: First scenario
    Given system print 'First scenario' line to console
    When first actions are performed
    Then verify FIRST equals FIRST

  @second @smoke @long @ignoreHook
  Scenario: Second scenario
    Given system print 'Second scenario' line to console
    When second actions are performed
    Then verify SECOND equals SECOND

  @third @smoke @long
  Scenario: Third scenario
    Given system print 'Third scenario' line to console
    When third actions are performed
    Then verify THIRD equals THIRD

  @List
  Scenario: List scenario
    Given system print 'List scenario' line to console
    Then verify list size is 3:
      | one   |
      | two   |
      | three |

  @ListOfLists
  Scenario: List of lists scenario
    Given system print 'List of lists scenario' line to console
    Then verify list of list size is 3:
      | one   | two  |
      | three | four |
      | five  | six  |

  @Map
  Scenario: Map scenario
    Given system print 'Map scenario' line to console
    Then verify map size is 2:
      | name | Vasya |
      | age  | 25    |

  @ListOfMaps
  Scenario: List of maps scenario
    Given system print 'List of maps scenario' line to console
    Then verify list of map size is 2:
      | name  | age |
      | Vasya | 25  |
      | Anya  | 22  |

  @User
  Scenario: User scenario
    Given system print 'User scenario' line to console
    Then verify user name is Vasya:
      | name  | age |
      | Vasya | 25  |

  @ListOfUsers
  Scenario: List of users scenario
    Given system print 'List of users scenario' line to console
    Then verify user list has size 2:
      | name  | age |
      | Vasya | 25  |
      | Anya  | 22  |


  @UseExamples
  Scenario Outline: Use examples scenario
    Given system print 'Use examples scenario' line to console
    Then verify user name is <userName>:
      | name       | age       |
      | <userName> | <userAge> |

    Examples:
      | userName | userAge |
      | Vasya    | 25      |
      | Anya     | 22      |
