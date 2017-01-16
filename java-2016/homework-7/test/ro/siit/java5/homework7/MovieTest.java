package ro.siit.java5.homework7;

import static org.junit.Assert.*;

import org.junit.Test;


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
