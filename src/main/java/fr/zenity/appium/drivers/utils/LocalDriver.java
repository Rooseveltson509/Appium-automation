package fr.zenity.appium.drivers.utils;


import fr.zenity.appium.config.Properties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.net.URL;


public class LocalDriver implements DriversImpl {

    protected AppiumDriver<MobileElement> driver;

    public LocalDriver(){
    }

    @Override
    public void close() { driver.close(); }

    @Override
    public void quit() { driver.quit();  }

    @Override
    public AppiumDriver<MobileElement> getDriver() {
        return driver;
    }

    protected URL getWebDriveRemoteUrl(){
        try{
           StringBuffer sb = new StringBuffer();
           return new URL(
                   sb.append("http://")
                   .append(Properties.appConfig.getAppiumServerHost())
                   .append(":")
                   .append(Properties.appConfig.getAppiumServerPort())
                   .append("/wd/hub")
                   .toString()
           );
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
