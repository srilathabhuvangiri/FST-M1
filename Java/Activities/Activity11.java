package Session2;
import java.util.HashMap;
import java.util.Map;

public class Activity11 {
    public static void main(String args[]){
//        Create a Map named colours with integer keys and String values.
        Map<Integer,String> map = new HashMap<>();
//      Add 5 random colours to it and print the Map to the console.
        map.put(1,"Red");
        map.put(4,"Green");
        map.put(2,"Orange");
        map.put(5,"Black");
        map.put(3,"White");
        System.out.println("map items :" +map);
        System.out.println("size of the map :" +map.size());
//    Remove one colour using the remove() method.
        map.remove(2);
        System.out.println("map items :" +map);
//     Check if the colour green exists in the Map using the containsValue() method.
        if(map.containsValue("Green")){
            System.out.println("green color exist in the list");
        } else{
            System.out.println("green color not exist in the list");
        }
// Print the size of the Map using the size() method.
        System.out.println("size of the map :" +map.size());


    }
}
