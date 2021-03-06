import java.util.Comparator; 

/**
* @author Leticia Garcia
* @version 2.1.2021
*/

public class Term implements Comparable<Term> {
   
   private String QueryT;
   private long weightT;
   
/**
* Initialize a term with the given query and weight.
* This method throws a NullPointerException if query is null,
* and an IllegalArgumentException if weight is negative.
*/
   public Term(String query, long weight) {
      if (query == null) {
         throw new NullPointerException();
      }
      if (weight < 0) {
         throw new IllegalArgumentException();
      }
      QueryT = query;
      weightT = weight;
   }
   
/**
* Compares the two terms in descending order of weight.
*/
   public static Comparator<Term> byDescendingWeightOrder() {
      return 
         new Comparator<Term>() {
         
            @Override
            public int compare(Term a, Term z) {
               if (a.getWeightT() < z.getWeightT()) {
                  return 1;
               }
               if (a.getWeightT() > z.getWeightT()) {
                  return -1;
               }
               return 0;
            }
         };
   }
   
/**
* Compares the two terms in ascending lexicographic order of query,
* but using only the first length characters of query. This method
* throws an IllegalArgumentException if length is less than or equal
* to zero.
*/
   public static Comparator<Term> byPrefixOrder(int length) {
      if (length <= 0) {
         throw new IllegalArgumentException();
      }
      return 
         new Comparator<Term>() {
            @Override
            public int compare(Term a, Term z) {
               if (a.getQueryT().length() < length || z.getQueryT().length() < length) {
                  return a.compareTo(z);
               }
               return a.getQueryT().substring(0, length).compareTo(z.getQueryT().substring(0, length));
            }
         };
   }
   
/**
* Compares this term with the other term in ascending lexicographic order
* of query.
*/
   @Override
   public int compareTo(Term other) {
      return this.getQueryT().compareTo(other.getQueryT());
   }
   
/**
* Returns a string representation of this term in the following format:
* query followed by a tab followed by weight
*/
   @Override
   public String toString() {
      return getQueryT() + "\t" + getWeightT();
   }

   private String getQueryT() {
      return QueryT;
   }
   private long getWeightT() {
      return weightT;
   }

}
