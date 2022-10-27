package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Componentes {
    private WebDriver driver;

    public void inicializa() {
        String chromeDriver = System.getProperty("user.dir") + "/Driver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriver);

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("file:///" + System.getProperty("user.dir") + "/Driver/componentes.html");
    }
}
