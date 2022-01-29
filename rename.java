// ataullha saim 2018331081
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class rename {

    public static void main(String[] args) throws IOException {


        Path source = Paths.get(args[0]);
       // Path target = Paths.get(args[0]);

        try {
            Files.move(source,source.resolveSibling(args[1]), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            System.out.println("Exception :(");
        }


        // rename a directory
        // rename a file
        
    }
    
}
