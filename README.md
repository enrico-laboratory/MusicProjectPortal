#Music Project Portal

## Modules

### Json to Google Spreadsheet

Module that upload specific json files to Google Spreadsheet.
The json files contain master tables related to personal music project planning.
The master tables are parsed and divided in sub-tables containing records for specific projects.
A Google spreadsheet is created for each project and the sub-tables are uploaded to the relevant sheets in the spreadsheet

* mapping json files to java objects via Gson (TableObject)
* converting java objects to list of lists, Google Spreadsheet format (SheetCreator)
* creating spreadsheets and related sheets (SpreadsheetCreator, SheetCreator)
* uploading of the list of lists to created spreadsheet parsed per project (SpreadsheetCreator, SheetCreator)
* formatting spreadsheet (SpreadsheetCreator, SheetCreator)