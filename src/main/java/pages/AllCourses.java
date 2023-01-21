package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AllCourses extends PageBase {
	
   
    private By addButton= By.id("btnListAddCourse");
    private By load=By.id("spnPhotoCover");
    private By search=By.id("txtCourseSearch");
    
    private By searchBtn=By.xpath("//button[@id='btnCourseSearch']/em");
    
    private By linktitle=By.id("lnkListCourseSelcted");
    public AllCourses(WebDriver driver){
     //   this.driver=driver;
    	
    	super(driver);
    }
    public CreationCoursePage addCourse(){
        driver.findElement(addButton).click();
        return new CreationCoursePage(driver);
    }
    public void searchButton(String text){
   
    	setText(driver.findElement(search), text);
    	click(searchBtn);
    	
    }
    
    public List<String> getCourseName() {
    	
    	return getTextOfWebElemets(driver.findElements(linktitle));
    }
}
