package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {
 //   private WebDriver driver;
    private By emailAddress= By.name("Email");
    private By password=By.id("inputPassword");
    private  By Login=By.id("btnLogin");
    public LoginPage(WebDriver driver){
       // this.driver=driver;
    	
    	super(driver);
    }
    public Home_Page Login(String email,String password){
        getEmail(email);
        getPassword(password);
        driver.findElement(Login).click();
        return new Home_Page(driver);
    }
    private void getEmail(String email){
        driver.findElement(emailAddress).sendKeys(email);
    }
    private void getPassword(String passwordEmail){
        driver.findElement(password).sendKeys(passwordEmail);
    }

}
