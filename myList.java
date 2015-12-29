import java.util.*;

/**represents a list which will be able to be searched
Exposed methods include addItem,get, mySequentialSearch and myBinarySearch
mySequentialSearch and myBinarySearch are not implemented - that is currently 
your job

*/
public class myList
    {
   int [] L;
   int ndx = 0;
   int size;
   
   public myList(int size)
   {
       this.size = size;
       L = new int[size];
      }
 
      
      public void addItem(int val)
    {
        L[ndx] = val;
        ndx++;
    }
    
    public int get(int pos)
        {
            return L[pos];
        }
    
    //sequential Search
    public int seqSearch(int searchval)
    {
       //Start at the beginning of the list, and then compare consecutive items in list until the item is found
       //or the end of the list is encountered  - the code block below gives a good start
       
        int pos = 0;
        boolean found = false;
        
        while ((!(found) && (pos < size)))
            {
               System.out.println("Currently checking item number " + pos);     
               
               if (L[pos] == searchval)
                 found = true;
               else
                 found = false;
               pos++;
            }
       if(found ==false)
            pos = -1;
       return pos;
    }
    //Binary Search
   public int binSearch(int searchval,int first,int last)
    {
       //System.out.println("You need to do some work to get the binary search to work ");   
       //If the list is not empty,Split the list in halves(then depending on the comparison 
       //between the searchval or the middle of the list, either search the first of second half.
       // The code block below could be a good start
       
        int middle;
        
        if (first >last)
            return -1;
        
        System.out.println("Currently checking list starting at " + first + " and ending at " + last);
        middle = (int) (first +last)/2;
	if ((first-last) == 1 || (first-last) == -1)
	    return -1;
        if (middle ==size)
            //would try to access data beyond last position
            return -1;
        if (searchval == L[middle])
                return middle;
        else 
	{
            if(searchval > L[middle])
                return binSearch(searchval, middle, last);
            else //searchval < L[middle]
                return binSearch(searchval, first, middle);
	}
        
       //return -1;
     }
  }
