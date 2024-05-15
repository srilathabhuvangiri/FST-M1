import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Activity2 {
    @Test
    void notEnoughFunds(){
        BankAccount b = new BankAccount(9);
        assertThrows(NotEnoughFundsException.class, ()-> b.withdraw(10));
    }

    @Test
    void enoughFunds(){
            // Create an object for BankAccount class
            BankAccount account = new BankAccount(100);

            // Assertion for no exceptions
            assertDoesNotThrow(() -> account.withdraw(100));
    }
}
