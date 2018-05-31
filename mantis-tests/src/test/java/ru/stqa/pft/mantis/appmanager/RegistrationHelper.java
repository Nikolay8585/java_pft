package ru.stqa.pft.mantis.appmanager;

import com.sun.javafx.binding.ExpressionHelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationHelper extends HelperBase{

    public RegistrationHelper(ApplicationManager app) {
        super(app);
    }

    public void start (String username, String email) {
        wd.get(app.getProperty("web.baseUrl") + "/signup_page.php");
        type(By.name("username"), username);
        type(By.name("email"), email);
        click(By.xpath("//form[@id='signup-form']/fieldset/input[2]"));
        //click(By.cssSelector("input[value=\"Зарегистрироваться\"]"));
    }

    public void finish(String confirmationLink, String password) {
        wd.get(confirmationLink);
        type(By.name("password"), password);
        type(By.name("password_confirm"), password);
        click(By.xpath("//span[@class='submit-button']//button[normalize-space(.)='Update User']"));
        //click(By.cssSelector("span[value='Update User']"));
    }
}
