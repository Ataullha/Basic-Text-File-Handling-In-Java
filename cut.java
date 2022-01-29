import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class cut {

    public static void main(String[] args) throws IOException {


        Path source = Paths.get(args[0]);
        Path target = Paths.get(args[1]);

        try {
            Files.move(source, target.resolve(source.getFileName()), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            System.out.println("Exception :(");
        }
        
        // cut a directory
        // cut a file
    }
    
}
