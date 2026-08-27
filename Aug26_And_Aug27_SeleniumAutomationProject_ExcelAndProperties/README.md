# Selenium Automation Project - Excel and Properties

Built directly from mam's task PDF (project structure, class names, and Excel
layout matched exactly): a properties-driven config, an Excel-driven data
reader, one Business Logic (BL) class per page, and a single TestExecution
runner that walks through Positive + Negative scenarios for Login, Register
and Add User.

- `src/main/java/com/automation/ConfigReader.java` - reads `data.properties`
- `src/main/java/com/automation/ExcelReader.java` - reads `TestData.xlsx`
- `src/main/java/com/automation/LoginBL.java`, `RegisterBL.java`, `AddUserBL.java` - element actions for each page
- `src/test/java/com/automation/TestExecution.java` - runs Positive then Negative for each page

## Setup
- `data.properties` (project root) - browsername + page URLs
- `src/test/resources/TestData.xlsx` - Login / Register / AddUser sheets, each with a Positive and a Negative row

## Notes (fixed from the reference PDF to actually run against the live site)
- Excel cells are read with `DataFormatter` instead of `getStringCellValue()` - the reference code crashes on numeric-looking cells (mobile numbers, "123456" as a password)
- The state dropdown on Add User has no `id`, so it's located by `//form[1]//select` instead of `By.id("state")`
- Login/Register submit buttons use a tested xpath instead of a bare `//button`, since Add User has more than one button on the page
