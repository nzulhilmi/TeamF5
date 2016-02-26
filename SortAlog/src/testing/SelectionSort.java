package testing;

import java.util.ArrayList;
public class SelectionSort {


    /**
     * @param args the command line arguments
     * @author Simmi
     */
    public static void main(String[] args) {
     ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(10);
        list.add(6);
        list.add(1);
        list.add(7);
        list.add(9);
        list.add(4);
        list.add(2);
        list.add(5);
        list.add(8);

        int length = list.size();
        ArrayList<Integer> sorted = SelectionSort(list, length);
        System.out.println(sorted);
        
    }

    public static ArrayList<Integer> SelectionSort(ArrayList list, int length) {
        ArrayList<Integer> unsorted = list;
        int ListLength=length;
      
        for (int i = 0; i < length - 1; i++) {
          
            for (int j = i + 1; j < length; j++) {
                
                if (unsorted.get(j) < unsorted.get(i)) {
                  
                
                    int lower = unsorted.get(j);
                   // System.out.println(lower);
                    int higher=unsorted.get(i);
                   // System.out.println(higher);
                    unsorted.set(i,lower );
                    unsorted.set(j, higher);
                    
                    System.out.println("LIST STATUS: "+unsorted);
                    SelectionSort(unsorted,ListLength);
                    

                }
            }

        }
        return  unsorted;
    }
}
