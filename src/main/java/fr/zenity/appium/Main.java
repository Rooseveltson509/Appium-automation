package fr.zenity.appium;

import fr.zenity.appium.Enum.Device;
import fr.zenity.appium.Enum.Plateform;
import fr.zenity.appium.drivers.AndroidConnector;
import fr.zenity.appium.server.AppiumServer;

import java.net.MalformedURLException;

public class Main {

    public static void main(String[] args) throws MalformedURLException {

        System.out.println(AppiumServer.isRunning());
        AppiumServer.start();

        //AndroidDriver aDriver = new AndroidDriver( new URL("http://127.0.0.1:4723/wd/hub/"), new DesiredCapabilities());
         AndroidConnector androidConnector = new AndroidConnector(Device.SAMSUMG, Plateform.ANDROID);
        try {
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            System.out.println(e.getLocalizedMessage());
            //e.printStackTrace();
        }
        androidConnector.quit();
        //aDriver.quit();
        AppiumServer.Stop();
        /*if(AppiumServer.isRunning())AppiumServer.Stop();
        AppiumServer.start();
        MobileDriverManager
                .getInstance()
                .setDriver(Device.SAMSUMG, Plateform.ANDROID);
        try{ Thread.sleep(5000); }
        catch (Exception e){
            MobileDriverManager.getInstance()
                    .getDriver()
                    .quit();
        }
        MobileDriverManager.getInstance()
                .getDriver()
                .quit();
        AppiumServer.Stop();*/
    }
}
