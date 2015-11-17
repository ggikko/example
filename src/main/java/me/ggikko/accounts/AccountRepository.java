package me.ggikko.accounts;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Park Ji Hong, ggikko.
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
}
