package Session2;

public class Activity12 {
    public static void main(String args[]) {
        Addable ad = (int num1, int num2) -> {
        return num1+num2;
        };
        System.out.println("Add 2 numbers :"+ ad.add(4, 8)) ;

        Addable ad2 = (a,b) ->(a+b);
        System.out.println("Add 2 numbers :"+ ad2.add(32, 7)) ;

    }
}
