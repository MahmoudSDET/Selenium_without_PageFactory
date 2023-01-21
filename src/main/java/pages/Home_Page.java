package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home_Page extends PageBase {

    private By courses= By.id("btnMyCoursesList");
    public Home_Page(WebDriver driver){
      //  this.driver=driver;
    	
    	super(driver);
    }
    public AllCourses clickON_Courses(){
      //  driver.findElement(courses).click();
        click(courses);
    	
        return new AllCourses(driver);
    }
}
