package dao;

import entity.Account;

public interface AccountDao {
    Account getAccount(String accountID);
    int setBalance(Account account);
}
