package www.projecteurler.mitemitreski;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EulerUtilTest {

    @Test
    public void testIsPalindrome() throws Exception {

        assertTrue(EulerUtil.isPalindrome("ama"));
        assertTrue(EulerUtil.isPalindrome("10101"));

    }

    @Test
    public void isNotPaling() throws Exception {

        assertFalse(EulerUtil.isPalindrome("mite"));

    }

    @Test
    public void permuteTest() {
        System.out.println(EulerUtil.permutation("ABC"));

    }
}