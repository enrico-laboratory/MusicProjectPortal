# Music Projects Portal

## Description

The Music Projects Portal web application aims to facilitate sharing information about music project planning. It serves the planning team and the musician involved in the project as a central place to facilitate communication and share planning details. 

## Modules

### Database Engine

* Database Engine main package control the flows between Notion Client requests and a database (presently Google Spreadsheet)
* Wrapper for [Seratch Notion Client](https://github.com/seratch/notion-sdk-jvm)
* Wrapper for Google Drive and Spreadsheet Client (temporary)
* Json mapper (obsolete, to refactor, serving a previous python client wrapper)

Working on:
* Mapping and connection to SQL database
* serve the databases via a web application, using Spring framework

## Why?
I have been a professional music director for many years and I have never found an effective way
to share projects information with the planning team and the musicians involved. Now that my career is moving towards 
software engineering and music becoming my hobby, I told myself "Why don't you make your own?!". 

The projects I organise and then perform as conductor have a limited complexity not worthy of more elaborated and expensive software, but still requiring 
something more flexible and more "stylish" than a spreadsheet attached to an email.

I have few master project databases and I want to share only the necessary information (specific queries) with the appropriate groups. I do my planning in Notion, which allows sharing
database information in a nice and accessible format, but sharing the queries means sharing the entire database which might contain private or not project related info. 
At the same time I do not want to create and share separate databases for every project and keep them updated, a lot of unnecessary extra work to manually copy and paste and maintain updates.

## What?
I have started this journey writing [this python app](https://github.com/enrico-laboratory/Notion_database_parser). I am now refactoring this very raw app, here in Java. 

For now, it comprises the module Database Engine. It gets the projects related databases via the Notion API, converts them into Java objects, parses them and uploads them in a database.

Temporary the database is a Google Spreadsheet accessed via API. I know, I did not want to share spreadsheets but it is good for a temporary solution and allowed me to work with different APIs and learn a lot from them.


