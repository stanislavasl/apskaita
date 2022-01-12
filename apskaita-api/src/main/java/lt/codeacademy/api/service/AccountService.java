package lt.codeacademy.api.service;

import lt.codeacademy.api.entity.Account;
import lt.codeacademy.api.exception.AccountNotFoundException;
import lt.codeacademy.api.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void createAccount(Account account) {
        accountRepository.save(account);
    }

    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccount(String id) {
        return accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException(id));
    }

    public void updateAccount(Account account) {
        accountRepository.save(account);
    }

}
