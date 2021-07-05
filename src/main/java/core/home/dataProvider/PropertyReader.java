package core.home.dataProvider;

import static com.home.utils.Constants.APPLICATION_PROPERTIES;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

	public String getApplicationProperty(String key) throws IOException{
		Properties props = new Properties();
		String sFilePath = System.getProperty("user.dir");
		sFilePath = sFilePath + File.separator + APPLICATION_PROPERTIES;
		FileInputStream fs = new FileInputStream(sFilePath);
		String sVal = "";
		try {
			props.load(fs);
			sVal = props.getProperty(key);
			if (sVal == "") {
				return null;
			}
		} catch (IOException e) {
			
		} finally {
			fs.close();
		}
		return sVal;
	}
}
