package lt.codeacademy.api.controller;

import static lt.codeacademy.api.ApiPath.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import lt.codeacademy.api.entity.Account;
import lt.codeacademy.api.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ACCOUNTS)
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<Account> getAccounts() {
        return accountService.getAccounts();
    }

    @GetMapping(value = ACCOUNT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Account getAccount(@PathVariable(ID_VARIABLE)String accountId) {
        return accountService.getAccount(accountId);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody Account account) {
        accountService.createAccount(account);
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateProduct(@RequestBody Account account) {
        accountService.updateAccount(account);
    }


}
