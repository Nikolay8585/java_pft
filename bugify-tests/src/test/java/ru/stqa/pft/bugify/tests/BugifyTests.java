package ru.stqa.pft.bugify.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.bugify.model.Issue;

import java.io.IOException;
import java.util.Set;

public class BugifyTests extends TestBase {

    @Test
    public void testBugify() throws IOException {
        skipIfNotFixed(19);
        Issue issue = app.rest().getIssue(1);
        System.out.println(issue);
        Set<Issue> issues = app.rest().getIssues();
        for (Issue i : issues) {
            System.out.println(i);
        }

    }
}
