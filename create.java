/**
 * Reg-No : 2018331081
 * Writer : Md Ataullha Saim
 * Date   : Sat 29 Jan 2022 08:48:31 PM +06
 */

import java.io.*;
import java.nio.file.*;

class create{

    // for create directory name or address args[0] and 
    //a directory/file we need target directory name or address args[0]  and a file/directory name args[1] will also go

    /**
     * compile using : javac create.java
     * run using : java create args[0] args[1]
     * @param args
     */
    
    public static void main(String[] args){

        String curDirectory;

        if(args.length==1){
        curDirectory = System.getProperty("user.dir");
        } else {
        curDirectory = args[0];
        args[0] = args[1];

        try{
        Paths.get(curDirectory+"/"+args[0]); 
        } catch(Exception e){
            System.out.println("Path Not Valid");
        } 
    }
        
        File file = new File(curDirectory+"/"+args[0]);

        if(args[0].contains(".")){
            try{
            if(file.createNewFile()){
                System.out.println("New File Created at "+curDirectory+"/"+args[0]);
            } else {
                System.out.println("Failed To Create The File at "+curDirectory+"/"+args[0]);
            }
        }catch(Exception e){
                System.out.println("Failed to Create New File!");
                return;
                //e.printStackTrace();
        }
        } else {
            try {
                if(file.mkdir()){
                    System.out.println("New Directory Created at "+curDirectory+"/"+args[0]);
                } else {
                    System.out.println("Failed To Create The Directory at "+curDirectory+"/"+args[0]);
                }
            } catch (Exception e) {
                System.out.println("Failed to Create New Directory!");
                return;
            }
    }
}

}