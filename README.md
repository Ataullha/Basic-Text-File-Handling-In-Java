# COMMAND LINE FILE EXPLORER

show all files in a  directory, create a file/directory, delete a file/directory, rename a file/directory, copy a file/directory, move a file/directory using java command line arguments and basic terminal commands <br>

* Ref:
https://www.codejava.net/file-io-tutorials

# Summary

 **[COMMAND LINE FILE EXPLORER]**

* **create** :    java fe create [target]
	or java fe create [target] [file_name]

* **delete** :    java fe delete [target] [file_name]
	or java fe delete [file_name]

* **explore** :    java fe explore[target_directory_address]
	or java fe explore [directory_name]

* **copy**   :    java fe copy [source_file_name] [target_directoy]
	or java fe copy [source_directory] [target_directory]

* **move**    :   java fe move [source directory] [target_directory]
	or java fe move [source_file_name] [target_directory]

* **rename**  :   java fe rename [target_directory/target_file_name] [renamed_name]


# How To Use

Intialize or Start
===

*  Download <pre>fe.java <b>N.B. all the others files here are for better doucmentations and understandings</b></pre> or copy everything from fe.java and save it as fe.java

*  Compile it using <pre>javac fe.java</pre>

![javac_fe](https://user-images.githubusercontent.com/53054762/151712210-ac48fb50-04ed-4300-a6c5-f917e715c9e1.png)


 Run File Explorer
 ===
 
 create 
 --
 ✔️ create direcotry or file using java command line args , if we provide a args[1] string like **file_name.extension** then it will create a file with and if we provide a args[1] string without extension then it will create a **directory/folder** 
 
 * File :<pre>java fe create [file_name.file_extension]
 
 ![fe_create_file](https://user-images.githubusercontent.com/53054762/151711319-c2ca34cb-365c-4db2-96da-171a139bdfad.png)
 
 * Directory :<pre>java fe create [directory_name]
 
![fe_create_dir](https://user-images.githubusercontent.com/53054762/151711472-eb7c3807-e0b1-49ae-83f4-bd5a3dbdb71e.png)

 <br>
 
 explore
 --
  ✔️ explore directory or file using java command line args, if we provide nothing it will just explore the current directory and if we provide a valid directory then it will explore that directory *level by level*
  
  * Explore Current Directory : <pre> java fe explore </pre>
  
![fe_explore_cmd](https://user-images.githubusercontent.com/53054762/151712233-a4d76bca-48de-4615-ae1a-999d068aa542.png)
 
![fe_explore_doing](https://user-images.githubusercontent.com/53054762/151712262-2d9cdd80-264a-4385-9044-844950ce316a.png)


 * Explore Target Directory :  <pre> java fe explore [target_direcotry] </pre>
 
![java_fe_explore_target](https://user-images.githubusercontent.com/53054762/151712281-aff6a3fe-c9d6-47c4-83a9-469f39fcecb9.png)

delete
--
 ✔️ delete directory or file using java command line args, if we provide a args[1] string with the **directory name/file_name** or **target_directory_with_file_name** or two args[1] args[2] strings like **target_directory** and **file_name** we can delete the directory or file from our system ⚠️
 
 * Delete a Directory/File : <pre> java fe delete [target_directory/target_file]<br>or java fe delete [target_address] [target_directory/target_file]</pre>
 
![java_fe_delete_dir](https://user-images.githubusercontent.com/53054762/151712566-d47403a2-eb1c-4241-8bdd-76305048bb59.png)

copy
--

✔️ copy a dierctory or file using java command line args to another directory, if we provide two args string args[1] as **source_file or source_directory** and args[2] target_directory we can do that

* Copy a File/Directoy to another Directory : <pre> java fe copy [source_file/source_directory] [target_directory]
![directory_copied_to directory](https://user-images.githubusercontent.com/53054762/151712908-7a85b3bd-81ab-46c5-9aa4-5aa815a8c48f.png)
![file_copied_in directory](https://user-images.githubusercontent.com/53054762/151712913-67a8b6ca-8e54-473f-b605-f6338dc290c2.png)

move
--

✔️ move a directory or file using java command line args to another directory, if we provide two args args string args[1] as **source_file or source_directory** and args[2] target_directory we can do that (almost copy!)

 * Move a File/Directory to another Directory : <pre> java fe move [source_file/source_directory] [target_directory]
 
![file_moved_directory_fe](https://user-images.githubusercontent.com/53054762/151713095-96852330-8399-4f68-ac22-8e010b02d344.png)
![directory_moved_to_directory_fe](https://user-images.githubusercontent.com/53054762/151713099-ac48899b-3da8-4821-92ea-7a3a34a043da.png)

rename
--
 ✔️ rename a directory or file using java command line args, if we provide two args string args[1] as **source_file or source_directory** and args[2] as new name for renaming that file or directory we can do that
 
 *  Rename a File/Directory : <pre> java fe rename [source_file/source_directory] [new_name]</pre>
 
 ![file_renamed_fe](https://user-images.githubusercontent.com/53054762/151713477-21e7ae7f-0541-4bee-a6b7-d4630e8cc181.png)
![rename_java_fe_directory](https://user-images.githubusercontent.com/53054762/151713480-41db21e7-9be4-4e97-8547-aa32a48bc91e.png)

 
 
help
--
 ✔️ for any kind of explorer help
 
 * Help : <pre> java fe help </pre>

![fe_h](https://user-images.githubusercontent.com/53054762/151713493-2e60511e-f50d-4e6b-8def-49261ad479b7.png)
![java_fe_help](https://user-images.githubusercontent.com/53054762/151713496-d7c1b8a8-f88e-47f2-a6c2-a20c644a9491.png)
