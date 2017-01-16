package ro.siit.java5.homework7;

/**
 * Keeps a record of a movie Title and its IMDB Rating.
 * 
 * @author Gabriel Ciurdas
 * <p> Date: 16.01.2017
 */
public class Movie implements Comparable<Movie>{
	
	private String title = "";
	private double ratingIMDB = 0;

	public Movie(String title, double ratingIMDB) {
			validateTitle(title);
			validateRating(ratingIMDB);
	}

	public double getRatingIMDB() {
		return ratingIMDB;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", ratingIMDB=" + ratingIMDB + "]";
	}

	@Override
	public int compareTo(Movie movie) {
		return Double.compare(this.ratingIMDB, movie.ratingIMDB);
	}
	
	private void validateTitle(String title) {
		if(title.length() > 0) {
			this.title = title;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	private void validateRating(double ratingIMDB) {
		if(ratingIMDB >= 1 && ratingIMDB <= 10) {
			this.ratingIMDB = ratingIMDB;
		} else {
			throw new IllegalArgumentException("Movie can only be rated between 1 and 10");
		}
	}
}
