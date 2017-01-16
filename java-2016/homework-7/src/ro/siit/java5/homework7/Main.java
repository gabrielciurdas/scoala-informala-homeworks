package ro.siit.java5.homework7;
import java.util.Arrays;

/**
 * The Main Class for the generic bubblesort algorithm.
 * 
 * @author Gabriel Ciurdas
 * <p> Date: 16.01.2017
 */
public class Main {

	/**
	 * The Main method.
	 * 
	 * @param args represents the command line arguments.
	 */
	public static void main(String[] args) {
		GenericBubbleSort genericBubbleSort = new GenericBubbleSort();
		Integer [] integerArray = new Integer []{3,2,1,5, 7, 1 , 2, 3, 6};
		Integer [] sortedIntArray = genericBubbleSort.sortArray(integerArray);
		System.out.println(Arrays.toString(sortedIntArray));
		
		String [] stringArray = new String [] {"Bogdan", "Alin", "Cristina", "Andreea"};
		String [] sortedStrArray = genericBubbleSort.sortArray(stringArray);
		System.out.println(Arrays.toString(sortedStrArray));
		
		Movie[] movies= new Movie[] {
				new Movie("The Dark Knight", 9),
				new Movie("Bruce Almighty", 6.7),
				new Movie("Interstellar", 8.6),
				new Movie("Inception", 8.8),
				new Movie("Star Wars VII - The Force Awakens", 8.1),
		};
		
		Movie[] sortedMovies = genericBubbleSort.sortArray(movies);
		System.out.println(Arrays.toString(sortedMovies));
	}
}
