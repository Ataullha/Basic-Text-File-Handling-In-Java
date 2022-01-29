/**
 * Reg-No : 2018331081
 * Writer : Md Ataullha Saim
 * Date   : Sat 29 Jan 2022 07:54:04 PM +06
 */

import java.io.*;
import java.nio.file.*;

public class rename {


    // for rename a directory/file we only need source directory name or address args[0] and renamed name as args[1]

    /**
     * compile using : javac rename.java
     * run using : java rename args[0] args[1]
     * @param args
     * @throws IOException
     */

    public static void main(String[] args) throws IOException { // throws IOException

        if(args.length!=2){
            System.out.println("java rename [source_directory/source_file] [renamed_name]");
            return ;
        }

        // the source file directory
        Path source = Paths.get(args[0]);
        //Path target = Paths.get(args[0]);
       
        try {
            // from nio - for move dir/files
            Files.move(source,source.resolveSibling(args[1]), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            System.out.println("Failed To Rename!");
            return;
        }
        System.out.println("Successfully renamed "+source+" to "+args[1]);



        // rename a directory
        // rename a file
        
    }
    
}
// case have to think
/**
 * source given, target_name given
 * source given, target_name not given
 * source not given, target_name given
 * source not given, target_name not given
 */