package com.carlosrobertofreire.whiteboard.datastructure;

import org.junit.Assert;
import org.junit.Before;
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
	public void test_contains_success() {
		String firstWord = "any";
		String secondWord = "anything";
		String thirdWord = "bye";
		String forthWord = "how";
		
		target.insert(firstWord);
		Assert.assertEquals(true, target.contains(firstWord));
		Assert.assertEquals(false, target.contains(secondWord));
		Assert.assertEquals(false, target.contains(thirdWord));
		Assert.assertEquals(false, target.contains(forthWord));
		
		target.insert(secondWord);
		Assert.assertEquals(true, target.contains(firstWord));
		Assert.assertEquals(true, target.contains(secondWord));
		Assert.assertEquals(false, target.contains(thirdWord));
		Assert.assertEquals(false, target.contains(forthWord));
		
		target.insert(forthWord);
		Assert.assertEquals(true, target.contains(firstWord));
		Assert.assertEquals(true, target.contains(secondWord));
		Assert.assertEquals(false, target.contains(thirdWord));
		Assert.assertEquals(true, target.contains(forthWord));
	}
	
	@Test
	public void test_contains_targetIsEmpty() {
		Assert.assertEquals(false, target.contains("house"));
	}
	
	@Test
	public void test_contains_inputIsNull() {
		Assert.assertEquals(false, target.contains(null));
	}

	@Test
	public void test_delete_targetWithDifferentWords_success() {
		String anyWord = "any";
		String carWord = "car";
		String dadWord = "dad";
			
		target.insert(anyWord);
		target.insert(carWord);
		target.insert(dadWord);
		
		Assert.assertEquals(true, target.contains(anyWord));
		Assert.assertEquals(true, target.contains(carWord));
		Assert.assertEquals(true, target.contains(dadWord));
		
		target.delete(dadWord);
		Assert.assertEquals(true, target.contains(anyWord));
		Assert.assertEquals(true, target.contains(carWord));
		Assert.assertEquals(false, target.contains(dadWord));
		
		target.delete(carWord);
		Assert.assertEquals(true, target.contains(anyWord));
		Assert.assertEquals(false, target.contains(carWord));
		
		target.delete(anyWord);
		Assert.assertEquals(false, target.contains(anyWord));
	}
	
	@Test
	public void test_delete_shortFirst_targetWithRelatedWords_success() {
		String carWord = "car";
		String cardWord = "Card";
		String cabWord = "CAB";
				
		target.insert(carWord);
		target.insert(cardWord);
		target.insert(cabWord);
		
		target.delete(carWord);
		Assert.assertEquals(false, target.contains(carWord));
		Assert.assertEquals(true, target.contains(cardWord));
		Assert.assertEquals(true, target.contains(cabWord));
		
		target.delete(cabWord);
		Assert.assertEquals(true, target.contains(cardWord));
		Assert.assertEquals(false, target.contains(cabWord));		
	}
	
	@Test
	public void test_delete_longFirst_targetWithRelatedWords_success() {
		String anythingWord = "anything";
		String anyWord = "any";
		String antWord = "CAB";
				
		target.insert(anythingWord);
		target.insert(anyWord);
		target.insert(antWord);
		
		target.delete(anythingWord);
		Assert.assertEquals(false, target.contains(anythingWord));
		Assert.assertEquals(true, target.contains(anyWord));
		Assert.assertEquals(true, target.contains(antWord));
		
		target.delete(anyWord);
		Assert.assertEquals(false, target.contains(anyWord));
		Assert.assertEquals(true, target.contains(antWord));		
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_delete_inputIsNull() {
		target.insert("test");
		target.delete(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_delete_inputIsInvalid() {
		target.insert("test");
		target.delete("Itnull is invalid");
	}

	@Test(expected = IllegalStateException.class)
	public void test_delete_targetIsEmpty() {
		target.delete("empty");
	}
}
