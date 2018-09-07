package com.carlosrobertofreire.whiteboard.datastructure;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HashtableTest {

	Hashtable target = null;

	@Before
	public void setUp() throws Exception {
		target = new Hashtable(10);
	}

	@Test
	public void test_put_success() {
		String firstKey = "Dog";
		target.put(firstKey, 7);
		target.put("Cat", 3);
		target.put("Lion", 1);
		Assert.assertEquals(true, target.containsKey(firstKey));
		Assert.assertEquals(false, target.containsKey("Bear"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_put_inputIsNull() {
		target.put(null, 2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_put_inputIsInvalid() {
		target.put("  ", 1);
	}

	@Test
	public void test_get_success() {
		String firstKey = "Bear";
		String secondKey = "Lion";
		target.put(firstKey, 3);
		Assert.assertEquals(3, target.get(firstKey));
		target.put(secondKey, 15);
		Assert.assertEquals(15, target.get(secondKey));
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_get_inputIsNull() {
		target.get(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_get_inputIsInvalid() {
		target.get("");
	}

	@Test
	public void test_containsKey_success() {
		String firstKey = "Dog";
		String secondKey = "Fly";
		String thirdKey = "Pig";

		target.put(firstKey, 7);
		Assert.assertEquals(true, target.containsKey(firstKey));

		target.put(secondKey, 3);
		Assert.assertEquals(true, target.containsKey(secondKey));

		target.put(thirdKey, 1);
		Assert.assertEquals(true, target.containsKey(thirdKey));

		Assert.assertEquals(false, target.containsKey("Bear"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_containsKey_inputIsNull() {
		target.containsKey(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_containsKey_inputIsInvalid() {
		target.containsKey("");
	}

	@Test
	public void test_delete_success() {
		String firstKey = "Dog";
		String secondKey = "Fly";
		String thirdKey = "Pig";

		target.put(firstKey, 7);
		target.put(secondKey, 3);
		target.put(thirdKey, 1);

		Assert.assertEquals(true, target.containsKey(secondKey));

		target.delete(secondKey);

		Assert.assertEquals(false, target.containsKey(secondKey));
		Assert.assertEquals(true, target.containsKey(firstKey));
		Assert.assertEquals(true, target.containsKey(thirdKey));
		Assert.assertEquals(7, target.get(firstKey));
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_delete_inputIsNull() {
		target.delete(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_delete_inputIsInvalid() {
		target.delete("");
	}

}
