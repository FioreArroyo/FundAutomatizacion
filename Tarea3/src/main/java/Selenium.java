import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium {
    private WebDriver driver;
    private String url;
    private String browser;

    public Selenium (String url, String browser){
        this.url = url;
        this.browser = browser;
    }

    public void abrirBrowser(String browser){
        if (browser.equals("Chrome")){
            System.setProperty("webdriver.chrome.driver","./src/main/resources/ChromeDriver/chromedriver.exe");
            driver=new ChromeDriver();
            driver.manage().window().maximize();
        }
    }

    public void cerrarBrowser(){

        driver.quit();
    }

    public void abrirUrl(String url){

        driver.get(url);
    }

}
