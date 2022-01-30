/**
 * Reg-No : 2018331081
 * Writer : Md Ataullha Saim
 * Date   : Sat 30 Jan 2022 10:15:49 PM +06
 */

import java.io.*;
import java.nio.file.*;
import javax.imageio.plugins.tiff.ExifTIFFTagSet; // no idea
import javax.swing.plaf.basic.BasicRootPaneUI; // no idea - color purpose maybe
import javax.swing.text.html.HTMLDocument.RunElement; // no idea

public class fe {

// ANSI COLOR CODE for differnatiating  between directories and files in explore tree
    public static final String ANSI_RESET = "\u001B[0m"; // colourless
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";

// directory-tree-printing-function-start

static void DirectoryTree(File[] fls,int level) {
    for(File f : fls){
            for(int i=0;i<level;i++){
                 System.out.print("|  ");
}
    System.out.print("|");
    if(f.isFile()){
        System.out.println("  |-"+f.getName()); 
    } else if(f.isDirectory()) {
        System.out.println("  |-"+ANSI_BLUE+f.getName()+ANSI_RESET);
        DirectoryTree(f.listFiles(), level+1);
    }
}
}

// directory-tree-printing-function-end

// recurcively-delete-function-start

    public static void deleteDirectory(File file){

        for(File subfile : file.listFiles()){

            if(subfile.isDirectory()){
                try{
                deleteDirectory(subfile);
                } catch(Exception e) {
                    System.out.println("Failed To Delete All File in The Directory!");
                    return;
                }
            }
                subfile.delete();
        }

    }
// recurcively-delete-function-end

///

public static void copyFolder(File source, File destination){
 
// start-copy-folder-function

    if(source.isDirectory()){

        if(!destination.exists()){
            destination.mkdirs();
        }
        String files[] = source.list();

        for(String file : files){  
            File srcFile = new File(source, file); 
            File destFile = new File(destination, file);

            copyFolder(srcFile, destFile);
        }
    } else{

        InputStream in =  null;
        OutputStream out = null;

        try {
            in = new FileInputStream(source);
            out = new FileOutputStream(destination);

            byte[] buffer = new byte[1024];
            int length;
            while((length = in.read(buffer))>0){ 
                out.write(buffer,0,length);
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
// end-copy-folder-function

// start-copy-file-function

public static void copyFile(String src, String dest){
        Path sourceDirectory = Paths.get(src);
        Path targetDirectory = Paths.get(dest);
        try{
        Files.copy(sourceDirectory, targetDirectory, StandardCopyOption.REPLACE_EXISTING);
        }catch(Exception e){
            System.out.println("Not Successful!");
            System.exit(0); // exit the program
        }
        System.out.println("Successful!");
}

// end-copy-file-function

/// main-function-start
    public static void main(String[] args) {

        if(args[0].equals("create")) {

// create-start

String curDirectory;
if(args.length==0 || args.length>2){
    System.out.println("java fe create [target_directory/file] [targer_directory/file_name]\ntype\tjava fe help\t for more\n");
}
if(args.length==2){
curDirectory = System.getProperty("user.dir");
} else {
curDirectory = args[1];
args[1] = args[2];

try{
Paths.get(curDirectory+"/"+args[1]); 
} catch(Exception e){
    System.out.println("Path Not Valid");
} 
}

File file = new File(curDirectory+"/"+args[1]);

if(args[0].contains(".")){
    try{
    if(file.createNewFile()){
        System.out.println("New File Created at "+curDirectory+"/"+args[1]);
    } else {
        System.out.println("Failed To Create The File at "+curDirectory+"/"+args[1]);
    }
}catch(Exception e){
        System.out.println("Failed to Create New File!");
        return;
}
} else {
    try {
        if(file.mkdir()){
            System.out.println("New Directory Created at "+curDirectory+"/"+args[1]);
        } else {
            System.out.println("Failed To Create The Directory at "+curDirectory+"/"+args[1]);
        }
    } catch (Exception e) {
        System.out.println("Failed to Create New Directory!");
        return;
    }
}

// create-end
        }else if(args[0].equals("explore")) {
// explore-start

String current = "";

if(args.length==1){
    current = System.getProperty("user.dir");
}else if(args.length==2){
    current = args[1]+"";
}else {
    System.out.println("java fe explore [target_directory]\ntype\tjava fe help\t for more\n");
    return ;
}
File file = new File(current);


System.out.println(ANSI_PURPLE+file.getAbsolutePath()+ANSI_RESET);
System.out.println("|-"+ANSI_PURPLE+file.getName()+ANSI_RESET);

if(file.isDirectory() && file.exists() && !(file.isFile())){
    File fls[] = file.listFiles();
    DirectoryTree(fls,0);
} else {
    System.out.println("Enter a Valid Directory Name For Better Exploring!");
}

//explore-end
        }else if(args[0].equals("delete")) {
//delete-start

String curDirectory="";

if(args.length==2){
    curDirectory = System.getProperty("user.dir");
    } else if(args.length==3) {
    curDirectory = args[1];
    args[1] = args[2]; 
    } else  {
        System.out.println("java fe delete [target_directory/target_file]\ntype\tjava fe help\t for more\n");
        return;
    }

    File file = new File(curDirectory+"/"+args[1]);

    if(file.isDirectory()){
        deleteDirectory(file);
        // last delete the empty directory 
        file.delete();
        System.out.println(args[1]+" Directory Deleted Successfully!");
    } else if(file.exists()) {
        // delete the file only 
            file.delete();
            System.out.println(args[1]+" File Deleted Successfully!");
    } else {
        System.out.println("Directory or File Not Exists");
    }

//delete-end
        } else if(args[0].equals("copy")) {
//copy-start

if(args.length!=3){
    System.out.println("java fe copy [source_directory/source_file] [target_directory/target_file]\ntype\tjava fe help\t for more\n");
    return;
}

String source = args[1];
String[] name_of_the_file = args[1].split("/");
String fname = name_of_the_file[name_of_the_file.length-1]; 

File srcDir = new File(source);

String destination = args[2]; 
File destDir = new File(destination+"/"+fname); // file name

if(args[1].contains(".")){
    copyFile(args[1],args[2]+"/"+fname); // file name
    System.out.println("File Copied From "+args[1]+" to "+args[2]);
} else {
copyFolder(srcDir, destDir);
System.out.println("Directory Copied From "+args[1]+" to "+args[2]);
}

//copy-end            
        } else if(args[0].equals("move")) {
// move-start 
    if(args.length!=3){
    System.out.println("java fe move [source_directory/source_file] [target_directory/target_file]\ntype\tjava fe help\t for more\n");
    return ;
    }

    Path source = Paths.get(args[1]);
    Path target = Paths.get(args[2]);

    try {
    Files.move(source, target.resolve(source.getFileName()), StandardCopyOption.REPLACE_EXISTING);
    } catch (Exception e) {
    System.out.println("Failed To Move!");
    return;
    }
    System.out.println("Successfully moved "+source+" to "+target);
// move-end 
    } else if(args[0].equals("rename")){
// rename-start
            if(args.length!=3){
                System.out.println("java fe rename [source_directory/source_file] [renamed_name]\ntype\tjava fe help\t for more\n");
                return ;
            }

            Path source = Paths.get(args[1]);

            try {
                Files.move(source,source.resolveSibling(args[2]), StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception e) {
                System.out.println("Failed To Rename!");
                return;
            }
            System.out.println("Successfully renamed "+source+" to "+args[2]);
// rename-end
        } else if(args[0].equals("help")) {
// help-start
System.out.println("[COMMAND LINE FILE EXPLORER]\n\ncreate :    java fe create [target]\n\tor java fe create [target] [file_name]\n\ndelete :    java fe delete [target] [file_name]\n\tor java fe delete [file_name]\n\nexplore:    java fe explore[target_directory_address]\n\tor java fe explore [directory_name]\n\ncopy   :    java fe copy [source_file_name] [target_directoy]\n\tor java fe copy [source_directory] [target_directory]\n\nmove    :   java fe move [source directory] [target_directory]\n\tor java fe move [source_file_name] [target_directory]\n\nrename  :   java fe rename [target_directory/target_file_name] [renamed_name]\n\ncreated by 2018331065, 2018331081, 2018331106 as 5th Term OS Assignment\n;?  :\\ :)\n");
//help-end
        }
    }
// main-function-end

}