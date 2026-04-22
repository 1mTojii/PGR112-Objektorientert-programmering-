package DTBS;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DTBSpropertyprovider {
    public static final Properties properties;

    static {
        properties = new Properties();

        try{properties.load(new FileInputStream("application.properties"));
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
