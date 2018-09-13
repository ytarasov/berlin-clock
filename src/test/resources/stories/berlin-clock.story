Story: The Berlin Clock

Meta:
@scope interview

Narrative:
    As a clock enthusiast
    I want to tell the time using the Berlin Clock
    So that I can increase the number of ways that I can read the time

Scenario: Midnight
When the time is 00:00:00
Then the clock should look like
Y
OOOO
OOOO
OOOOOOOOOOO
OOOO

Scenario: Middle of the afternoon
When the time is 13:17:01
Then the clock should look like
O
RROO
RRRO
YYROOOOOOOO
YYOO

Scenario: Just before midnight
When the time is 23:59:59
Then the clock should look like
O
RRRR
RRRO
YYRYYRYYRYY
YYYY

Scenario: Midnight
When the time is 24:00:00
Then the clock should look like
Y
RRRR
RRRR
OOOOOOOOOOO
OOOO

Scenario: End of working day
When the time is 19:32:25
Then the clock should look like
O
RRRO
RRRR
YYRYYROOOOO
YYOO

Scenario: Wrong time format
When the time is 22-17-21
Then the clock should look like
Error has been occurred during Berlin clock time converting. Reason: Wrong format for input time 22-17-21

Scenario: Wrong hour value
When the time is 36:45:11
Then the clock should look like
Error has been occurred during Berlin clock time converting. Reason: Invalid hour value outside the allowed range 36

Scenario: Wrong minute value
When the time is 11:78:32
Then the clock should look like
Error has been occurred during Berlin clock time converting. Reason: Invalid minute value outside the allowed range 78

Scenario: Wrong second value
When the time is 12:23:95
Then the clock should look like
Error has been occurred during Berlin clock time converting. Reason: Invalid second value outside the allowed range 95