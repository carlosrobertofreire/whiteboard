package com.carlosrobertofreire.whiteboard.datastructure;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class TrieTest {
	
	Trie target = null;

	@Before
	public void setUp() throws Exception {
		target = new Trie();
	}

	@Test
	public void test_insert_success() {
		String firstWord = "ant";
		target.insert(firstWord);		
		Assert.assertEquals(true, target.contains(firstWord));
		
		String secondWord = "how";
		target.insert(secondWord);
		Assert.assertEquals(true, target.contains(firstWord));
		Assert.assertEquals(true, target.contains(secondWord));
				
		String thirdWord = "house";
		target.insert(thirdWord);
		Assert.assertEquals(true, target.contains(firstWord));
		Assert.assertEquals(true, target.contains(secondWord));
		Assert.assertEquals(true, target.contains(thirdWord));
				
		String forthWord = "anything";
		target.insert(forthWord);
		Assert.assertEquals(true, target.contains(firstWord));
		Assert.assertEquals(true, target.contains(secondWord));
		Assert.assertEquals(true, target.contains(thirdWord));
		Assert.assertEquals(true, target.contains(forthWord));
						
		String fifthWord = "any";
		target.insert(fifthWord);
		Assert.assertEquals(true, target.contains(firstWord));
		Assert.assertEquals(true, target.contains(secondWord));
		Assert.assertEquals(true, target.contains(thirdWord));
		Assert.assertEquals(true, target.contains(forthWord));
		Assert.assertEquals(true, target.contains(fifthWord));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_insert_inputIsNull() {
		target.insert(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_insert_inputIsEmpty() {
		target.insert("");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_insert_inputIsInvalid() {
		target.insert("What is?");
	}

	@Test
	@Ignore
	public void test_contains_success() {
		fail("Not yet implemented");
	}
	
	@Test
	@Ignore
	public void test_contains_error() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void test_delete_success() {
		fail("Not yet implemented");
	}
	
	@Test
	@Ignore
	public void test_delete_inputIsNull() {
		fail("Not yet implemented");
	}
	
	@Test
	@Ignore
	public void test_delete_inputIsInvalid() {
		fail("Not yet implemented");
	}

}
