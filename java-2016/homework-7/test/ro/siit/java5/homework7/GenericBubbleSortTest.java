package ro.siit.java5.homework7;

import org.junit.Assert;
import org.junit.Test;


public class GenericBubbleSortTest {

	@Test
	public void sortArrayOfNumbers() {
		Integer [] array = new Integer []{1, 3, 2, 4, 6, 3 , 4, 1, 2};
		GenericBubbleSort bubbleSort = new GenericBubbleSort();
		
		Integer [] actual = bubbleSort.sortArray(array);
	
		Integer [] expected = new Integer[] {1, 1, 2, 2, 3, 3, 4, 4, 6};
		
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void sortArrayOfStrings() {

		String [] stringArray = new String [] {"Ciprian", "Andrei", "Dana", "Alina"};
		GenericBubbleSort bubbleSort = new GenericBubbleSort();
		
		String [] actual = bubbleSort.sortArray(stringArray);
	
		String [] expected = new String[] {"Alina", "Andrei", "Ciprian", "Dana"};
		
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void sortArrayOfObjects() {

		Movie movie1 = new Movie("Movie 1", 8.8);
		Movie movie2 = new Movie("Movie 2", 6.3);
		Movie movie3 = new Movie("Movie 3", 8.6);
		Movie movie4 = new Movie("Movie 4", 5.8);
		Movie movie5 = new Movie("Movie 5", 7.1);
		Movie[] movies= new Movie[] { movie1, movie2, movie3, movie4, movie5};
		GenericBubbleSort bubbleSort = new GenericBubbleSort();
		
		Movie [] actual = bubbleSort.sortArray(movies);
	
		Movie [] expected = new Movie[] { movie4, movie2, movie5, movie3, movie1};
		
		Assert.assertArrayEquals(expected, actual);
	}
}
