# xml to sql
### Parse XML and insert in SQL database with Java 8


###-----com.briancrodriguez.etl package
###-DataInserter.java
###-Main.java
###-Strings.java
###-XMLReader.java
###-XMLToSQL.java

###-----com.briancrodriguez.etl.utilis package
###-DBConnection.java
###-Tabletruncater.java

###  Notes:
Main class instantiates the table truncater class; purges table – see TableTruncater comments.
Main class instantiates XMLReader and DataInserter classes – see comments.
XMLReader loads XML file, produces list of maps of type string, string of nodes that exist in the XMLToSQL Map and returns said list - see comments.
DataInserter receives list of maps of type string, string and inserts into sqlite3 database - see comments.
String class contains strings – more magic strings to be added as TODO.
XMLToSQLMap is the hashmap object for identifying element nodes to insert into database.
DBConnection class uses singleton design pattern for a database connection object.

