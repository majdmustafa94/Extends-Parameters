import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyTest extends Parameters {

    @Test()
    public  void check_the_title(){
        String Actual_Title= driver.getTitle();
        Mysoftassert.assertEquals(Actual_Title,Expected_Title);
        Mysoftassert.assertAll();
    }

    @Test()
    public  void check_the_image_slider(){

        List<WebElement> slider= driver.findElements(By.className("d-block"));

        boolean image_check1= slider.get(0).getAttribute("src")==slider.get(1).getAttribute("src");
        boolean image_check2= slider.get(1).getAttribute("src")==slider.get(2).getAttribute("src");
        boolean image_check3= slider.get(2).getAttribute("src")==slider.get(0).getAttribute("src");

        Mysoftassert.assertEquals(image_check1,false,"image1 with image2");
        Mysoftassert.assertEquals(image_check2,false,"image2 with image3");
        Mysoftassert.assertEquals(image_check3,false,"image3 with image1");

        Mysoftassert.assertAll();
    }

    @Test()
    public void validate_the_contact() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        String Email[]={"m1@gmail.com","m2gmail.com","m3@gmail","m4@gmail.jo"};
        Random Email_index= new Random();
        int index= Email_index.nextInt(4);

        driver.findElement(By.xpath("//*[@id=\"navbarExample\"]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"recipient-email\"]")).sendKeys(Email[index]);
        Thread.sleep(1000);

        String myvalue= driver.findElement(By.xpath("//*[@id=\"recipient-email\"]")).getAttribute("value");
        System.out.println(myvalue);

        String regex= "^[A-Za-z0-9+_.-]+@(.+)+\\.(.+)$";
        Pattern p= Pattern.compile(regex);
        Matcher m= p.matcher(Email[index]);

        System.out.println(Email[index]+" is valid email : "+m.matches());

        boolean input_email= m.matches();

        Mysoftassert.assertEquals(input_email,true);
        Mysoftassert.assertAll();
    }

}
