package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	private static 	FileInputStream obj_FileInputstream;
	//private static FileOutputStream obj_FileoutputStream;
	private static Properties obj_Properties;
	
	/**
	 * 
	 * @return
	 */
	
	public Properties propertyReader() {

		try {
			obj_FileInputstream=new FileInputStream(System.getProperty("user.dir")+"/config/config.properties");
			//obj_FileoutputStream=new FileOutputStream(System.getProperty("user.dir")+"/config/config.properties");
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
		obj_Properties=new Properties();
		try {
			obj_Properties.load(obj_FileInputstream);
		} catch (IOException e) {
			System.out.println(e);
		}
		
		return obj_Properties;
	}

}
