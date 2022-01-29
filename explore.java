import java.io.File;
import java.nio.file.Files;

import javax.swing.plaf.basic.BasicRootPaneUI;

public class explore {

    // ANSI COLOR CODE FOR PRINTING STRING WITH COLOR
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";

      static void DirectoryTree(File[] fls,int level) {
        for(File f : fls){
                for(int i=0;i<level;i++){
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
        
        File file = new File(args[0]);
        System.out.println(ANSI_PURPLE+file.getAbsolutePath()+ANSI_RESET);
        System.out.println("|-"+ANSI_PURPLE+file.getName()+ANSI_RESET);
        if(file.isDirectory()||file.exists()){
            File fls[] = file.listFiles();
            DirectoryTree(fls,0);
        }
    }
}
