import java.io.*;
import java.nio.file.*;

// https://stackoverflow.com/a/26214647/13870040

public class copy {

    public static void copyFolder(File source, File destination){
        
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
                    out.write(buffer,0,length); // https://docs.oracle.com/javase/7/docs/api/java/io/OutputStream.html
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
                return;
            }
            System.out.println("Successful!");
    }

    public static void main(String[] args) {
        String source = args[0];
        File srcDir = new File(source);
        
        String destination = args[1];
        File destDir = new File(destination);

        if(args[0].contains(".")){
            copyFile(args[0],args[1]);
        } else {
        copyFolder(srcDir, destDir);
        }

    }
}