@all
@authorization
Feature: Authorization

  @authorization1
  Scenario Outline: Authorization
    When Open Home page


    Examples:
    | supplier | file                       |
    | ТехКом   | /groupData/groupNumber.txt |