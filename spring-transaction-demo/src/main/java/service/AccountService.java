package service;

import entity.Account;
import org.springframework.stereotype.Service;

public interface AccountService {
    Account getAccount(String accountID);
    void transfer(String inAccountID,String outAccountID,int count);
}
