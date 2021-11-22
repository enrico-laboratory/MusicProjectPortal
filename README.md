# Music Project Portal

## Modules

### Json to Google Spreadsheet

Module that upload specific json files to Google Spreadsheet.
The json files contain master tables related to personal music project planning.
The master tables are parsed and divided in sub-tables containing records for specific projects.
A Google spreadsheet is created for each project and the sub-tables are uploaded to the relevant sheets in the spreadsheet

* mapping json files to java objects via Gson (com.enricoruggieri.json_to_gspreadsheet.TableObject)
* converting java objects to list of lists, Google Spreadsheet format (com.enricoruggieri.json_to_gspreadsheet.SheetCreator)
* creating spreadsheets and related sheets (com.enricoruggieri.json_to_gspreadsheet.SpreadsheetCreator, com.enricoruggieri.json_to_gspreadsheet.SheetCreator)
* uploading of the list of lists to created spreadsheet parsed per project (com.enricoruggieri.json_to_gspreadsheet.SpreadsheetCreator, com.enricoruggieri.json_to_gspreadsheet.SheetCreator)
* formatting spreadsheet (com.enricoruggieri.json_to_gspreadsheet.SpreadsheetCreator, com.enricoruggieri.json_to_gspreadsheet.SheetCreator)
