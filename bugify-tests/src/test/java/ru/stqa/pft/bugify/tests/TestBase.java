package ru.stqa.pft.bugify.tests;

import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.bugify.appmanager.ApplicationManager;

import java.io.IOException;
import java.math.BigInteger;

public class TestBase {

    protected static final ApplicationManager app
            = new ApplicationManager();

    public void skipIfNotFixed(int issueId) throws IOException {
        if (isIssueOpen(issueId)) {
            throw new SkipException("Ignored because of issue " + issueId);
        }
    }

    public boolean isIssueOpen(int issueId) throws IOException {
        int state = app.rest().getIssue(issueId).getState();
        int open = 0;
        int inProgress = 1;
        return state == open || state == inProgress;
    }

}
