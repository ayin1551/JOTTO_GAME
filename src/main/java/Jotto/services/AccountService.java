package Jotto.services;

import Jotto.domain.Account;

import java.util.List;

public interface AccountService {
    Account getAccountById(Integer id); //get an account by its id *R
    Account addAccount(Account account); //add account to db *C
    List<Account> getAllAccounts(); //get all accounts in db *R
    Account getAccountByLogin(String username, String password); //gets account by user+pass *R
}