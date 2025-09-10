Feature: Create New Task Using Table
  Scenario Outline: The user can add new task
    Given Click Add New Task
    Given Enter "<TaskName>" and "<TaskDesc>"
    When Click Save
    Then Task added Successfully

    Examples:
      | TaskName        | TaskDesc        |
      | Cucumber Task 1 | Task 1 Details  |
      | Cucumber Task 2 | Task 2 Details  |