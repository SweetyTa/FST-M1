package Activities;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class Activity2_test {
    @Test
    public void notEnoughFunds(){
        BankAccount account= new BankAccount(10);
        assertThrows(NotEnoughFundsException.class, () -> account.withdraw(11));
    }

    @Test
    public void enoughFunds(){
        BankAccount account = new BankAccount(100);
        assertDoesNotThrow(() -> account.withdraw(100));

    }
}