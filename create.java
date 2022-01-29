import java.io.*;
import java.nio.file.*;

class create{
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
                e.printStackTrace();
        }
        } else {
        if(file.mkdir()){
            System.out.println("New Directory Created at "+curDirectory+"/"+args[0]);
        } else {
            System.out.println("Failed To Create The Directory at "+curDirectory+"/"+args[0]);
        }
    }
}

}