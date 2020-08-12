package dao.impl;

import dao.AccountDao;
import entity.Account;
import mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao {
    @Autowired
    AccountMapper mapper;
    @Override
    public Account getAccount(String accountID) {
        return mapper.getAccount(accountID);
    }

    @Override
    public int setBalance(Account account) {
        return mapper.setBalance(account);
    }
}
