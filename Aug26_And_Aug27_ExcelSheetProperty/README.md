# Excel Sheet + Properties File - Classwork

Practice from the Aug 26-27 class: reading test data from an Excel sheet (Apache POI)
and browser/URL config from a properties file, then driving Login, Register and Add User
on the JavaByKiran practice site.

Each class is self-contained with its own `main()`, following the same steps taught in class:
- `ExcelReadTest.java`, `ExcelSheetTest1.java`, `PropertieFileReadTest.java` - the step-by-step
  building blocks (reading Excel, then adding the properties file)
- `LoginTest.java`, `RegisterTest.java`, `AddUserTest.java` - the final tasks, looping over
  multiple rows of Excel data for each page

## Setup
- `data.properties` (project root) - browser + page URLs
- `src/test/resources/Test Data.xlsx` - Login / Register / AddUser sheets
