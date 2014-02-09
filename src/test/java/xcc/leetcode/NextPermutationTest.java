package xcc.leetcode;

import java.util.Arrays;

import org.junit.Test;

public class NextPermutationTest {

	@Test
	public void testNextPermutation() {
		NextPermutation obj = new NextPermutation();
		int[] a = new int[] {1,2,3};
		obj.nextPermutation(a);
		System.out.println(Arrays.toString(a));
	}

}
