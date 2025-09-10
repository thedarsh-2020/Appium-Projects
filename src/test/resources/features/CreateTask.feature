Feature: Create New Task
  Scenario: The user can add new task
    Given Click Add New Task
    Given Enter TaskName
    Given Enter TaskDesc
    When Click Save
    Then Task added Successfully