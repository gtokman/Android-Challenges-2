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
