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
		GenericQuickSort genericQuickSort = new GenericQuickSort();
		Integer [] integerArray = new Integer[] {3,2,1,5, 7, 1 , 2, 3, 6};
		genericQuickSort.quickSort(integerArray, 0, integerArray.length - 1);
		//displayItems(integerArray);
		System.out.println(Arrays.toString(integerArray));
		
		String [] stringArray = new String [] {"Bogdan", "Alin", "Cristina", "Andreea"};
		genericQuickSort.quickSort(stringArray, 0, stringArray.length - 1);
		//displayItems(items);
		System.out.println(Arrays.toString(stringArray));
		
		Movie[] movies= new Movie[] {
				new Movie("The Dark Knight", 9),
				new Movie("Turks In Space", 1.8),
				new Movie("Bruce Almighty", 6.7),
				new Movie("The Shawshank Redemption", 9.2),
				new Movie("Interstellar", 8.6),
				new Movie("Girl in Gold Boots", 2.5),
				new Movie("Inception", 8.8),
				new Movie("Star Wars VII - The Force Awakens", 8.1),
				new Movie("Santa Claus Conquers the Martians", 2.6),
				new Movie("The Last Five Years" , 5.9)
				
		};
		
		genericQuickSort.quickSort(movies, 0, movies.length - 1);
		displayItems(movies);
	}
	public static <T> void displayItems(T[] items) {
		for (T t : items) {
			System.out.println(t.toString());
		}
	}
}
