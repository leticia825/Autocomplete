import java.util.Comparator;
import java.util.Arrays; 

/** 
* @author Leticia Garcia
* @version 2.1.2021
*/

public class BinarySearch {

/**
* Returns the index of the first key in a[] that equals the serch key,
* or -1 if no such key exists. This method throws a NullPointerException
* if any parameter is null.
*/
    
   public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
   
      if (a == null || key == null || comparator == null) {
         throw new NullPointerException();
      }
      Arrays.sort(a, comparator);
      
      int firstI = -1;
      int left = 0;
      int right = a.length - 1;
      int middle = 0;
      
      while (left <= right) {
         middle = (left + right) / 2;
         
         if (comparator.compare(key, a[middle]) < 0) {
            right = middle - 1;
         }
         else if (comparator.compare(key, a[middle]) > 0) {
            left = middle + 1;
         }
         else {
            firstI = middle;
            right = middle - 1;
         }
      }
      
      return firstI;
   }
   
/**
* Returns the index of the last key in a[] that equals the search key,
* or -1 if no such key exists. This method throws a NullPointerException
* if any parameter is null.
*/
   public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
   
      if (a == null || key == null || comparator == null) {
         throw new NullPointerException();
      }
      
      Arrays.sort(a, comparator);
      
      int lastI = -1;
      int left = 0;
      int right = a.length - 1;
      int middle = 0;
      while (left <= right) {
         middle = (left + right) / 2;
         if (comparator.compare(key, a[middle]) < 0) {
            right = middle - 1;
         }
         else if (comparator.compare(key, a[middle]) > 0) {
            left = middle + 1;
         }
         else {
            lastI = middle;
            left = middle + 1;
         }
      }
      return lastI;
   }
}
