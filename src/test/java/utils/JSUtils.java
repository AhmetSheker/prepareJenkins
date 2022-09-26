package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JSUtils {
    private static JavascriptExecutor javascriptExecutor;
    public static void scrollIntoView(WebElement element){
        javascriptExecutor = ((JavascriptExecutor)Driver.getDriver());
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
