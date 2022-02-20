package fr.zenity.appium.drivers.utils;

import fr.zenity.appium.config.Properties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public interface DriversImpl {

    void close();

    void quit();

    AppiumDriver<MobileElement> getDriver();

    default DesiredCapabilities getAndroidCapabilities(){
        DesiredCapabilities cap = new DesiredCapabilities();

        /*cap.setCapability(MobileCapabilityType.APP, Properties.appConfig.getAndroidApplicationPath());
        cap.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
        cap.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
        cap.setCapability(AndroidMobileCapabilityType.VERSION, "1.0");
        cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        cap.setCapability(AndroidMobileCapabilityType.PLATFORM_NAME, "android");
        cap.setCapability(MobileCapabilityType.NO_RESET, false);
        cap.setCapability(MobileCapabilityType.AUTO_WEBVIEW, true);
        //cap.setCapability(MobileCapabilityType.ACCEPT_INSECURE_CERTS, "true");
        //cap.setCapability(MobileCapabilityType.SUPPORTS_APPLICATION_CACHE, "true");
        cap.setCapability(MobileCapabilityType.SUPPORTS_LOCATION_CONTEXT, true);*/

        cap.setCapability(MobileCapabilityType.APP, Properties.appConfig.getAndroidApplicationPath());
        cap.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
        cap.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
        cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        cap.setCapability(MobileCapabilityType.NO_RESET, false);


        return cap;
    }

}
