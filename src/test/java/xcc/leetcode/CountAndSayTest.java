package xcc.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class CountAndSayTest {

	@Test
	public void testCountAndSay() {
		CountAndSay obj = new CountAndSay();
		Assert.assertEquals("1", obj.countAndSay(1));
		Assert.assertEquals("11", obj.countAndSay(2));
		Assert.assertEquals("21", obj.countAndSay(3));
		Assert.assertEquals("1211", obj.countAndSay(4));
		Assert.assertEquals("111221", obj.countAndSay(5));
	}

}
