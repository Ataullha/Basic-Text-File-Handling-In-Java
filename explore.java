/**
 * Reg-No : 2018331081
 * Writer : Md Ataullha Saim
 * Date   : Sat 29 Jan 2022 09:05:21 PM +06
 */

import java.io.File;
import java.nio.file.Files;

import javax.swing.plaf.basic.BasicRootPaneUI; // for color purpose maybe :)

public class explore {

    // for explore a directory/file we need target directory name or address args[0]

    /**
     * compile using : javac explore.java
     * run using : java explore args[0] 
     * @param args
     */

    // ANSI COLOR CODE FOR PRINTING STRING WITH COLORs IN CONSOLE :)
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";

      static void DirectoryTree(File[] fls,int level) {
        for(File f : fls){
                for(int i=0;i<level;i++){ // at every level under a directory
                     System.out.print("|  "); // * There is a '|  '
    }
        System.out.print("|"); // importants
        if(f.isFile()){
            System.out.println("  |-"+f.getName()); // 2 spaces before |-
        } else if(f.isDirectory()) {
            System.out.println("  |-"+ANSI_BLUE+f.getName()+ANSI_RESET); // 2 spaces before |-
            DirectoryTree(f.listFiles(), level+1);
        }
    }
}

    public static void main(String[] args) {
        // explore a directory
        
        String current = "";

        if(args.length==0){
            current = System.getProperty("user.dir");
        }else if(args.length==1){
            current = args[0]+"";
        }else {
            System.out.println("java explore [target_directory]");
            return ;
        }

        File file = new File(current);
        

        System.out.println(ANSI_PURPLE+file.getAbsolutePath()+ANSI_RESET);
        System.out.println("|-"+ANSI_PURPLE+file.getName()+ANSI_RESET);

        if(file.isDirectory()||file.exists()){
            File fls[] = file.listFiles();
            DirectoryTree(fls,0);
        } else {
            System.out.println("Enter a Valid Directory Name!");
        }
    }
}
