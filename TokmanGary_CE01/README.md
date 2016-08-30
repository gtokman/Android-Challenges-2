## Saving to local file system

* File 
    * represents a file or directory pathname
    
* Streams 
    * Like water pipes connecting city homes to water tanks
    * two types of streams 
        * Input and Output
    * Steams define methods for data reading and writing (regard data source or dest)
    
* Stream workflow
   1. Create a stream
   2. Perform read or write operation
   3. Close the stream

* Input 
    * read data
    * **InputStream** read binary data
    * returns bytes read or -1 for no data (end of file)
    
* Output 
    * write data
    * **OutputStream** write binary data
    
* Object serialization
    * persist objects
    * Class implements the **Serializable** interface
    * ObjectOutputStream / ObjectInputStream
    
* Example Serializing data

    ```
    // Create file
    File fileName = new File("file.txt")
    
    // Write
    FileOutputStream fo = new FileOutputStream(fileName)
    
    // Wrap in ObjectOutput
    ObjectOutputStream oo = = new ObjectOutputStream(fo)
    
    // Write object
    oo.writeObject(myObj)
    
    // Close steams
    fo.close()
    oo.close()
    
    // Catch Exception
    
    ```
    
* Example deserialize data

    ```
    File fileName = new File("file.txt")
    
    // Read 
    FileInputStream fi = new FileInputStream(fileName)
    
    // Wrap in ObjectInput
    ObjectInputStream oi = new ObjectInputStream(fi)
    
    // Read data
    Object object = (Object) oi.readObject()
    
    // Check
    
    // Close 
    fi.close()
    oi.close()
    
    // Catch Exception
    
    ```