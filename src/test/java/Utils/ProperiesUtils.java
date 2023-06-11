package Utils;

import java.io.*;
import java.util.Properties;

public class ProperiesUtils {
    public  static Properties loadProperties(String filePath) {
        File file = new File(filePath);
        try {
            InputStream inputStream = new FileInputStream(file);
            Properties properties= new Properties();
            properties.load(inputStream);
            inputStream.close();
            return properties;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("the file not found");
        }
        catch (IOException e) {
            throw new RuntimeException("error while reading");
        }

    }


}
