package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class CreationCoursePage extends PageBase {
	
	public CreationCoursePage(WebDriver driver) {
		
			super(driver);
	}
   
    private By courseName=By.id("txtCourseName");
    private By subjects=By.id("courseSubject");

    private By selectGrade=By.id("courseGrade");

    private By courseTeacher=By.xpath("//div[@id='teacherOnBehalf']/div/span/span");

    private By savedButton=By.id("btnSaveAsDraftCourse");
  
    //Write course name
    public void write_CourseName(String text)  {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(courseName).sendKeys(text);
    }
    //choose subject
    public void selectSubject(String option){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        findDropDownElement(subjects).selectByVisibleText(option);
    }
    //Select Grade/year
    public void selectGrade(String option){
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        findDropDownElement(selectGrade).selectByVisibleText(option);
    }

    //Select courseTeacher
    public void selectTeacher() throws InterruptedException {
        driver.findElement(courseTeacher).click();
        Thread.sleep(5);
        driver.findElement(By.id("lnkCourseOwnerMail")).click();
    }

    //click save
    public AddedCourse click_Save() throws InterruptedException {
    	
      click(savedButton);
       
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(savedButton)));
        return new AddedCourse(driver);
    }

    private Select findDropDownElement(By locator){
        return new Select(driver.findElement(locator));
    }
}
