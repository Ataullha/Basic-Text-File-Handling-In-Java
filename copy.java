/**
 * Reg-No : 2018331081
 * Writer : Md Ataullha Saim
 * Date   : Sat 29 Jan 2022 09:47:06 PM +06
 */

import java.io.*;
import java.nio.file.*;

import javax.imageio.plugins.tiff.ExifTIFFTagSet;

// for better understanding visit 
// https://stackoverflow.com/a/26214647/13870040

public class copy {

    // for copy a directory/file we need [source_directory_with_file_name/file_name] args[0] and [target_directory_with_file_name/file_name] arg[1]

    /**
     * compile using : javac copy.java
     * run using : java copy args[0] args[1] 
     * @param args
     */

    public static void copyFolder(File source, File destination){
        
        if(source.isDirectory()){

            if(!destination.exists()){
                destination.mkdirs();
            }
            String files[] = source.list();

            for(String file : files){ // list of file(files) 
                File srcFile = new File(source, file); // parent, child
                File destFile = new File(destination, file); // parent, child

                copyFolder(srcFile, destFile);
            }
        } else{

            InputStream in =  null;
            OutputStream out = null;

            try {
                in = new FileInputStream(source); // input stream 
                out = new FileOutputStream(destination); // output stream

                byte[] buffer = new byte[1024]; // byte type for read and write,  1024 (just a conventional value i think )
                int length;
                while((length = in.read(buffer))>0){  // if read is successful 
                    out.write(buffer,0,length); // for a better look :) go here https://docs.oracle.com/javase/7/docs/api/java/io/OutputStream.html
                }
            } catch (Exception e) {
                try {
                    in.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                try {
                    out.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

        }

    }

    public static void copyFile(String src, String dest){
            Path sourceDirectory = Paths.get(src);
            Path targetDirectory = Paths.get(dest);
            try{
            Files.copy(sourceDirectory, targetDirectory, StandardCopyOption.REPLACE_EXISTING);
            }catch(Exception e){
                System.out.println("Not Successful!");
                System.exit(0);
            }
            System.out.println("Successful!");
    }

    public static void main(String[] args) {
        
        if(args.length!=2){
            System.out.println("java copy [source_directory/source_file] [target_directory/target_file]");
            return;
        }

        String source = args[0];
        String[] name_of_the_file = args[0].split("/");
        String fname = name_of_the_file[name_of_the_file.length-1]; 

        File srcDir = new File(source);
        
        String destination = args[1]; 
        File destDir = new File(destination+"/"+fname); // file name

        if(args[0].contains(".")){
            copyFile(args[0],args[1]+"/"+fname); // file name
            System.out.println("File Copied From "+args[0]+" to "+args[1]);
        } else {
        copyFolder(srcDir, destDir);
        //System.out.println();
        System.out.println("Directory Copied From "+args[0]+" to "+args[1]);
        }

    }
}