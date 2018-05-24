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


    @Test
    public void shouldAnswerExp2WithTrue() {
        Exp2 test = new Exp2();
        assertTrue(test.getMinLengthString(new String[]{"dog", "postmaster", "mastermind"}).equals("postmastermindog"));
    }
}
