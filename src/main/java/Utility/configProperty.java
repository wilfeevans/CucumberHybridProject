package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configProperty 
{
	public static Properties initializingProperty() throws IOException
	{
	Properties prop= new Properties();
	File file= new File("./src/test/resources/Config/config.properties");
	FileInputStream fis= new FileInputStream(file);
	prop.load(fis);
	return prop;
	
	}

}
