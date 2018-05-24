package com.infoworks.devj;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class ExpTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerExp1WithTrue() {
        Exp1 test = new Exp1();
        assertTrue(test.getMaxIncDecSeqValue(new Integer[]{1, 7, 4, 9, 5, 3, 8, 7, 2,}) == 6);
    }
}
