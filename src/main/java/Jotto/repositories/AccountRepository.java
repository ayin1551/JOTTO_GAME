package Jotto.repositories;

import Jotto.domain.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Integer> {
    public Account findAccountByUsernameAndPassword(String username, String password);

}