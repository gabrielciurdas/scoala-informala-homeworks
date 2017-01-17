package ro.siit.java5.homework7;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * The Unit Tests class for GenericQuickSort class.
 * 
 * @author Gabriel Ciurdas
 *	<p> Date: 16.01.2017
 */
public class GenericQuickSortTest {

	@Test
	public void sortArrayOfNumbers() {
		Integer [] array = new Integer []{1, 6, 3, 7, 8, 4, 9, 1, 2};
		GenericQuickSort gQuickSort = new GenericQuickSort();
		
		Integer [] actual = array.clone();
		gQuickSort.quickSort(actual, 0, actual.length - 1);
	
		Integer [] expected = new Integer[] {1, 1, 2, 3, 4, 6, 7, 8, 9};
		
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void sortArrayOfStrings() {

		String [] stringArray = new String [] {"Ciprian", "Patrick", "Andrei", 
				"Sorin", "Dana", "Alina", "Radu", "George", "Adi", "Bogdan"};
		GenericQuickSort gQuickSort = new GenericQuickSort();
		
		String [] actual = stringArray.clone();
		gQuickSort.quickSort(actual, 0, actual.length - 1);
	
		String [] expected = new String[] {"Adi", "Alina", "Andrei", "Bogdan", "Ciprian",
				"Dana", "George", "Patrick", "Radu", "Sorin"};
		
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
		GenericQuickSort gQuickSort = new GenericQuickSort();
		
		Movie [] actual = movies.clone();
		gQuickSort.quickSort(actual, 0, actual.length - 1);
	
		Movie [] expected = new Movie[] { movie4, movie2, movie5, movie3, movie1};
		
		Assert.assertArrayEquals(expected, actual);
	}
}
