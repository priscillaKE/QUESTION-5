# QN5-VUE

This project contains solutions for Question Five.

## Requirement Mapping
- **(a)(i)-(iii)**: `src/PerfectNumberChecker.java`
- **(b)(i)**: `src/ExhibitionRegistrationApp.java`
- **(b)(ii)**: `src/DatabaseSetup.java` and `database/participants.sql`
- **(b)(iii)-(iv)**: `src/ExhibitionRegistrationApp.java`

## Files
- `src/PerfectNumberChecker.java` - Perfect number checker with exception-handled input validation.
- `src/ExhibitionRegistrationApp.java` - Swing form with Register/Clear/Exit and insert logic.
- `src/DatabaseSetup.java` - Creates `VUE_Exhibition.accdb` and `Participants` table.
- `database/participants.sql` - SQL version for manual table creation.

## Part (a): Perfect Number
Compile and run:

```powershell
cd src
javac PerfectNumberChecker.java
java PerfectNumberChecker
```

## Part (b): Exhibition Registration
Compile:

```powershell
cd src
javac ExhibitionRegistrationApp.java DatabaseSetup.java
```

Run database setup first:

```powershell
java DatabaseSetup
```

Then run the GUI:

```powershell
java ExhibitionRegistrationApp
```

## Access DB Setup
1. Ensure folder `C:\VUE_Exhibition` exists.
2. Run `DatabaseSetup` to create `VUE_Exhibition.accdb` and the `Participants` table automatically.
3. Alternative: create table manually using SQL in `database/participants.sql`.

## UCanAccess JDBC
JDBC URL used in code:

```text
jdbc:ucanaccess://C:/VUE_Exhibition/VUE_Exhibition.accdb
```

Add UCanAccess JAR files to your project libraries before running DB inserts.
