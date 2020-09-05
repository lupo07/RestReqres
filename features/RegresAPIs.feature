Feature: Resgres APIs this is for practice RestAssured

  Scenario Outline: Login Resgres
    Given I have the email <email>
    And I have the password <password>
    And I have the keyHeader <keyHeader>
    And I have the headerValue <headerValue>
    When I set the endpoint <endpoint>
    Then I can verify the status code <status>

    Examples: 
      | email              | password   | keyHeader    | headerValue      | endpoint | status |
      | eve.holt@reqres.in | cityslicka | Content-Type | application/json | Login    |    200 |

  Scenario Outline: Create resource Resgres
    Given I have the name <name>
    And I have the job <job>
    And I have the keyHeader <keyHeader>
    And I have the headerValue <headerValue>
    When I set the endpoint <endpoint>
    Then I can verify the status <status> to create resource

    Examples: 
      | name               | job        | keyHeader    | headerValue      | endpoint | status |
      | eve.holt@reqres.in | cityslicka | Content-Type | application/json | Users    |    201 |

  Scenario Outline: Search a single User Resgres
    Given I have the name <name>
    And I have the lastname <lastname>
    And I have the id <id>
    When I set the endpoint <endpoint>
    Then I can verify for a single user the status code <status>

    Examples: 
      | name    | lastname | id | endpoint | status |
      | Michael | Lawson   |  7 | Users    |    200 |
