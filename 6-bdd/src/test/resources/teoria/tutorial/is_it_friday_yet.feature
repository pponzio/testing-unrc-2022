Feature: Is it Friday yet?
  Everybody wants to know when it's Friday

  Scenario: Sunday isn't Friday
    Given Today is Sunday
    When I ask the system whether it's Friday
    Then The answer should be false 