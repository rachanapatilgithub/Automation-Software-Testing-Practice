# Excel Sheet + Properties File - Automation Framework

Same Login/Register/Add User automation as [Aug26_And_Aug27_ExcelSheetProperty](../Aug26_And_Aug27_ExcelSheetProperty),
restructured with reusable classes instead of repeating the same setup code in every test:

- `src/main/java/com/automation/ConfigReader.java` - loads `data.properties`
- `src/main/java/com/automation/DriverFactory.java` - starts the browser
- `src/main/java/com/automation/ExcelUtils.java` - reads `Test Data.xlsx`
- `src/test/java/com/automation/LoginTest.java`, `RegisterTest.java`, `AddUserTest.java` -
  the test scenarios, using the classes above

## Setup
- `data.properties` (project root) - browser + page URLs
- `src/test/resources/Test Data.xlsx` - Login / Register / AddUser sheets
