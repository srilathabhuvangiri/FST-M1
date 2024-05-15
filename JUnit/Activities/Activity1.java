import org.junit.jupiter.api.*;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class Activity1 {
    static ArrayList<String> li;
    @BeforeEach
    void setUp()  {
        li = new ArrayList<>();
        li.add("Alpha");
        li.add("Beta");
        System.out.println("This is setUp");
    }

    @Test
    void insertTest(){
        assertEquals(2,li.size(),"Wrong size");
        li.add(2,"Gama");
        assertEquals(3,li.size(),"Wrong size");
        // Assert individual elements
        assertEquals("Alpha", li.get(0), "Wrong element");
        assertEquals("Beta", li.get(1), "Wrong element");
        assertEquals("Gama", li.get(2), "Wrong element");
    }

    @Test
    void replaceTest(){
        li.set(1,"Gama");
        assertEquals(2,li.size(),"Wrong size");

        assertEquals("Alpha",li.get(0),"Wrong element");
        assertEquals("Gama",li.get(1),"Wrong element");
    }
}
