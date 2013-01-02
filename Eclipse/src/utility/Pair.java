package utility;


/**@author marc.comino
 * Clase que un pair de elementos genéricos.
 */

public class Pair<FirstType, SecondType> implements Comparable<Pair<FirstType, SecondType>> {
   
   private FirstType first;
   private SecondType second;
   
   public Pair(FirstType first, SecondType second) {
       this.first = first;
       this.second = second;
   }

   public Pair() {
   }

   public FirstType getFirst() {
	   return first;
   }
   
   public void setFirst(FirstType f) {
	   first = f;
   }
   
   public SecondType getSecond() {
	   return second;
   }
   
   public void setSecond(SecondType s) {
	   second = s;
   }
   
   @Override
   public int compareTo(Pair<FirstType, SecondType> p) {
       int comp = compare(first, p.first);
       return comp == 0 ? compare(second, p.second) : comp;
   }
   
   @SuppressWarnings("unchecked")
   @Override
   public boolean equals(Object o) {
	   Pair<FirstType, SecondType> p = (Pair<FirstType, SecondType>) o;
       if (this == p) return true;
       boolean eqfirst = (p.first == null ? false : (this.first == p.first || this.first.equals(p.first)));
       if (eqfirst) return (p.second == null ? false : (this.second == p.second || this.second.equals(p.second)));
       else return false;
   }
   
   @Override
   public String toString() {
       return "(" + (first==null ? "null" : first.toString()) + ", " + (second==null ? "null" : second.toString()) + ')';
   }
   
   //--------------------------private---------------------------------
   
   @SuppressWarnings({ "unchecked", "rawtypes" })
   protected int compare(Object o1, Object o2) {
       return o1 == null ? o2 == null ? 0 : -1 : o2 == null ? +1 : ((Comparable) o1).compareTo(o2);
   }

}