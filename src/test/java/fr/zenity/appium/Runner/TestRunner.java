package fr.zenity.appium.Runner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {
                "./src/test/resources/features",
                "./src/test/resources/features/sc01",
                "./src/test/resources/features/sc02",
                "./src/test/resources/features/btv",
                "./src/test/resources/features/demo",
                "./src/test/resources/features/sTest",
        },
        monochrome = true,
        glue = {"fr.zenity.appium.stepDefinitions"},
        plugin = {
                "pretty",
                "html:target/reports/html/htmlreport",
                "json:target/reports/jsonreports/index.json",
                "junit:target/reports/xmlreport.xml",
                "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"
        }
)
public class TestRunner extends BaseRunner{
}