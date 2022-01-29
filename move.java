/**
 * Reg-No : 2018331081
 * Writer : Md Ataullha Saim
 * Date   : Sat 29 Jan 2022 08:00:40 PM +06
 */

import java.io.*;
import java.nio.file.*;

public class move {

    // for move a directory/file we need source directory name or address args[0]  and target directory name or address args[1]

    /**
     * compile using : javac move.java
     * run using : java move args[0] args[1]
     * @param args
     * @throws IOException
     */

    public static void main(String[] args) throws IOException { // throws IOException

        if(args.length!=2){
            System.out.println("java move [source_directory/source_file] [target_directory/target_file]");
            return ;
        }

        // source path
        Path source = Paths.get(args[0]);
        // target path
        Path target = Paths.get(args[1]);

        try {
            // for move 
            Files.move(source, target.resolve(source.getFileName()), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            System.out.println("Failed To Move!");
            return;
        }
        System.out.println("Successfully moved "+source+" to "+target);
        
        // cut a directory
        // cut a file
    }
    
}
// case have to think
/**
 * source given, target given
 * source given, target not given
 * source not given, target given
 * source not given, target not given
 */