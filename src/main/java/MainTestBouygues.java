import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class MainTestBouygues {
    WebDriver driver;

    DesiredCapabilities caps = new DesiredCapabilities();

    @BeforeTest
    public void InitConfig(){
        caps.setCapability("deviceName", "Pixel_11");
        caps.setCapability("platformName", "Android");
        caps.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
        caps.setCapability(CapabilityType.VERSION, "9");
    }

    @Test
    public void testApp() throws MalformedURLException  {
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4854/wd/hub"), caps);
        driver.get("https://www.bouyguestelecom.fr/tv-direct/");
    }

}
