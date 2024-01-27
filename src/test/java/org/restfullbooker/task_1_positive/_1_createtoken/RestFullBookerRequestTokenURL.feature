Feature: Token Post Request

  Scenario Outline: Post Request to make a Token
   Given Get Payload from "<url>"
   Then Verify response message "<msg>"
    Examples:
      | url  | msg |
      | /auth | 200 |