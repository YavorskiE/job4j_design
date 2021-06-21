package ru.job4j;

import org.junit.Assert;
import org.junit.Test;

public class TriggerTest {

    @Test
    public void test() {
        Assert.assertEquals(7, new Trigger().someLogic());
    }
}