package ru.stda.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.sandbox.Point;

public class PointTest {


    @Test
    public void testPoint() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1,5);
        Assert.assertEquals(p1.distance(p2), 3.0);

    }
}
