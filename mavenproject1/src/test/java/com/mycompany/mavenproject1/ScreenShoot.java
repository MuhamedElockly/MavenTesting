
package com.mycompany.mavenproject1;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShoot {
    public static void takeShoot(WebDriver driver,String filePath)throws IOException
    {
        TakesScreenshot scrShot=((TakesScreenshot)driver);
        File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(srcFile, new File(filePath));
    }
}
