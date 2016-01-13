# xml to sql
##### Parse XML and insert into SQL database with Java 8

######---com.briancrodriguez.etl package
-Main.java <br />
-Strings.java <br />
-XMLReader.java <br />
-XMLToSQLMap.java <br />
-DataInserter.java 

######---com.briancrodriguez.etl.utilis package
-DBConnection.java <br />
-Tabletruncater.java <br />

#####  Notes:
Main class instantiates and executes the table truncater class; purges table – see TableTruncater comments.<br />
Main class then instantiates and executes XMLReader and DataInserter classes – see comments.<br />
XMLReader loads XML file, produces list of maps of type string, string of nodes that exist in the XMLToSQL Map and returns said list - see comments.<br />
DataInserter receives list of maps of type string, string and inserts into sqlite3 database - see comments.<br />
String class contains strings – more magic strings to be added as TODO.<br />
XMLToSQLMap is the hashmap object for identifying element nodes to insert into database.<br />
DBConnection class uses singleton design pattern for a single database connection object.<br />

