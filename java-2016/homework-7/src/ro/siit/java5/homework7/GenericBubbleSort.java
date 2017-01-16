package ro.siit.java5.homework7;

/**
 * This class contains general purpose quicksorting algorithm. 
 * The algorithm sorts any type of Comparable objects in a customized way.
 * 
 * @author Gabriel Ciurdas
 * <p> Date: 16.01.2017
 */
public class GenericBubbleSort {

	/**
	 * Takes an array of objects and compares each pair of adjacent items 
	 * and swaps them if they are in the wrong order.
	 * 
	 * @param array is the collection of object to be sorted.
	 * @return the sorted array.
	 */
	public <T extends Comparable<T>> T[] sortArray(T[] array) {
		if (array == null) {
			throw new IllegalArgumentException("Array must not be null.");
		}
		if (array.length == 0) {
			throw new IllegalArgumentException("Array must not be empty.");
		}
		boolean sorted = false;
		while (!sorted) {
			sorted = true;
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i].compareTo(array[i + 1])>0) {
					T temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					sorted = false;
				}
			}
		}
		return array;
	}
}
