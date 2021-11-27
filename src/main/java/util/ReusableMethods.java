package util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ReusableMethods {
	
	public void modifyPropertyFile(String outputFile, String propertyKey,String propertyValue) {
		 
		try {
			
		
		PropertyReader obj_PropetyReader=new PropertyReader();
		Properties value1 =obj_PropetyReader.propertyReader();
		
		
		value1.setProperty(propertyKey,propertyValue);
		
		
		FileOutputStream fos =new FileOutputStream(outputFile);
		try {
			value1.store(fos, "browser changed");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println(value1.getProperty("url"));
		try {
			
			fos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
}
		
	}

}
