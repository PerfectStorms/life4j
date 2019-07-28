package org.perfectstorms.life4j.types;

import org.junit.Assert;
import org.junit.Test;

public class LifeCellTest {

    @Test
    public void isLive() {
        Assert.assertTrue(new LifeCell().isLive());
    }
}