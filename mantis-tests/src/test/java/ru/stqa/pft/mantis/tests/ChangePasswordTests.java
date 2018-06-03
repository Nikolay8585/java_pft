package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.UserData;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ChangePasswordTests extends TestBase {

    @BeforeMethod
    public void startMailServer() {
        app.mail().start();
    }

    @Test
    public void testChangePassword() throws IOException, MessagingException {
        List<UserData> users = app.db().users();
        UserData user = users.iterator().next();
        System.out.println(user);
        String userName = user.getUserName();
        String email = user.getEmail();
        String newPassword = "Password" + System.currentTimeMillis();
        app.login().loginAs("administrator", "root");
        app.admin().resetPassForUser(userName);
        List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
        String confirmationLink = fineConfirmationLink(mailMessages, email);
        app.registration().finish(confirmationLink, newPassword);
        assertTrue(app.newSession().login(userName, newPassword));

    }

    private String  fineConfirmationLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }

    @AfterMethod(alwaysRun = true)
    public void stopMailServer() {
        app.mail().stop();
    }
}
