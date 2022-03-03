package fr.zenity.appium.drivers;

import fr.zenity.appium.Enum.Device;
import fr.zenity.appium.Enum.Plateform;
import fr.zenity.appium.drivers.utils.LocalDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.util.Objects;

public class AndroidConnector extends LocalDriver {


    public AndroidConnector(Device device, Plateform platform) throws MalformedURLException {
        super();
        Objects.requireNonNull(device);
        Objects.requireNonNull(platform);

        DesiredCapabilities cap = this.getAndroidCapabilities();

        // avd
        cap.setCapability("deviceName",device.toString());
        cap.setCapability("platformName",platform.toLowerCase());
        // other
       /* First application package*/
        //cap.setCapability("appPackage","com.webviewexample")
        /* Second application package*/;
        cap.setCapability("appPackage","com.example.shop_app");
        cap.setCapability("automationName","UiAutomator2");

/*        // avd
        cap.setCapability("deviceName",device.toString());
        cap.setCapability("platformName",platform.toLowerCase());
        //cap.setCapability("platformVersion","1.0");
        // other
        cap.setCapability("appPackage","com.webviewexample");
       // cap.setCapability("appPackage","com.example.shop_app");
        cap.setCapability("automationName","UiAutomator1");
        //cap.setCapability("fullContextList","true");
        cap.setCapability("autoWebview",true);
        cap.setCapability("autoWebviewTimeout","20000");
        cap.setCapability("appActivity",".MainActivity");
        cap.setCapability("autoGrantPermissions",true);
        cap.setCapability("ignoreHiddenApiPolicyError",true);*/

        //driver = new AndroidDriver<>( new URL("http://127.0.0.1:4877/wd/hub/"), cap);

        driver = new AndroidDriver<>( super.getWebDriveRemoteUrl(), cap);

        driver.context("NATIVE_APP");
    }

}
