# Access Database Table Structure

## Database Name
VUE_Exhibition.accdb

## Table Name
Participants

## Table Fields

| Field Name | Data Type | Field Size | Description |
|---|---|---|---|
| RegistrationID | Short Text | 50 | Unique registration identifier |
| StudentName | Short Text | 100 | Full name of the student |
| Faculty | Short Text | 100 | Faculty name (e.g., Science and Technology) |
| ProjectTitle | Short Text | 150 | Title of exhibition project |
| ContactNumber | Short Text | 30 | Student contact phone number |
| EmailAddress | Short Text | 100 | Student email address |

## Database Location
C:\VUE_Exhibition\VUE_Exhibition.accdb

## JDBC Connection String
```
jdbc:ucanaccess://C:/VUE_Exhibition/VUE_Exhibition.accdb
```

## SQL Table Creation
See `database/participants.sql` for the SQL CREATE TABLE statement.

## Java Database Setup
See `src/DatabaseSetup.java` for automated database and table creation code.

## Screenshot
The Access database table design view shows all field definitions as specified in Question 5(b)(ii).
