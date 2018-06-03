package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

public class AdminHelper extends HelperBase {
    public AdminHelper(ApplicationManager app) {
        super(app);
    }

    public void resetPassForUser (String userName) {
        wd.get(app.getProperty("web.baseUrl") + "/manage_user_page.php");
        wd.findElement(By.linkText(userName)).click();
        click(By.cssSelector("input[value=\"Reset Password\"]"));
    }
}
