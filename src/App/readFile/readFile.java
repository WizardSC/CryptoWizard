package App.readFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Administrator
 */
public class readFile {
    
    public static String readTextFromFile(String filePath) {
        // ham doc file text
        StringBuilder content = new StringBuilder();
      
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
      
        return content.toString();
    }
}
