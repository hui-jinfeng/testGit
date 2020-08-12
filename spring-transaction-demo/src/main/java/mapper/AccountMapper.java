package mapper;

import entity.Account;

import java.math.BigDecimal;

public interface AccountMapper {
    Account getAccount(String accountID);
    int setBalance(Account account);
}
