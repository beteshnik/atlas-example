@all
@authorization
Feature: Authorization

  @authorization1
  Scenario Outline: Authorization
    When Log in


    Examples:
      | login | password |
      | test  | test     |