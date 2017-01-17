package ro.siit.java5.homework7;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * The Unit Tests class for Movie class.
 * 
 * @author Gabriel Ciurdas
 *	<p> Date: 16.01.2017
 */
public class MovieTest {

	@Test(expected = IllegalArgumentException.class)
	public void whenEmptyTitleIsUsed_ExceptionIsThrown() {
		String title = "";
		double ratingIMDB = 7;
		Movie movie = new Movie(title, ratingIMDB);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void whenOutOfRangeRatingIsUsed_ExceptionIsThrown() {
		String title = "some title";
		double ratingIMDB = 10.1;
		Movie movie = new Movie(title, ratingIMDB);
	}
}
