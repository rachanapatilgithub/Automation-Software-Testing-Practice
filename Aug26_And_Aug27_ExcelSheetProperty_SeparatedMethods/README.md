# Excel Sheet + Properties File - Separated Methods

Same Login/Register/Add User automation as [Aug26_And_Aug27_ExcelSheetProperty](../Aug26_And_Aug27_ExcelSheetProperty),
just organized so nothing is repeated across the three tests: one shared
`Utility` class plus a short `main()` in each test that calls a named method.

- `src/main/java/com/automation/Utility.java` - `getProperties()`, `getDriver()`, `getSheet()`
- `src/test/java/com/automation/LoginTest.java` - `main()` calls `login()`
- `src/test/java/com/automation/RegisterTest.java` - `main()` calls `register()`
- `src/test/java/com/automation/AddUserTest.java` - `main()` calls `login()` then `addUsers()`

## Setup
- `data.properties` (project root) - browser + page URLs
- `src/test/resources/Test Data.xlsx` - Login / Register / AddUser sheets
