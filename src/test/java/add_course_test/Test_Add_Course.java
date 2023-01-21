package add_course_test;

import bases.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;


public class Test_Add_Course extends BaseTest {

	
	Faker faker = new Faker();
	
	
    @Test
    public void test() throws InterruptedException {
        // add new course
        var homePage=login.Login("testregister@aaa.com","Wakram_123");
        var course_List=homePage.clickON_Courses();
        var new_Course=course_List.addCourse();
       String courseName=faker.book().title();
        new_Course.write_CourseName(courseName);
        new_Course.selectSubject("Others");
        new_Course.selectGrade("2");
        new_Course.selectTeacher();
         var addedCourse=new_Course.click_Save();
        //return to course list page
        homePage.clickON_Courses();
        //Assert the new course added
       course_List.searchButton(courseName);
       
      List<String> actualnames=course_List.getCourseName();
       
     assertTrue(actualnames.contains(courseName));
       
    }
}
