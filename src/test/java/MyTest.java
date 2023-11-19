import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

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

}
