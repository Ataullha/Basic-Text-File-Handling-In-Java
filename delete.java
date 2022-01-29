/**
 * Reg-No : 2018331081
 * Writer : Md Ataullha Saim
 * Date   : Sat 29 Jan 2022 09:05:21 PM +06
 */

import java.io.*;
import java.nio.file.*;
import javax.swing.text.html.HTMLDocument.RunElement; // what's it is doing here ? No Idea..

public class delete {

    // for delete a directory/file we need source directory name or address args[0] 
    // arg[1] file name is optional :)

    /**
     * compile using : javac delete.java
     * run using : java delete args[0] args[1]
     * @param args
     */


    // this function recursively delete all files and folder from a directory 

    public static void deleteDirectory(File file){

        
        for(File subfile : file.listFiles()){ // list of files

            if(subfile.isDirectory()){
                try{
                deleteDirectory(subfile); // recursion :)
                } catch(Exception e) {
                    System.out.println("Failed To Delete All File in The Directory!");
                    //e.printStackTrace();
                    return;
                }
            }
            // a if a here destory my 30 mins :'(
                subfile.delete();
        }

    }

    public static void main(String[] args) {

        String curDirectory="";

        if(args.length==1){
            curDirectory = System.getProperty("user.dir");
            } else if(args.length==2) {
            curDirectory = args[0];
            args[0] = args[1]; 
            } else  {
                System.out.println("java delete [target_directory/target_file]");
                return;
            }

            File file = new File(curDirectory+"/"+args[0]);

            if(file.isDirectory()){
                deleteDirectory(file);
                // last delete the empty directory 
                file.delete();
                System.out.println(args[0]+" Directory Deleted Successfully!");
            } else if(file.exists()) {
                // delete the file only 
                    file.delete();
                    System.out.println(args[0]+" File Deleted Successfully!");
            } else {
                System.out.println("Directory or File Not Exists");
            }




        // delete directory
            // delete directory at a targeted location
            
            // delete directory at current location
        // delete file
            // delete file at  at a targeted location
            // delete directory at current location
    }
    
}
