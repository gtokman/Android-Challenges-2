## SQLite 

* Local file system to save data in the flash memory storage
* Files located in the sandbox (protection from other apps)
* directory = /data/data/package
* Saves time and memory compared to local file system

## Define DB Schema

* Create class to define the schema
* Create psfc for Table name
* Nested class for Table column names
* defines the layout of the table

## Create the Database

* Check to see if the DB exists
* If not, create the table and init
* If it does add or remove 

## .GetWritableDatabase()

* Open data/data/package and create new DB
* Call onCreate() in DB helper
* Check version number and call onUpgrade if it is

## Writing to Database

* Writes and updates to database are handled by **ContentValues**
* Content values are a key value store designed to to store data SQLite can store
* Insert content values **insert(String, String, ContentValues)**
* First arg = Table to insert into, Last is the data to insert, second = nullColumnHack 

## Updating Database

* **.Update(String, ContentValues, String, String[])**
* Pass in the TableName, values, where clause, where clause values String[]
* Specifies which rows to update 

## Reading from Database

* Reading is handled by SQLiteDatabase.query(...)
* Most important arguments
* Table to query, columns you want values for and order to receive, where clause, where value




