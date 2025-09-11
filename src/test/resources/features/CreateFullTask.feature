Feature: Create a full New Task
  Scenario Outline: User add new full task
    Given Environment SetUp
    Given Open new task
    Given Enter Task Details "<taskName>" and "<taskDesc>"
    Given Select Task Tags
    Given Enter Start Date "<startMonth>" and "<startDay>"
    Given Enter End Date "<endMonth>" and "<endDay>"
    Given Select Task Priority
    When Save Task
    Then Task added Successfully

    Examples:
    Examples:
      | taskName            | taskDesc        | startMonth  | startDay  | endMonth  | endDay  |
      | Cucumber Full Task  | Task Details    | Nov         | 20        | Jan       | 10      |