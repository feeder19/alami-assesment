package Config;

import org.openqa.selenium.WebDriver;
import java.util.Properties;

public class env_target extends targetPropertiesFile {
  //  protected static WebDriver driver ;
    protected String projectPath = System.getProperty("user.dir");
    protected String os = System.getProperty("os.name");
    protected String data_env = "prod";
    protected Properties tfile = targetPropertiesFile.readPropertiesFile(projectPath + "\\src\\test\\java\\Data\\" + data_env + "-env.properties");
}
