import org.junit.Test;


public class LongestCommonPrefixTest {
	@Test
    public void testLongestCommonPrefix() throws Exception {
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		lcp.longestCommonPrefix(new String[]{"","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"});
    }
}
