/**
  OrderedList_inArraySlots, holding Integers

  A list with the invariant the elements are in order by
  increasing value, implemented using a
  ArrayList<Integer>
 */

public class OrderedList_inArraySlots
    implements OrderedList {

    private java.util.ArrayList<Integer> list_iAS;


    /**
      @return the index of the first occurrence of 
              \findMe in this list, or -1 if
              \findMe is absent from this list.
     */
    public int indexOf( Integer findMe) {
        // return indexOfWhileStyle( findMe);
        return indexOfRecursive( 0, size()-1, findMe);
    }
    
    /** 
      while style indexOf
     */
    private int indexOfWhileStyle( Integer findMe){
        
        int loLimit = 0;
        int hiLimit = size() - 1;
        int pageToCheck;
        
        for( pageToCheck = (loLimit + hiLimit)/2
           ; loLimit <= hiLimit
           ; pageToCheck = (loLimit + hiLimit)/2
           ){
               int comparison = list_iAS.get(pageToCheck).compareTo( findMe);
                    if (comparison == 0) return pageToCheck;
               else if (comparison < 0) loLimit = pageToCheck + 1;
               else                     hiLimit = pageToCheck - 1;

           }
        
        
        return -1;
    }
    
    private int indexOfRecursive( int loLimit, int hiLimit, Integer findMe){
        int pageToCheck = (loLimit + hiLimit)/2;
        
        // if element cannot be found (special case)
        if (loLimit > hiLimit) return -1;
        
        // base case: if name on page IS the name you want
        if ( list_iAS.get(pageToCheck) == findMe) return pageToCheck;
        
        // recursive case(s)
        else {
            // if name is smaller, do the search on bottom half
            if (list_iAS.get(pageToCheck).compareTo(findMe) < 0) 
                return indexOfRecursive( pageToCheck + 1, hiLimit, findMe);
            // if name is greater,do the search on top half
            else return indexOfRecursive( loLimit, pageToCheck - 1, findMe);
        }
    }
    

    // ------ code from previous assignments below here ----

    public OrderedList_inArraySlots() {
        list_iAS = new java.util.ArrayList<Integer>();
    }

    /**
      @return the number of elements in this list
     */
    public int size(){
        return list_iAS.size();
    }

    /**
      @return a string representation of this Orderedlist_iAS
     */
    public String toString() {
        return list_iAS.toString();
    }


    /**
      Put @value where it belongs in the list.
      @pre: the list is in increasing order
     */
     public boolean add( Integer value) {
         int dest = 0;
         for( ; dest < list_iAS.size() && list_iAS.get( dest) < value
              ; dest++) ;
         // System.out.println( "OL adding " + value
         //                   + " at index " + dest);
         list_iAS.add( dest, value);
         return true;
     }


     /**
      @return element @index from this list
      precondition: @index is within the bounds of the array.
          (Having warned the user about this precondition,
           you should NOT complicate your code to check
           whether the condition was violated.)
     */
    public Integer get( int index ) {
        return list_iAS.get( index);
    }


    /**
      Remove the element at position @index in this list.

      Shift any subsequent elements to the left (that is,
      decrease the index associated with each).

      @return the value that was removed from the list
     */
    public Integer remove( int index) {
        return list_iAS.remove( index);
    }
}
