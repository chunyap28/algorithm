package string;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class StringMatcherTest {

    @Test
    public void testMatchDirectOrPalindromic() {
        StringMatcher matcher = new StringMatcher();
        List<Integer> indexes = matcher.matchDirectOrPalindromic("abbabbb", "ab");

        Assert.assertEquals(indexes, Arrays.asList(0,2,3));
    }
}