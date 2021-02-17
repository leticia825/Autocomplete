import java.util.Arrays; 
import java.util.Comparator; 

/** Autocomplete uses the Term and BinarySearch class to provide 
* complete autocomplete functionality for a given set of strings and weights. 
* 
* @author Leticia Garcia
* @version 2.1.2021
*/

public class Autocomplete {

   private Term[] termA;
   
/**
* Initializes a data structure from the given array of terms.
* This method throws a NullPointerException if terms is null.
*/
   public Autocomplete(Term[] terms) {
   
      if (terms == null) {
         throw new NullPointerException();
      }
      
      Arrays.sort(terms);
      termA = terms;
   }
   
/**
* Returns all terms that start with the given prefix, in descending order of weight.
* This method throws a NullPointerException if prefix is null.
*/
   public Term[] allMatches(String prefix) {
   
      if (prefix == null) {
         throw new NullPointerException();
      }
      
      int length = prefix.length();
      Term term = new Term(prefix, 0);
      
      Comparator<Term> comp = termA[0].byPrefixOrder(length);
   
      int firstIndex = BinarySearch.<Term>firstIndexOf(termA, term, comp);
      int lastIndex = BinarySearch.<Term>lastIndexOf(termA, term, comp);     
      
      if (firstIndex == -1 && lastIndex == -1) {
         return new Term[0];
      }
      
      int matchesSize = (lastIndex - firstIndex) + 1;
      Term[] allMatches = new Term[matchesSize];
      
      allMatches = Arrays.copyOfRange(termA, firstIndex, lastIndex+1);
      
      Comparator<Term> comp2 = allMatches[0].byDescendingWeightOrder();
      
      Arrays.sort(allMatches, comp2);
      return allMatches;
   }
   
   public static void main(String[] args) {
      Term[] entry = new Term[8];
      entry[0] = new Term("texas", 1500);
      entry[1] = new Term("tex mex", 1150);
      entry[2] = new Term("tennessee state", 11000);
      entry[4] = new Term("auburn university", 1700);
      entry[5] = new Term("auburn university price", 1800);
      entry[6] = new Term("auburn football", 11000);
      entry[7] = new Term("aubrey song", 1250);
      
      Autocomplete auto = new Autocomplete(entry);
      Term[] found = new Term[8];
      found = auto.allMatches("aubu");
      
      for (Term e : found) {
         System.out.println(e);
      }
   }
}
