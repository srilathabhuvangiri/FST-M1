package Session2;

import java.util.ArrayList;
import java.util.List;

public class Activity9 {
    public static void main(String args[]){
        List<String> li = new ArrayList<>();
        li.add("maths");
        li.add("science");
        li.add("Social");
        li.add(1,"English");
        li.add(4,"Hindi");
        System.out.println(li);
//Print array using loops
        for(String i: li){
            System.out.println(i);
        }
 //Then use get() method to retrieve the 3rd name in the ArrayList.
        System.out.println(li.get(3));

//Use contains() method to check if a name exists in the ArrayList.
        System.out.println("Check English in the list: "+ li.contains("English"));
//Use size() method to print the number of names in the ArrayList.
        System.out.println("ArrayList size: "+ li.size());
//Use remove() method to remove a name from the list and print the size() of the list again.
        li.remove("Hindi");
        System.out.println("After removing a value from ArrayList : "+ li);
        System.out.println("Size of the Array after removing a value from List :" +li.size());

        li.remove(1);
        System.out.println("After removing a value from ArrayList : "+ li);
        System.out.println("Size of the Array after removing a value from List :" +li.size());
    }
}
