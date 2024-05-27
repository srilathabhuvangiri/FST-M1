import org.testng.SkipException;
import org.testng.annotations.Test;

public class SkipTestCase {
    @Test
    public void skipTest() throws SkipException {
        String condition = "Skip Test1";

        if (condition.equals("Skip Test")) {
            throw new SkipException("Skipping - This is not ready for testing ");
        } else {
            System.out.println("Test executed successfully ");
        }
    }
}
