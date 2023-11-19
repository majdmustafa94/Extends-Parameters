import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Parameters {

    public WebDriver driver;
    String MyURL="https://www.demoblaze.com/index.html#";
    SoftAssert Mysoftassert= new SoftAssert();
    String Expected_Title= "STORE";

    @BeforeTest()
    public void pre_my_test(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(MyURL);

    }
}
