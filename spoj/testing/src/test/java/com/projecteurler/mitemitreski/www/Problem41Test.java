package com.projecteurler.mitemitreski.www;

import junit.framework.TestCase;
import org.junit.Test;

public class Problem41Test extends TestCase {
   @Test
    public void testIsPanoDigital() {
        assertTrue(Problem41.isPanoDigital(2143));
    }

    @Test
    public void testbig(){
        assertTrue(Problem41.isPanoDigital(123456789));

    }

}