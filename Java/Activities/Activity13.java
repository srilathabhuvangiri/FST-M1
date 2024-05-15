package Session2;
import java.util.*;

public class Activity13 {

    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        List<Integer> li = new ArrayList<>();
        Random randomIndex = new Random();

        System.out.print("Enter a inter value to add into the list: ");
        System.out.println("Non-Integer value to terminate: ");

        while(scan.hasNextInt()){
            li.add(scan.nextInt());
        }

        Integer a[] = li.toArray(new Integer[0]);
        int index = randomIndex.nextInt(a.length);
        System.out.println("Index value generated: " + index);
        System.out.println("Value in array at generated index: " + a[index]);
        scan.close();
    }
}