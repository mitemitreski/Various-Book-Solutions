/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mite
 */
public class EulerUtilTest {

    public EulerUtilTest() {
    }



    @Test
    public void testIsPrime() {
        System.out.println("isPrime");
        System.out.println(Math.sqrt(2021));
        boolean expResult = false;
        boolean result = EulerUtil.isPrime(2021);
        assertEquals(expResult, result);

    }
}
