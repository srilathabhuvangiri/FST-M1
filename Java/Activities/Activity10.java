package Session2;
import java.util.HashSet;
import java.util.Set;

public class Activity10 {

    public static void main(String args[]){
        //Create a HashSet named hs.
        //Add 6 objects using add() method to the HashSet.
       Set<String> set = new HashSet<>();
       set.add("Blue");
        set.add("Orange");
        set.add("Black");
        set.add("White");
        set.add("Orange");
        set.add("Red");
        set.add("Green");
        set.add("Orange");
        set.add(null);
        System.out.println(set);

//    Then print the size of the HashSet using the size() method.
        System.out.println("size of the HashSet :" +set.size());
//    Remove an element using the remove() method.
        set.remove("Green");
        System.out.print("Values in Set: ");
        for(String i: set){
            System.out.print(i +" ,");
        }
        System.out.println("");
//    Also try to remove an element that is not present in the Set.
       if(set.remove("Greens")){
           System.out.println("Greens removed from the set");
       }
       else{
           System.out.println("Greens is not present in the set");
       }
//    Use the contains() method to check if an item is in the Set or not.
        System.out.println("Check item in the HashSet :" +set.contains("Orange"));
//    Print the updated set.
        System.out.print("Updated Set: ");
        for(String i: set){
            System.out.print(i +" ,");
        }
}

}