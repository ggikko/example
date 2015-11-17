package me.ggikko.accounts;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Park Ji Hong, ggikko.
 */
public class AccountTest {

    @Test
    public void getterSetter(){
        Account account = new Account();
        account.setUsername("ggikko");
        account.setPassword("password");

        assertThat(account.getUsername(), is("ggikko"));
    }
}
