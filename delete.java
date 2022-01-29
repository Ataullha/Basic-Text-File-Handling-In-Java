import java.io.File;
import java.nio.file.Path;
import javax.swing.text.html.HTMLDocument.RunElement;
import java.io.File;

public class delete {

    public static void deleteDirectory(File file){

        
        for(File subfile : file.listFiles()){

            if(subfile.isDirectory()){
                try{
                deleteDirectory(subfile);
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }

            subfile.delete();
        }

    }

    public static void main(String[] args) {

        String curDirectory;

        if(args.length==1){
            curDirectory = System.getProperty("user.dir");
            } else {
            curDirectory = args[0];
            args[0] = args[1];  
            }

            File file = new File(curDirectory+"/"+args[0]);

            if(file.isDirectory()){
                deleteDirectory(file);
                file.delete();
            } else if(file.exists()) {
                    file.delete();
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
