package testing;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test implementation for insertion sort. Test 3 cases of inputs:
 * reversed, sorted, and random.
 * @author nik
 *
 */
public class InsertionSortTest {
	private InsertionSort s;
	
	private ArrayList<Integer> input1;
	private ArrayList<Integer> input2;
	private ArrayList<Integer> input3;
	
	private ArrayList<Integer> output;
	
	@Before
	public void setUp() throws Exception {
		s = new InsertionSort();
		
		//add output1 elements
		output = new ArrayList<Integer>();
		output.add(1);
		output.add(2);
		output.add(3);
		output.add(4);
		output.add(5);
		output.add(6);
		output.add(7);
		output.add(8);
		output.add(9);
		output.add(10);
	}

	@Test
	public void testReverse() {
		//add input1 elements [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
		input1 = new ArrayList<Integer>();
		input1.add(10);
		input1.add(9);
		input1.add(8);
		input1.add(7);
		input1.add(6);
		input1.add(5);
		input1.add(4);
		input1.add(3);
		input1.add(2);
		input1.add(1);
		
		int n = s.algorithm(input1).size() - 1;
		
		assertEquals(s.algorithm(input1).get(n), output);
	}
	
	@Test
	public void testSorted() {
		//add elements to input2 [1,2,3,4,5,6,7,8,9,10]
		input2 = new ArrayList<Integer>();
		input2.add(1);
		input2.add(2);
		input2.add(3);
		input2.add(4);
		input2.add(5);
		input2.add(6);
		input2.add(7);
		input2.add(8);
		input2.add(9);
		input2.add(10);
		
		int n = s.algorithm(input2).size() - 1;
		
		assertEquals(s.algorithm(input2).get(n), output);
	}
	
	@Test
	public void testRandom() {
		//add elements to input3 [8,2,4,10,1,3,5,7,9,6]
		input3 = new ArrayList<Integer>();
		input3.add(8);
		input3.add(2);
		input3.add(4);
		input3.add(10);
		input3.add(1);
		input3.add(3);
		input3.add(5);
		input3.add(7);
		input3.add(9);
		input3.add(6);
		
		int n = s.algorithm(input3).size() - 1;
		
		assertEquals(s.algorithm(input3).get(n), output);
	}

}
