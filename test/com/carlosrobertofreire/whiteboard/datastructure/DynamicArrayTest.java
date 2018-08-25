package com.carlosrobertofreire.whiteboard.datastructure;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.carlosrobertofreire.whiteboard.datastructure.DynamicArray;

public class DynamicArrayTest {

	DynamicArray target = null;
	
	@Before
	public void setUp() throws Exception {
		target = new DynamicArray();
	}
	
	@Test
	public void test_add_twoItems_success() {
		target.add(3);		
		target.add(4);
		Assert.assertEquals(2, target.getCapacity());
		Assert.assertEquals(2, target.getSize());
	}
	
	@Test
	public void test_add_fiveItems_success() {
		target.add(3);		
		target.add(4);		
		target.add(1);
		target.add(7);
		target.add(12);
		Assert.assertEquals(8, target.getCapacity());	
		Assert.assertEquals(5, target.getSize());
	}
	
	@Test
	public void test_add_nineItems_success() {
		target.add(3);		
		target.add(4);		
		target.add(1);
		target.add(7);
		target.add(12);		
		target.add(20);
		target.add(21);
		target.add(13);
		target.add(11);
		Assert.assertEquals(16, target.getCapacity());	
		Assert.assertEquals(9, target.getSize());
	}
		
	@Test
	public void test_contains_success() {
		target.add(1);
		target.add(7);
		target.add(12);
		Assert.assertEquals(true, target.contains(12));
		Assert.assertEquals(true, target.contains(1));
		Assert.assertEquals(false, target.contains(13));
		Assert.assertEquals(false, target.contains(5));
	}
	
	@Test
	public void test_get_success() {
		target.add(20);
		target.add(21);
		target.add(13);
		target.add(11);
		Assert.assertEquals(13, target.get(2));
		Assert.assertEquals(11, target.get(3));
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)	
	public void test_get_inputIsInvalid() {
		target.add(20);
		target.add(21);
		target.get(3);
	}

	@Test
	public void test_insert_success() {
		target.add(3);
		target.add(7);
		target.add(1);		
		target.insert(0, 2);
		
		Assert.assertEquals(4, target.getSize());
		Assert.assertEquals(4, target.getCapacity());
		Assert.assertEquals(2, target.get(0));
		Assert.assertEquals(3, target.get(1));
		
		target.insert(1, 6);
		Assert.assertEquals(8, target.getCapacity());
		Assert.assertEquals(1, target.get(4));
		Assert.assertEquals(2, target.get(0));
		
		target.insert(4, 8);
		Assert.assertEquals(1, target.get(5));
		Assert.assertEquals(8, target.get(4));
		
		target.insert(6, 15);
		Assert.assertEquals(1, target.get(5));
		Assert.assertEquals(15, target.get(6));		
		Assert.assertEquals(8, target.getCapacity());
		
	}
	
	@Test
	public void test_insert_firstIndex_success() {
		target.add(3);
		target.add(7);
		target.add(1);		
		target.insert(0, 2);
		
		Assert.assertEquals(4, target.getSize());
		Assert.assertEquals(4, target.getCapacity());
		Assert.assertEquals(2, target.get(0));
		Assert.assertEquals(3, target.get(1));	
	}
	
	@Test
	public void test_insert_lastItem_success() {
		target.add(3);
		target.add(7);
		target.add(1);		
		target.insert(2, 2);
		
		Assert.assertEquals(4, target.getSize());
		Assert.assertEquals(4, target.getCapacity());
		Assert.assertEquals(2, target.get(2));
		Assert.assertEquals(1, target.get(3));	
	}
	
	@Test
	public void test_insert_middleIndex_success() {
		target.add(3);
		target.add(7);
		target.add(1);
		target.add(2);
		target.add(4);
		target.add(5);
		target.add(10);
		target.add(6);
		target.add(12);
		Assert.assertEquals(16, target.getCapacity());
		
		target.insert(4, 2);
		Assert.assertEquals(2, target.get(4));
		Assert.assertEquals(4, target.get(5));
		Assert.assertEquals(12, target.get(9));
		
	}
	
	@Test
	public void test_insert_emptyIndex_success() {
		target.add(3);
		target.add(7);
		target.add(1);		
		target.insert(3, 2);
		
		Assert.assertEquals(4, target.getSize());
		Assert.assertEquals(4, target.getCapacity());
		Assert.assertEquals(2, target.get(3));
		Assert.assertEquals(1, target.get(2));	
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void test_insert_inputsAreInvalid() {
		target.add(3);
		target.add(7);
		target.insert(3, 2);
	}

	@Test
	public void test_delete_oneTime_success() {
		target.add(3);
		Assert.assertEquals(1, target.getSize());
		
		target.delete(0);
		Assert.assertEquals(0, target.getSize());
		Assert.assertEquals(1, target.getCapacity());
	}
	
	@Test
	public void test_delete_twoTimes_success() {
		target.add(5);
		target.add(7);
		Assert.assertEquals(2, target.getSize());
		Assert.assertEquals(2, target.getCapacity());
		
		target.add(1);
		Assert.assertEquals(3, target.getSize());
		Assert.assertEquals(4, target.getCapacity());
		
		target.delete(2);
		Assert.assertEquals(7, target.get(1));
		Assert.assertEquals(4, target.getCapacity());
		
		target.delete(1);
		Assert.assertEquals(1, target.getSize());
		Assert.assertEquals(2, target.getCapacity());
	}
	
	@Test
	public void test_delete_firstItem_success() {
		target.add(5);
		target.add(10);
		target.add(12);
		target.add(9);
		Assert.assertEquals(4, target.getSize());
		Assert.assertEquals(12, target.get(2));
		
		target.delete(0);
		Assert.assertEquals(10, target.get(0));
		Assert.assertEquals(12, target.get(1));
		Assert.assertEquals(9, target.get(2));
		Assert.assertEquals(3, target.getSize());
	}
	
	@Test
	public void test_delete_lastItem_success() {
		target.add(5);
		target.add(10);
		target.add(12);
		target.add(9);
		Assert.assertEquals(4, target.getSize());
		Assert.assertEquals(12, target.get(2));
		
		target.delete(3);
		Assert.assertEquals(5, target.get(0));
		Assert.assertEquals(10, target.get(1));
		Assert.assertEquals(12, target.get(2));
		Assert.assertEquals(3, target.getSize());
	}
		
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void test_delete_inputIsInvalid() {
		target.add(3);
		target.add(7);
		target.delete(3);
	}

}
