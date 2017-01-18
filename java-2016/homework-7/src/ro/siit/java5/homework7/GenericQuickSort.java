package ro.siit.java5.homework7;

/**
 * This class contains general purpose quicksorting algorithm. 
 * The algorithm sorts any type of Comparable objects in a customized way.
 * 
 * @author Gabriel Ciurdas
 * <p> Date: 16.01.2017
 */
public class GenericQuickSort {
	 
	 private <T extends Comparable<T>> Integer partition(T[] array, Integer left, Integer right)
	 {
	       Integer i = left, j = right;
	       T tmp;
	       T pivot = array[(left + right) / 2];
	      
	       while (i <= j) {
	             while (array[i].compareTo(pivot) < 0) 
	                   i++;
	             while (array[j].compareTo(pivot) > 0)
	                   j--;
	             if (i <= j) {
	                   tmp = array[i];
	                   array[i] = array[j];
	                   array[j] = tmp;
	                   i++;
	                   j--;
	             }
	       };
	      return i;
	 }
	  
	 /**
	  * A generic quicksort algorithm. Takes as an input any type of comparable object.
	  * Firstly, it reorders the array so that all elements with values less than the pivot 
	  * come before the pivot, while all elements with values greater than the pivot come 
	  * after it (equal values can go either way). After this partitioning, the pivot is
	  * in its final position.
	  * Finally, the same method is called recursively and applied to the sub-array of elements
	  *  with smaller values and separately to the sub-array of elements with greater values.
	  * 
	  * @param array is the array of comparable objects.
	  * @param left is the lower limit of the array.
	  * @param right is the higher limit of the array.
	  */
	 public <T extends Comparable<T>> void quickSort(T array[], Integer left, Integer right) {
	       Integer index = partition(array, left, right);
	       if (left < index - 1)
	             quickSort(array, left, index - 1);
	       if (index < right)
	             quickSort(array, index, right);
	 }
}
