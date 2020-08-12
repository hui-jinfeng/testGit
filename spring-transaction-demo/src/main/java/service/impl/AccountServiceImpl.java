package service.impl;

import dao.AccountDao;
import entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.AccountService;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao dao;

    @Override
    public Account getAccount(String accountID) {
        return dao.getAccount(accountID);
    }

    @Override
    @Transactional
    public void transfer(String inAccountID, String outAccountID, int count) {
        Account acocunt1 = dao.getAccount(outAccountID);
        Account account2 = dao.getAccount(inAccountID);
        //1转账给2
        acocunt1.setBalance(acocunt1.getBalance().subtract(new BigDecimal(count)));
        account2.setBalance(account2.getBalance().add(new BigDecimal(count)));
        dao.setBalance(acocunt1);
        dao.setBalance(account2);
    }
}
