package com.carlosrobertofreire.whiteboard.datastructure;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {
	
	LinkedList target = null;

	@Before
	public void setUp() throws Exception {
		target = new LinkedList();
	}
	
	@Test
	public void test_append_targetIsEmpty_success() {
		target.append(3);
		Assert.assertEquals(3, target.getHead().data);
		Assert.assertEquals(3, target.getTail().data);
	}
	
	@Test
	public void test_append_targetWithOneItem_success() {
		target.append(2);
		Assert.assertEquals(2, target.getHead().data);
		Assert.assertEquals(2, target.getTail().data);
		target.append(3);
		Assert.assertEquals(2, target.getHead().data);
		Assert.assertEquals(3, target.getTail().data);		
	}
	
	@Test
	public void test_append_targetWithTwoItems_success() {
		target.append(2);
		target.append(3);
		Assert.assertEquals(2, target.getHead().data);
		Assert.assertEquals(3, target.getTail().data);
		target.append(1);
		Assert.assertEquals(1, target.getTail().data);
	}
	
	@Test
	public void test_prepend_targetIsEmpty_success() {
		target.prepend(3);
		Assert.assertEquals(3, target.getHead().data);
		Assert.assertEquals(3, target.getTail().data);
	}
	
	@Test
	public void test_prepend_targetWithOneItem_success() {
		target.append(2);
		Assert.assertEquals(2, target.getHead().data);
		Assert.assertEquals(2, target.getTail().data);
		target.prepend(3);
		Assert.assertEquals(3, target.getHead().data);
		Assert.assertEquals(2, target.getTail().data);		
	}
	
	@Test
	public void test_prepend_targetWithTwoItems_success() {
		target.append(8);
		target.append(1);
		Assert.assertEquals(8, target.getHead().data);
		target.prepend(4);
		Assert.assertEquals(4, target.getHead().data);
		Assert.assertEquals(1, target.getTail().data);
	}

	@Test
	public void test_contains_targetIsEmpty_success() {
		Assert.assertEquals(false, target.contains(3));
	}
	
	@Test
	public void test_contains_targetWithFourItems_success() {
		target.append(2);
		target.append(20);
		target.append(3);
		target.append(1);
		Assert.assertEquals(true, target.contains(2));
		Assert.assertEquals(false, target.contains(7));
		Assert.assertEquals(true, target.contains(1));
	}
	
	@Test
	public void test_contains_targetWithOneItem_success() {
		target.append(20);
		Assert.assertEquals(true, target.contains(20));
		Assert.assertEquals(false, target.contains(7));
		Assert.assertEquals(false, target.contains(1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_get_targetIsEmpty() {
		target.get(0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_get_inputIsInvalid() {
		target.append(15);
		target.append(3);
		target.get(-3);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_get_inputDoesNotExist() {
		target.append(15);
		target.append(3);
		target.get(4);
	}
	
	@Test
	public void test_get_targetWithOneItem_success() {
		target.append(5);
		Assert.assertEquals(5, target.get(0));		
	}
	
	@Test
	public void test_get_targetWithFourItem_success() {
		target.append(5);
		target.append(15);
		target.append(7);
		target.append(8);
		Assert.assertEquals(7, target.get(2));
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_insert_targetIsEmpty() {
		target.insert(0, 4);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_insert_indexIsInvalid() {
		target.append(15);
		target.insert(-3, 4);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_insert_indexDoesNotExist() {
		target.append(15);
		target.append(1);
		target.insert(2, 4);
	}
	
	@Test
	public void test_insert_targetWithOneItem_success() {
		target.append(7);
		Assert.assertEquals(7, target.getHead().data);
		Assert.assertEquals(7, target.getTail().data);
		target.insert(0, 3);
		Assert.assertEquals(3, target.getHead().data);
		Assert.assertEquals(3, target.get(0));
		Assert.assertEquals(7, target.getTail().data);
	}
	
	@Test
	public void test_insert_targetWithThreeItems_success() {
		target.append(7);
		target.append(5);
		target.append(8);
		target.insert(2, 3);
		Assert.assertEquals(3, target.get(2));
		target.insert(0, 1);
		target.insert(2, 5);
		Assert.assertEquals(5, target.get(2));
		target.insert(1, 9);
		Assert.assertEquals(1, target.get(0));
		Assert.assertEquals(1, target.getHead().data);
		Assert.assertEquals(9, target.get(1));
		Assert.assertEquals(5, target.get(3));
		Assert.assertEquals(8, target.getTail().data);		
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_delete_targetIsEmpty() {
		target.delete(0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_delete_indexIsInvalid() {
		target.delete(-8);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_delete_indexDoesNotExist() {
		target.append(2);
		target.delete(1);
	}
	
	@Test
	public void test_delete_targetWithOneItem_success() {
		target.append(7);
		Assert.assertEquals(7, target.getHead().data);
		Assert.assertEquals(7, target.getTail().data);
		target.delete(0);
		Assert.assertEquals(null, target.getHead());
		Assert.assertEquals(null, target.getTail());
	}
	
	@Test
	public void test_delete_targetWithThreeItems_success() {
		target.append(7);
		target.append(2);
		target.append(9);
		Assert.assertEquals(7, target.getHead().data);
		Assert.assertEquals(9, target.getTail().data);
		target.delete(2);
		Assert.assertEquals(7, target.getHead().data);
		Assert.assertEquals(2, target.getTail().data);
		target.delete(1);
		Assert.assertEquals(7, target.getHead().data);
		Assert.assertEquals(7, target.getTail().data);
		target.delete(0);
		Assert.assertEquals(null, target.getHead());
		Assert.assertEquals(null, target.getTail());
		
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_deleteByData_targetIsEmpty() {
		target.deleteByData(43);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_deleteByData_inputIsInvalid() {
		target.deleteByData(-8);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_deleteByData_inputDoesNotExist() {
		target.append(2);
		target.deleteByData(1);
	}
	
	@Test
	public void test_deleteByData_targetWithOneItem_success() {
		target.append(7);
		Assert.assertEquals(7, target.getHead().data);
		Assert.assertEquals(7, target.getTail().data);
		target.deleteByData(7);
		Assert.assertEquals(null, target.getHead());
		Assert.assertEquals(null, target.getTail());
	}
	
	@Test
	public void test_deleteByData_targetWithThreeItems_success() {
		target.append(7);
		target.append(2);
		target.append(9);
		Assert.assertEquals(7, target.getHead().data);
		Assert.assertEquals(9, target.getTail().data);
		target.deleteByData(9);
		Assert.assertEquals(7, target.getHead().data);
		Assert.assertEquals(2, target.getTail().data);
		target.deleteByData(2);
		Assert.assertEquals(7, target.getHead().data);
		Assert.assertEquals(7, target.getTail().data);
		target.deleteByData(7);
		Assert.assertEquals(null, target.getHead());
		Assert.assertEquals(null, target.getTail());
		
	}


}
