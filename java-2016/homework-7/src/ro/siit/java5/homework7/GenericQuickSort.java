package ro.siit.java5.homework7;

/**
 * This class contains general purpose quicksorting algorithm. 
 * The algorithm sorts any type of Comparable objects in a customized way.
 * 
 * @author Gabriel Ciurdas
 * <p> Date: 16.01.2017
 */
public class GenericQuickSort {
	 
	 private <T extends Comparable<T>> Integer partition(T[] arr, Integer left, Integer right)
	 {
	       Integer i = left, j = right;
	       T tmp;
	       T pivot = arr[(left + right) / 2];
	      
	       while (i <= j) {
	             while (arr[i].compareTo(pivot) < 0) 
	                   i++;
	             while (arr[j].compareTo(pivot) > 0)
	                   j--;
	             if (i <= j) {
	                   tmp = arr[i];
	                   arr[i] = arr[j];
	                   arr[j] = tmp;
	                   i++;
	                   j--;
	             }
	       };
	      return i;
	 }
	  
	 public <T extends Comparable<T>> void quickSort(T arr[], Integer left, Integer right) {
	       Integer index = partition(arr, left, right);
	       if (left < index - 1)
	             quickSort(arr, left, index - 1);
	       if (index < right)
	             quickSort(arr, index, right);
	 }
}
